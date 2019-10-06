package io.javaclasses.expression.statemachine;

import io.javaclasses.expression.Expression;
import io.javaclasses.expression.operator.Operator;

import java.util.*;

public class Context implements StateMachineContext<State, Double> {

    private State state;
    private final Expression expressionReader;

    private final Deque<Double> operandStack = new ArrayDeque<>();
    private final Deque<Operator> operatorStack = new ArrayDeque<>();
    private final Deque<ElementOfBracketStack> bracketStack = new ArrayDeque<>();


    public Context(String expression) {
        expressionReader = new Expression(expression);
    }

    public Expression getExpressionReader() {
        return expressionReader;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void setState(State state) {
        this.state = state;
    }

    public void pushOperand(Double operand) {
        operandStack.push(operand);
    }

    public void pushOperator(Operator operator) {
        Operator topOperator = null;
        do {
            topOperator = operatorStack.peek();

            if ((bracketStack.size() != 0 && operatorStack.size() <= bracketStack.peek().getNumberOperatorsBeforeBracket()))
                break;
            if (topOperator != null) {

                if (operator.compareTo(topOperator) < 1) {
                    executeOperator(topOperator);
                    operatorStack.pop();
                } else {
                    break;
                }
            }

        } while (topOperator != null);

        operatorStack.push(operator);
    }

    private void executeOperator(Operator topOperator) {
        final Double rightOperand = operandStack.pop();
        final Double leftOperand = operandStack.pop();

        final Double result = topOperator.solve(
                leftOperand, rightOperand);

        pushOperand(result);
    }

    public void popOperators() {
        while (!operatorStack.isEmpty()) {
            executeOperator(operatorStack.pop());
        }
    }

    public void pushOpeningBracket() {
        bracketStack.push(new ElementOfBracketStack(operatorStack.size(), getExpressionReader().getPosition()));
    }


    public void pushClosingBracket() {
        if (bracketStack.size() > 0) {

            final int operatorStackSize = bracketStack.pop().getNumberOperatorsBeforeBracket();

            while (operatorStack.size() > operatorStackSize) {
                executeOperator(operatorStack.pop());
            }
        }
    }

    @Override
    public Double getResult() {
        return operandStack.pop();
    }
}

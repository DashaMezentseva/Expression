package io.javaclasses.expression.operator;


import static io.javaclasses.expression.operator.AbstractOperator.Priority.*;

public final class OperatorFactory {

    public Operator createOperator(char representation) {

        switch (representation) {
            case '+':
                return new SumOperator(LOW);
            case '-':
                return new SubstractOperator(LOW);
            case '*':
                return new MultiplyOperator(MEDIUM);
            case '/':
                return new DivideOperator(MEDIUM);
            default:
                return null;
        }
    }
}

package io.javaclasses.expression.operator;

public class DivideOperator extends AbstractOperator {

    public DivideOperator(Priority priority){super(priority);}

    @Override
    public Double solve(Double firstNumber, Double secondNumber) {
        if (secondNumber == 0){
            throw new IllegalArgumentException("Division by zero");
        }
        return firstNumber / secondNumber;
    }
}

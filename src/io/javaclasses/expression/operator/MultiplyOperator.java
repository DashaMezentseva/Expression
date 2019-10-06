package io.javaclasses.expression.operator;

public class MultiplyOperator extends AbstractOperator{

    public MultiplyOperator(Priority priority){super(priority);}

    @Override
    public Double solve(Double firstNumber, Double secondNumber) {
        return firstNumber * secondNumber;
    }
}

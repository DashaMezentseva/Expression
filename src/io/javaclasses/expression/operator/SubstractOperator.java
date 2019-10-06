package io.javaclasses.expression.operator;

public class SubstractOperator extends AbstractOperator{

    public SubstractOperator(Priority priority){super(priority);}

    @Override
    public Double solve(Double firstNumber, Double secondNumber) {
        return firstNumber - secondNumber;
    }
}

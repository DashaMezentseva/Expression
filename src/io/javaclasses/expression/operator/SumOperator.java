package io.javaclasses.expression.operator;

public class SumOperator extends AbstractOperator {

    public SumOperator(Priority priority) {
        super(priority);
    }

    @Override
    public Double solve(Double firstNumber, Double secondNumber) {
        return firstNumber + secondNumber;
    }

}

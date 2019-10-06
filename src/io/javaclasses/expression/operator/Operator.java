package io.javaclasses.expression.operator;

public interface Operator extends Comparable<Operator>{

    Double solve(Double firstNumber, Double secondNumber);
}

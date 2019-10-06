package io.javaclasses.expression.token;

import io.javaclasses.expression.statemachine.Context;

public class NumberToken implements Token {

    private final Double number;

    public NumberToken(Double number) {
        this.number = number;
    }

    @Override
    public void evaluate(Context context) {
        context.pushOperand(number);
    }
}

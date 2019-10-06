package io.javaclasses.expression.token;

import io.javaclasses.expression.statemachine.Context;

public class FinishToken implements Token {

    @Override
    public void evaluate(Context context) {
        context.popOperators();
    }
}

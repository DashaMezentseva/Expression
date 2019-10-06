package io.javaclasses.expression.token;

import io.javaclasses.expression.statemachine.Context;

public interface Token {

    void evaluate(Context context);

}

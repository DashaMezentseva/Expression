package io.javaclasses.expression.token;

import io.javaclasses.expression.statemachine.Context;

public class RightParenthesesToken implements Token {

    @Override
    public void evaluate(Context context) {
        context.pushClosingBracket();
    }


}

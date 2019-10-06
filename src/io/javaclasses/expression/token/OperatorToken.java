package io.javaclasses.expression.token;

import io.javaclasses.expression.statemachine.Context;
import io.javaclasses.expression.operator.Operator;

public class OperatorToken implements Token {

    private final Operator operator;

    public OperatorToken(Operator operator) {

        if (operator == null) {
            throw new NullPointerException("Null operator");
        }

        this.operator = operator;
    }

    @Override
    public void evaluate(Context context) {
        context.pushOperator(operator);
    }

}

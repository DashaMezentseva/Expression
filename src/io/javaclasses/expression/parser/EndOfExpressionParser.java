package io.javaclasses.expression.parser;

import io.javaclasses.expression.Expression;
import io.javaclasses.expression.token.FinishToken;
import io.javaclasses.expression.token.Token;

public class EndOfExpressionParser implements Parser {

    @Override
    public Token parse(Expression expression) {
        if (expression.endOfExpression()){
            return new FinishToken();
        }
        return null;
    }
}

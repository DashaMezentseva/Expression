package io.javaclasses.expression.parser;

import io.javaclasses.expression.Expression;
import io.javaclasses.expression.token.LeftParenthesesToken;
import io.javaclasses.expression.token.Token;

public class OpeningBracketParser implements Parser {
    @Override
    public Token parse(Expression expression) {
        if (expression.getCurrentChar()=='('){
            expression.incrementPosition();
            return new LeftParenthesesToken();
        }
        return null;
    }
}

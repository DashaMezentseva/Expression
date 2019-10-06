package io.javaclasses.expression.parser;

import io.javaclasses.expression.Expression;
import io.javaclasses.expression.token.RightParenthesesToken;
import io.javaclasses.expression.token.Token;

public class ClosingBracketParser implements Parser{

    @Override
    public Token parse(Expression expression) {
        if (expression.getCurrentChar()==')') {
            expression.incrementPosition();
            return new RightParenthesesToken();
        }

        return null;
    }
}

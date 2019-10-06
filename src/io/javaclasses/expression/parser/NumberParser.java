package io.javaclasses.expression.parser;

import io.javaclasses.expression.Expression;
import io.javaclasses.expression.token.NumberToken;
import io.javaclasses.expression.token.Token;

public class NumberParser implements Parser {
    @Override
    public Token parse(Expression expression) {

        char currentPosition = expression.getCurrentChar();
        StringBuffer number = new StringBuffer();

        if (currentPosition == '-' && !expression.endOfExpression()){
            number.append(currentPosition);
            expression.incrementPosition();
            if (expression.outExpression()){
                return null;
            }
            currentPosition = expression.getCurrentChar();
        }
        if (currentPosition > '0' && currentPosition < '9'){
            number.append(currentPosition);
            expression.incrementPosition();
            while (!expression.outExpression()){
                currentPosition = expression.getCurrentChar();
                if (currentPosition != '.' && (currentPosition < '0' || currentPosition > '9' )){
                    break;
                }
                number.append(currentPosition);
                expression.incrementPosition();
            }
            if (currentPosition == '.') {
                number.append('0');
            }
            return new NumberToken(new Double(number.toString()));
        }
        return null;
    }
}

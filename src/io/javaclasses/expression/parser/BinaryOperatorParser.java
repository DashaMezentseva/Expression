package io.javaclasses.expression.parser;

import io.javaclasses.expression.Expression;
import io.javaclasses.expression.operator.Operator;
import io.javaclasses.expression.operator.OperatorFactory;
import io.javaclasses.expression.token.OperatorToken;
import io.javaclasses.expression.token.Token;

public class BinaryOperatorParser implements Parser {

    private final OperatorFactory factory = new OperatorFactory();

    @Override
    public Token parse(Expression expression) {

        if (expression.endOfExpression()){
            return null;
        }

        final char representation = expression.getCurrentChar();

        final Operator operator = factory.createOperator(representation);

        if (operator != null){
            expression.incrementPosition();
            return new OperatorToken(operator);
        }
        return null;
    }
}

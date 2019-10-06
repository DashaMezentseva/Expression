package io.javaclasses.expression.parser;

import io.javaclasses.expression.Expression;
import io.javaclasses.expression.token.Token;

public interface Parser {

    Token parse(Expression expression);
}

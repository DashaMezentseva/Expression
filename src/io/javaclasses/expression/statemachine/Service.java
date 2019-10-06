package io.javaclasses.expression.statemachine;

import java.util.EnumMap;
import java.util.Map;

import io.javaclasses.expression.parser.*;
import io.javaclasses.expression.parser.NumberParser;
import io.javaclasses.expression.parser.Parser;
import io.javaclasses.expression.token.Token;


import static io.javaclasses.expression.statemachine.State.*;

public class Service implements
        StateRecognizer<State, Context> {

    private Map<State, Parser> parserMap =
            new EnumMap<State, Parser>
                    (State.class) {{
                put(NUMBER, new NumberParser());
                put(BINARY_OPERATOR, new BinaryOperatorParser());
                put(OPENING_BRACKET, new OpeningBracketParser());
                put(CLOSING_BRACKET, new ClosingBracketParser());
                put(FINISH, new EndOfExpressionParser());
            }};


    @Override
    public boolean accept(State possibleState,
                          Context context) {

        context.getExpressionReader().skipSpaces();

        final Parser parser = parserMap.get(possibleState);

        if (parser == null) {
            throw new IllegalStateException("Parser not found for state: " + possibleState);
        }
        if (context.getExpressionReader().outExpression() && possibleState != FINISH)
            return false;
        final Token token = parser.parse(context.getExpressionReader());

        if (token == null) {
            return false;
        }

        token.evaluate(context);

        return true;
    }
}

package io.javaclasses.expression.statemachine;



import java.util.EnumSet;
import java.util.Set;

import static io.javaclasses.expression.statemachine.State.*;


public class Matrix implements
        TransitionMatrix<State> {

    @Override
    public State getStartState() {
        return State.START;
    }

    @Override
    public boolean isFinishState(State state) {
        return FINISH == state;
    }

    @Override
    public Set<State> getPossibleStates(State currentState) {

        switch (currentState) {
            case START:
                return EnumSet.of(NUMBER, OPENING_BRACKET);
            case NUMBER:
                return EnumSet.of(BINARY_OPERATOR, CLOSING_BRACKET, FINISH);
            case BINARY_OPERATOR:
                return EnumSet.of(NUMBER, OPENING_BRACKET);
            case OPENING_BRACKET:
                return EnumSet.of(NUMBER, OPENING_BRACKET);
            case CLOSING_BRACKET:
                return EnumSet.of(CLOSING_BRACKET, BINARY_OPERATOR, FINISH);
        }

        return EnumSet.noneOf(State.class);
    }
}

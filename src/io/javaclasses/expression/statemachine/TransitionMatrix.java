package io.javaclasses.expression.statemachine;

import java.util.Set;

public interface TransitionMatrix<State extends Enum> {

    State getStartState();

    boolean isFinishState(State state);

    Set<State> getPossibleStates(State currentState);


}

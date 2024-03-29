package io.javaclasses.expression.statemachine;

public interface StateMachineContext<State extends Enum, Result> {

    State getState();

    void setState(State state);

    Result getResult();
}

package io.javaclasses.expression.statemachine;

public interface StateRecognizer<State extends Enum, Context> {

    boolean accept(State possibleState, Context context);
}

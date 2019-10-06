package io.javaclasses.expression.statemachine;

abstract public class AbstractStateMachine<Result,
        Context extends StateMachineContext<State, Result>,
        State extends Enum,
        Matrix extends TransitionMatrix<State>,
        Recognizer extends StateRecognizer<State, Context>,
        TransitionError extends Exception> {

    final protected Result run(Context context) throws TransitionError {

        final Matrix matrix = getMatrix();
        context.setState(matrix.getStartState());

        while (!matrix.isFinishState(context.getState())) {
            if (!moveForward(context)) {
                deadlock(context);
                return null;
            }
        }

        return context.getResult();
    }

    private boolean moveForward(Context context) {
        final Matrix matrix = getMatrix();
        final Recognizer recognizer = getStateRecognizer();
        final State currentState = context.getState();
        for (State possibleState : matrix.getPossibleStates(currentState)) {
            if (recognizer.accept(possibleState, context)) {
                context.setState(possibleState);
                return true;
            }
        }
        return false;
    }

    abstract protected Matrix getMatrix();

    abstract protected Recognizer getStateRecognizer();

    abstract protected void deadlock(Context context) throws TransitionError;
}

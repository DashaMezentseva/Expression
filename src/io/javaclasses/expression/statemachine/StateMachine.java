package io.javaclasses.expression.statemachine;


import io.javaclasses.expression.ExprException;

public class StateMachine extends AbstractStateMachine<Double, Context, State, Matrix, Service, ExprException> {

    private final Matrix matrix = new Matrix();

    private final Service service = new Service();

    @Override
    protected Matrix getMatrix() {
        return matrix;
    }

    @Override
    protected Service getStateRecognizer() {
        return service;
    }

    @Override
    protected void deadlock(Context context) throws ExprException {
        final int position = context.getExpressionReader().getPosition();

        System.out.println("Deadlock at state: " + context.getState());

        System.out.println("Parse position: " + position);

        throw new ExprException("Invalid expression format.",
                position);
    }

    public Double evaluate(String expression) throws ExprException {
        return run(new Context(expression));
    }
}

package io.javaclasses.expression;

public class ExprException extends Exception {

    private int errorPosition;

    public ExprException(String message, int errorPosition) {
        super(message);
        this.errorPosition = errorPosition;
    }

}

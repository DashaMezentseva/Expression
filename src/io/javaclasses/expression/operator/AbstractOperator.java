package io.javaclasses.expression.operator;

abstract public class AbstractOperator implements Operator {

    public enum Priority {
        LOW,
        MEDIUM,
    }

    private final Priority priority;

    protected AbstractOperator(Priority priority) {

        if (priority == null) {
            throw new NullPointerException("Null priority");
        }

        this.priority = priority;
    }

    @Override
    public int compareTo(Operator o) {
        return priority.compareTo(((AbstractOperator) o).priority);
    }
}

package io.javaclasses.expression;

public class Expression {

    private final String expression;

    private int position = 0;

    public Expression(String expression) {

        if (expression == null){
            throw new NullPointerException("This is empty expression");
        }

        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public char getCurrentChar() {
        return expression.charAt(position);
    }

    public void incrementPosition(){
        position++;
    }

    public boolean endOfExpression() {
        return position + 1 >= expression.length();
    }

    public void skipSpaces() {
        while (position < expression.length()) {
            if (expression.charAt(position) != ' ' && expression.charAt(position) != '\t') {
                break;
            }
            incrementPosition();
        }
    }

    public boolean outExpression() {
        return position >= expression.length();
    }
}

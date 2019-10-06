package test.io.javaclasses.expression.tests;


import io.javaclasses.expression.ExprException;
import io.javaclasses.expression.statemachine.StateMachine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {

    private StateMachine stateMachine = new StateMachine();

    @Test
    public void expressionWithBrackets() throws ExprException {
        assertEquals("Wrong handling of brackets", Double.valueOf(2), stateMachine.evaluate("4/(8-6)"));
    }

    @Test
    public void Minus() throws ExprException {
        assertEquals("Wrong result of subtracting", Double.valueOf(-16), stateMachine.evaluate("100 - 116"));
    }

    @Test
    public void getMultiply() throws ExprException {
        assertEquals("Wrong result of multiplying", Double.valueOf(121), stateMachine.evaluate("11 * 11"));
    }

    @Test
    public void expression() throws ExprException {
        assertEquals("Wrong result", Double.valueOf(-102), stateMachine.evaluate("11* (2-3*6) / 2 - 7 * 2 ") );
    }


}

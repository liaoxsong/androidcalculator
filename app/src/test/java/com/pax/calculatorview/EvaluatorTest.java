package com.pax.calculatorview;

import com.pax.calculatorview.evaluator.Evaluator;

import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * created by song at 3/13/19
 **/
public class EvaluatorTest {

    @Test
    public void testDouble() {
        assertEquals("7.40", Evaluator.calculateDouble("2.4 + 5"));
        assertEquals("7.90", Evaluator.calculateDouble("2.4 + 5 * 1.1"));
        assertEquals("103.75", Evaluator.calculateDouble("105.45 + 15.00*0.22 - 100/20.0"));

        assertEquals("6683.90", Evaluator.calculateDouble("89*75.10"));

        assertEquals("35.83", Evaluator.calculateDouble("2.5+100/3"));
        assertEquals("923300.00", Evaluator.calculateDouble("520000+400000+3300"));
    }

    @Test
    public void testDivideByZero() {
        try {
            Evaluator.calculateDouble("22/0");
            assertTrue("should not come here", 0==1);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage() +" is thrown", 1==1);
        }
    }

    @Test
    public void testBigNumber() {
        assertEquals("3000.00", Evaluator.calculateDouble("50*60"));
        assertEquals("44435556.00", Evaluator.calculateDouble("6666*6666"));
    }

}

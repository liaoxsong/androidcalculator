package com.pax.calculatorview;

import com.pax.calculatorview.evaluator.ErrorFormatHelper;

import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * created by song at 3/26/19
 **/
public class ErrorFormatHelperTest {


    @Test
    public void testInputSign() {
        assertFalse(ErrorFormatHelper.canInputSign(null));
        assertFalse(ErrorFormatHelper.canInputSign(""));
        assertFalse(ErrorFormatHelper.canInputSign("123+"));
        assertFalse(ErrorFormatHelper.canInputSign("123+123."));

        assertTrue(ErrorFormatHelper.canInputSign("123+1"));
        assertTrue(ErrorFormatHelper.canInputSign("123+123.1*1"));
    }

    @Test
    public void testInputDecimalPoint() {
        assertFalse(ErrorFormatHelper.canInputDecimalPoint("."));
        assertFalse(ErrorFormatHelper.canInputDecimalPoint("213."));
        assertFalse(ErrorFormatHelper.canInputDecimalPoint("123+12.3"));
        assertFalse(ErrorFormatHelper.canInputDecimalPoint("12.3"));

        assertTrue(ErrorFormatHelper.canInputDecimalPoint(null));
        assertTrue(ErrorFormatHelper.canInputDecimalPoint(""));
        assertTrue(ErrorFormatHelper.canInputDecimalPoint("123"));
        assertTrue(ErrorFormatHelper.canInputDecimalPoint("12.3+123"));
    }

}


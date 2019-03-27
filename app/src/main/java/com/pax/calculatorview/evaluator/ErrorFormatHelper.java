package com.pax.calculatorview.evaluator;

/**
 * created by song at 3/26/19
 **/
public class ErrorFormatHelper {

    /**
     * this will return true only if last character is a digit
     * @return if false, will prevent any more entry
     */
    public static boolean canInputSign(String text) {
        if (text == null || text.length() < 1) return false;
        return Character.isDigit(text.charAt(text.length() - 1));
    }


    //prevent "5..5" and "5.5.5"
    public static boolean canInputDecimalPoint(String text ) {
        if (text == null || text.length() < 1) return true;

        boolean lastDot = text.charAt(text.length() - 1) == '.';
        if (lastDot) return false;

        int i = text.length()-1;

        while(i>=0) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                i--;
                continue;
            }
            if (isSign(c)) return true;
            if (c == '.') return false;

            i--;
        }

        return true;

    }

    private static boolean isSign(Character c) {
        return  c == '+' || c == '-' || c == '*' || c == '/' ||
                c == '×' || c == '÷';
    }
}

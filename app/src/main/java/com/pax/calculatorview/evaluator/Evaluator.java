package com.pax.calculatorview.evaluator;

import java.util.Stack;

/**
 *  created by song at 3/13/19
 *  handle simple expression like '5+2.0*3.4'
 *  Input format error checking is done in #{link=ErrorFormatHelper}
 *
 **/
public class Evaluator {
    public static String calculateDouble(String s) throws IllegalArgumentException{
        double res = 0, num = 0;
        s = s.trim();
        int decimals = 0;
        Stack<Double> stack = new Stack<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                if (decimals > 0) {
                    num += Math.pow(10, -decimals) * (c - '0');
                    decimals++;
                } else {
                    num = num * 10 + (c - '0');
                }
            }
            if (c == '.') {
                decimals = 1;
                continue;
            }

            if (!Character.isDigit(c) || i == s.length() - 1) {
                decimals = 0;
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    //2 + 3 * 2
                    stack.push(num * stack.pop());
                } else if (sign == '/') {
                    //5 + 7 /2
                    if (num == 0) {
                        throw new IllegalArgumentException("divisor cannot be zero");
                    }
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;//reset
            }
        }

        for (Double i : stack) {
            res += i;
        }

        return String.format("%.2f", res);
    }
}

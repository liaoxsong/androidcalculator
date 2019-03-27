package com.pax.calculatorview;

/**
 * created by song at 3/13/19
 **/
public interface KeyClick {
    void onDigitEntered(int n);
    void onDecimalEntered();
    void onPlus();
    void onMinus();
    void onMultiply();
    void onDivide();
    void onBackspace();
    void onClear();
    void onFinish();
}

package com.pax.calculatorview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;


/**
 * created by song at 3/12/19
 **/
public class CalculatorView extends FrameLayout implements View.OnClickListener {

    private KeyClick mKeyClickListener;


    public CalculatorView(Context context) {
        super(context);
        init(context);
    }

    public CalculatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void setKeyClickListener(KeyClick keyClickListener) {
        mKeyClickListener = keyClickListener;
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_calculator, null);
        addView(view);
        view.findViewById(R.id.key_0).setOnClickListener(this);
        view.findViewById(R.id.key_1).setOnClickListener(this);
        view.findViewById(R.id.key_2).setOnClickListener(this);
        view.findViewById(R.id.key_3).setOnClickListener(this);
        view.findViewById(R.id.key_4).setOnClickListener(this);
        view.findViewById(R.id.key_5).setOnClickListener(this);
        view.findViewById(R.id.key_6).setOnClickListener(this);
        view.findViewById(R.id.key_7).setOnClickListener(this);
        view.findViewById(R.id.key_8).setOnClickListener(this);
        view.findViewById(R.id.key_9).setOnClickListener(this);

        view.findViewById(R.id.key_plus).setOnClickListener(this);
        view.findViewById(R.id.key_minus).setOnClickListener(this);
        view.findViewById(R.id.key_multiply).setOnClickListener(this);
        view.findViewById(R.id.key_divide).setOnClickListener(this);

        view.findViewById(R.id.key_dot).setOnClickListener(this);
        view.findViewById(R.id.key_equals).setOnClickListener(this);
        view.findViewById(R.id.key_clear).setOnClickListener(this);
        view.findViewById(R.id.key_backspace).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final int viewId = view.getId();
        if (mKeyClickListener == null) return;

        switch (viewId) {
            case R.id.key_0:
                mKeyClickListener.onDigitEntered(0);
                break;
            case R.id.key_1:
                mKeyClickListener.onDigitEntered(1);
                break;
            case R.id.key_2:
                mKeyClickListener.onDigitEntered(2);
                break;
            case R.id.key_3:
                mKeyClickListener.onDigitEntered(3);
                break;
            case R.id.key_4:
                mKeyClickListener.onDigitEntered(4);
                break;
            case R.id.key_5:
                mKeyClickListener.onDigitEntered(5);
                break;
            case R.id.key_6:
                mKeyClickListener.onDigitEntered(6);
                break;
            case R.id.key_7:
                mKeyClickListener.onDigitEntered(7);
                break;
            case R.id.key_8:
                mKeyClickListener.onDigitEntered(8);
                break;
            case R.id.key_9:
                mKeyClickListener.onDigitEntered(9);
                break;
            case R.id.key_plus:
                mKeyClickListener.onPlus();
                break;
            case R.id.key_minus:
                mKeyClickListener.onMinus();
                break;
            case R.id.key_multiply:
                mKeyClickListener.onMultiply();
                break;
            case R.id.key_divide:
                mKeyClickListener.onDivide();
                break;
            case R.id.key_backspace:
                mKeyClickListener.onBackspace();
                break;
            case R.id.key_clear:
                mKeyClickListener.onClear();
                break;
            case R.id.key_dot:
                mKeyClickListener.onDecimalEntered();
                break;
            case R.id.key_equals:
                mKeyClickListener.onFinish();
                break;
            default:
                break;
        }
    }
}

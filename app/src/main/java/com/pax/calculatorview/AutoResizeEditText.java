package com.pax.calculatorview;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;

import android.util.AttributeSet;

import com.pax.calculatorview.evaluator.ErrorFormatHelper;
import com.pax.calculatorview.evaluator.Evaluator;

/**
 * created by song at 3/12/19
 **/
public class AutoResizeEditText extends AppCompatEditText implements KeyClick {

    private Float mDefaultSize, mMinSize;
    private float MIN_FACTOR = 0.75f;

    private boolean mShouldAutoResize = true;

    public AutoResizeEditText(Context context) {
        super(context);
    }

    public AutoResizeEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initAttributes();
    }

    public AutoResizeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttributes();
    }


    private void initAttributes() {
        mDefaultSize = getPaint().getTextSize();
        mMinSize = mDefaultSize * MIN_FACTOR;
    }


    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);

        float actualWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        if (actualWidth < 0 || !mShouldAutoResize) {
            return;
        }

        float size = getPaint().getTextSize();
        if (lengthAfter < lengthBefore) {
            //vice versa, if it has room for enlargement, set the font bigger and bigger
            while (size < mDefaultSize && getPaint().measureText(text.toString()) < actualWidth) {
                size += 2;
                setTextSize(size);
                getPaint().setTextSize(size);
                setText(text);
            }
        }

        //if larger than current full width, set the font smaller so that it is just barely smaller than full width
        while (size > mMinSize && getPaint().measureText(text.toString()) > actualWidth) {
            size -= 2;
            setTextSize(size);
            getPaint().setTextSize(size);
            setText(text);
        }
    }

    private void appendText(int n) {
        appendText("" + n);
    }

    private void appendText(String t) {
        String org = getText().toString();
        setText(org + t);
        setSelection(org.length() + t.length());
    }

    @Override
    public void onDigitEntered(int n) {
        appendText(n);
    }

    @Override
    public void onDecimalEntered() {
        if (ErrorFormatHelper.canInputDecimalPoint(getText().toString()))  {
            appendText(".");
        }
    }

    @Override
    public void onPlus() {
        if (ErrorFormatHelper.canInputSign(getText().toString())) {
            appendText("+");
        }

    }

    @Override
    public void onMinus() {
        if (ErrorFormatHelper.canInputSign(getText().toString())) {
            appendText("-");
        }
    }


    @Override
    public void onMultiply() {
        if (ErrorFormatHelper.canInputSign(getText().toString())) {
            appendText(getResources().getString(R.string.key_multiply));
        }
    }

    @Override
    public void onDivide() {
        if (ErrorFormatHelper.canInputSign(getText().toString())) {
            appendText(getResources().getString(R.string.key_divide));
        }
    }


    @Override
    public void onBackspace() {
        if (getText() != null && getText().length() > 0) {
            String text = getText().toString();
            setText(text.substring(0, text.length() - 1));
        }
    }

    @Override
    public void onClear() {
        setText("");
    }

    @Override
    public void onFinish() {
        if (getText() != null && getText().length() > 0) {
            try {
                String res =
                        Evaluator.calculateDouble(getText().toString());
                setText(String.valueOf(res));
            } catch (IllegalArgumentException e) {
                onClear();
            }
        }
    }
}

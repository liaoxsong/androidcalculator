# androidcalculator
![](demo.gif)

The way text size changes according to current content is done by overriding 
```java
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
```

The algorithm for evaluating expression is identical to [leetcode question basic calculator II](https://leetcode.com/problems/basic-calculator-ii/)

Happy coding

package com.pax.calculatorview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoResizeEditText editText = findViewById(R.id.edit_number);

        CalculatorView calculatorView = findViewById(R.id.calc_view);
        calculatorView.setKeyClickListener(editText);
    }


}

package com.websarva.wings.android.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClickListener listener = new ClickListener();

        findViewById(R.id.btZero).setOnClickListener(listener);
        findViewById(R.id.btOne).setOnClickListener(listener);
        findViewById(R.id.btTwo).setOnClickListener(listener);
        findViewById(R.id.btThree).setOnClickListener(listener);
        findViewById(R.id.btFour).setOnClickListener(listener);
        findViewById(R.id.btFive).setOnClickListener(listener);
        findViewById(R.id.btSix).setOnClickListener(listener);
        findViewById(R.id.btSeven).setOnClickListener(listener);
        findViewById(R.id.btEight).setOnClickListener(listener);
        findViewById(R.id.btNine).setOnClickListener(listener);
        findViewById(R.id.btClear).setOnClickListener(listener);
        findViewById(R.id.btPlus).setOnClickListener(listener);
        findViewById(R.id.btEquals).setOnClickListener(listener);
        findViewById(R.id.btPositiveOrNegative).setOnClickListener(listener);
    }

    private class ClickListener implements View.OnClickListener {

        List<BigDecimal> numberArray = new ArrayList<>();
        List<Character> operandArray = new ArrayList<>();

        boolean minusSigh = false;

        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View view) {
            TextView tvResult = findViewById(R.id.tvResult);
            if (tvResult.getText().toString().equals("0")) tvResult.setText("");

            int viewId = view.getId();

            switch (viewId) {

                case R.id.btOne:
                    addText(tvResult, '1');
                    break;

                case R.id.btTwo:
                    addText(tvResult, '2');
                    break;

                case R.id.btThree:
                    addText(tvResult, '3');
                    break;

                case R.id.btFour:
                    addText(tvResult, '4');
                    break;

                case R.id.btFive:
                    addText(tvResult, '5');
                    break;

                case R.id.btSix:
                    addText(tvResult, '6');
                    break;

                case R.id.btSeven:
                    addText(tvResult, '7');
                    break;

                case R.id.btEight:
                    addText(tvResult, '8');
                    break;

                case R.id.btNine:
                    addText(tvResult, '9');
                    break;

                case R.id.btZero:
                    addText(tvResult, '0');
                    break;

                case R.id.btClear:
                    clear(tvResult);
                    tvResult.setTextSize(100);
                    break;


                case R.id.btPositiveOrNegative:
                    if (tvResult.getText().toString().equals("")) tvResult.setText("-0");
                    changeSign(tvResult);
                    break;
            }
        }



        private void addText(TextView textView, char addChar) {
            String getText = textView.getText().toString();
            String setText = getText + addChar;

            if (minusSigh && getText.length() >= 12) return;
            if (!minusSigh && getText.length() >= 11) return;

            setFontSize(textView, setText);

            int num = Integer.parseInt((setText).replace(",", ""));
            textView.setText(String.format("%,d", num));
        }

        private void clear(TextView textView) {
            textView.setText("0");
        }

        private void changeSign(TextView textView) {
            String getText = textView.getText().toString().replace(",", "");
            int num = Integer.parseInt(getText.replace(",", ""));

            num *= -1;

            textView.setText(String.format("%,d", num));

            if (num < 0) minusSigh = true;
            else minusSigh = false;

            if (minusSigh && getText.length() >= 12) return;
            if (!minusSigh && getText.length() >= 11) return;

            setFontSize(textView, String.format("%,d", num));
        }

        private void setFontSize(TextView textView, String setText) {
            if (minusSigh) {
                if (setText.length() >= 7) textView.setTextSize(92);
                if (setText.length() >= 8) textView.setTextSize(84);
                if (setText.length() >= 9) textView.setTextSize(76);
                if (setText.length() >= 10) textView.setTextSize(70);
                if (setText.length() >= 11) textView.setTextSize(66);

            } else {
                if (setText.length() >= 7) textView.setTextSize(92);
                if (setText.length() >= 8) textView.setTextSize(84);
                if (setText.length() >= 9) textView.setTextSize(76);
                if (setText.length() >= 10) textView.setTextSize(70);
            }
        }
    }


}
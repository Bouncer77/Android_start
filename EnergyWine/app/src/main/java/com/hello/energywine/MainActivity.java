package com.hello.energywine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAlcohol;
    private EditText editTextSugar;

    private TextView textViewCarbohydrates;
    private TextView textViewKdj;
    private TextView textViewKkal;

    private String resCarbo;
    private String resKdj;
    private String resKkal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAlcohol = (EditText) findViewById(R.id.editTextAlcohol);
        editTextSugar = (EditText) findViewById(R.id.editTextSugar);

        textViewCarbohydrates = (TextView) findViewById(R.id.textViewCarbohydrates);
        textViewKdj = (TextView) findViewById(R.id.textViewKdj);
        textViewKkal = (TextView) findViewById(R.id.textViewKkal);


        TextWatcher textWatcherAlcSug = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String alcoText = editTextAlcohol.getText().toString();
                String sugarText = editTextSugar.getText().toString();
                if (!alcoText.isEmpty() && !sugarText.isEmpty()) {

                    double alco = Double.parseDouble(alcoText);
                    double sugar = Double.parseDouble(sugarText);

                    resCarbo = BigDecimal.valueOf(calculateСarbohydrates(sugar))
                            .setScale(1, RoundingMode.HALF_EVEN)
                            .toString();
                    resKdj = String.valueOf((int) Math.round(calculateEnergyValue(alco, sugar, "kcal")));
                    resKkal = String.valueOf((int) Math.round(calculateEnergyValue(alco, sugar, "kj")));

                    textViewCarbohydrates.setText(resCarbo);
                    textViewKdj.setText(resKdj);
                    textViewKkal.setText(resKkal);
                }
            }
        };

        editTextAlcohol.addTextChangedListener(textWatcherAlcSug);
        editTextSugar.addTextChangedListener(textWatcherAlcSug);


    }

    private double calculateEnergyValue(double alco, double sugar, String type) {
        if (type.equals("kcal")) {
            return alco * 5.6 + sugar * 0.4;
        } else if (type.equals("kj")) {
            return (alco * 5.6 + sugar * 0.4) * 4.1868;
        } else {
            return -1;
        }
    }

    private double calculateСarbohydrates(double sugar) {
        return sugar / 10;
    }
}

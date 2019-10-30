package com.hello.caloriewinecounting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAlcohol;
    private EditText editTextSugar;
    private TextView textViewRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAlcohol = (EditText) findViewById(R.id.editTextAlcohol);
        editTextSugar = (EditText) findViewById(R.id.editTextSugar);
        textViewRes = (TextView) findViewById(R.id.textViewRes);



    }


    public void onClickCalculate(View view) {
        String alcoText = editTextAlcohol.getText().toString();
        String sugarText = editTextSugar.getText().toString();
        if (!alcoText.isEmpty() && !sugarText.isEmpty()) {

            double alco = Double.parseDouble(alcoText);
            double sugar = Double.parseDouble(sugarText);
            String res = "";

            res += "Углеводы: " + BigDecimal.valueOf(calculateСarbohydrates(sugar))
            .setScale(1, RoundingMode.HALF_EVEN)
            .toString();

            res += "\nККАЛ: " + (int) Math.round(calculateEnergyValue(alco, sugar, "kcal"));
            //res += "\nККАЛ: " + calculateEnergyValue(alco, sugar, "kcal");

            /*res += "\nККАЛ: " + BigDecimal.valueOf(calculateEnergyValue(alco, sugar, "kcal"))
                    .setScale(1, RoundingMode.HALF_EVEN)
                    .toString();*/

            res += "\nКДЖ: " + (int) Math.round(calculateEnergyValue(alco, sugar, "kj"));

            /*res += "\nКДЖ: " + BigDecimal.valueOf(calculateEnergyValue(alco, sugar, "kj"))
                    .setScale(1, RoundingMode.HALF_EVEN)
                    .toString();*/
            textViewRes.setText(res);
        } else {
            Toast.makeText(this,
                    getString(R.string.toast_fields_filled),
                    Toast.LENGTH_SHORT);
        }
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

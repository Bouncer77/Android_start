package com.bouncer77.wine_advisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WineExpert expert = new WineExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindWine(View view) {
        //Получить ссылку на TextView
        // findViewById возвращает объект View.
        TextView wineInfo = (TextView) findViewById(R.id.textView_wine_info);

        //Получить ссылку на Spinner
        Spinner grapeColor = (Spinner) findViewById(R.id.spinner_grape_color);

        //Получить вариант, выбранный в Spinner
        // getSelectedItem возвращает Object.
        String selectGrapeColor = String.valueOf(grapeColor.getSelectedItem());

        List<String> wineTypeList = expert.getWineType(selectGrapeColor);
        StringBuilder wineTypeFormatted = new StringBuilder();
        for (String wineType : wineTypeList) {
            wineTypeFormatted.append(wineType).append("\n");
        }

        //Вывести выбранный вариант
        wineInfo.setText(wineTypeFormatted);

    }
}

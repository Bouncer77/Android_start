package com.bouncer77.wine_advisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView wineInfo;
    private Spinner grapeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Получить ссылку на TextView
        // findViewById возвращает объект View.
        wineInfo = (TextView) findViewById(R.id.textView_wine_info);
        //Получить ссылку на Spinner
        grapeColor = (Spinner) findViewById(R.id.spinner_grape_color);
    }

    public void onClickFindWine(View view) {
        //Получить вариант, выбранный в Spinner
        // getSelectedItem возвращает Object.
        //String selectGrapeColor = String.valueOf(grapeColor.getSelectedItem());
        int pos = grapeColor.getSelectedItemPosition();
        StringBuilder description = getDescriptionByPosition(pos);
        wineInfo.setText(description);
    }

    private StringBuilder getDescriptionByPosition(int position) {
        //String[] descriptions = getResources().getStringArray(R.array.grape_color);
        String[] descriptions;
        if (position == 0) {
            descriptions = getResources().getStringArray(R.array.type_of_white_wine);
        } else if (position == 1) {
            descriptions = getResources().getStringArray(R.array.type_of_red_wine);
        } else {
            descriptions = null;
        }

        if (descriptions == null) {
            return new StringBuilder("Error: Item of list did not found! Please connect with us!");
        }

        StringBuilder wineTypeFormatted = new StringBuilder();
        for (String str : descriptions) {
            wineTypeFormatted.append(str).append("\n");
        }
        return wineTypeFormatted;
    }
}

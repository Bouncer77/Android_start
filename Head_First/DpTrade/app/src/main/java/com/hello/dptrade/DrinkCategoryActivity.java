package com.hello.dptrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        // simple_list_item_1
        // Встроенный ресурс
        //макета. Он приказыва-
        //ет адаптеру массива
        //отображать каждый
        //элемент массива в виде
        //надписи.
        ArrayAdapter<Drink> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Drink.drinks);

        ListView listDrinks = (ListView)findViewById(R.id.listViewWine);
        listDrinks.setAdapter(listAdapter);

    }


}

package com.hello.dptrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        ListView listDrinks = (ListView) findViewById(R.id.listViewWine);
        listDrinks.setAdapter(listAdapter);

        // Создание слушателя
        AdapterView.OnItemClickListener clickListenerWine =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Передача напитка выбранного пользователем
                        Intent intent = new Intent(DrinkCategoryActivity.this,
                                DrinkActivity.class);
                        intent.putExtra(DrinkActivity.EXTRA_DRINKED, (int) id);
                        startActivity(intent);

                    }
                };
        // Назначение слушателя для спискового представления
        listDrinks.setOnItemClickListener(clickListenerWine);

    }


}

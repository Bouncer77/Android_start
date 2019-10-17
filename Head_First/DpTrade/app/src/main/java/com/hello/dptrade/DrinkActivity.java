package com.hello.dptrade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKED = "drinkId";
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        // Панель инструментов
        // необходимый для замены простой панели приложения панелью инструментов.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Получить инф о соответствующей категории
        int drinkId = getIntent().getExtras().getInt(DrinkActivity.EXTRA_DRINKED);
        Drink drink = Drink.drinks[drinkId];

        // Получить ссылки на графические компоненты
        TextView name = (TextView)findViewById(R.id.textViewWineName);
        TextView description = (TextView)findViewById(R.id.textViewDescription);
        ImageView photo = (ImageView)findViewById(R.id.imageViewWine);

        // Заполнить страницу контентом (вывести инф в графические компоненты)
        name.setText(drink.getName());
        description.setText(drink.getDescription());
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Заполнение меню; элементы действий добавляются на пнаель приложения
        getMenuInflater().inflate(R.menu.menu_drink, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                return true; // Сообщает Android, что щелчок на элементе обработан

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

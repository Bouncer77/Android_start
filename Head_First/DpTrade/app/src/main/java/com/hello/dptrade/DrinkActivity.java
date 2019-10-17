package com.hello.dptrade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKED = "drinkId";

    private Drink drink;

    private TextView name;

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
        drink = Drink.drinks[drinkId];

        // Получить ссылки на графические компоненты
        name = (TextView)findViewById(R.id.textViewWineName);
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
                Intent intentOrder = new Intent(this, OrderActivity.class);
                startActivity(intentOrder);
                return true; // Сообщает Android, что щелчок на элементе обработан

            case R.id.action_share:
                /*Intent intentShare = new Intent(Intent.ACTION_SEND);
                //intentShare.setType("image/png");
                intentShare.setType("text/plain");
                intentShare.putExtra(Intent.EXTRA_TEXT, drink.getName());
                intentShare.putExtra(Intent.EXTRA_SUBJECT, drink.getCountry());
                //startActivity(intentShare);
                startActivity(Intent.createChooser(intentShare, getResources().getString(R.string.app_name)));*/

                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                share.putExtra(Intent.EXTRA_TEXT, "Отправленно через приложение Dp Trade for Android OS\n" +
                        "http://www.wine-dp-trade.ru/products/273");
                startActivity(Intent.createChooser(share, "Share link!"));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

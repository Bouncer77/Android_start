package com.hello.dptrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKED = "drinkId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int drinkId = getIntent().getExtras().getInt(DrinkActivity.EXTRA_DRINKED);
        Drink drink = Drink.drinks[drinkId];

        TextView name = (TextView)findViewById(R.id.textViewWineName);
        TextView description = (TextView)findViewById(R.id.textViewDescription);
        ImageView photo = (ImageView)findViewById(R.id.imageViewWine);

        name.setText(drink.getName());
        description.setText(drink.getDescription());
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());



    }
}

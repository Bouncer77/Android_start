package com.hello.bitsandpizza;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void onClickDone(View view) {
        //Код, который выполняется при щелчке на FAB-кнопке
        CharSequence text = "Your order has been updated";
        Snackbar snackbar = Snackbar.make(
                findViewById(R.id.coordinator),
                text,
                Snackbar.LENGTH_SHORT
        );
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(OrderActivity.this,
                        "Undone!",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        snackbar.show();
    }

}

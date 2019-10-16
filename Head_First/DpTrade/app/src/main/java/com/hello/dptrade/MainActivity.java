package com.hello.dptrade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Создать OnItemClickListener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView,
                                    View itemView,
                                    int position,
                                    long rid) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };

        ListView listOptions = (ListView)findViewById(R.id.listViewOptions);
        listOptions.setOnItemClickListener(itemClickListener);
    }
}

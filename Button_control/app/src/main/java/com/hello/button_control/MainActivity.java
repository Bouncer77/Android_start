package com.hello.button_control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Нажата кнопка " + getString(R.string._1));
            }
        });

        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        //b.setTextColor(#FFFFFF);
        textView.setText("Нажата кнопка " + getString(R.string._2));
    }

    public void onClickButton3(View view) {
        textView.setText("Нажата кнопка " + getString(R.string._3));
    }
}

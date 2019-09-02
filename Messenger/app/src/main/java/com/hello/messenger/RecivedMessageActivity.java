package com.hello.messenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecivedMessageActivity extends AppCompatActivity {

    private TextView textViewRecivedMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recived_message);
        Intent intent = getIntent();
        textViewRecivedMsg = findViewById(R.id.textViewRecivedMsg);
        String msg = intent.getStringExtra("msg");
        textViewRecivedMsg.setText(msg);
    }
}

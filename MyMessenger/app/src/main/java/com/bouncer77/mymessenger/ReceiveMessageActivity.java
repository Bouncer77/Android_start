package com.bouncer77.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";
    TextView textViewShowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(EXTRA_MESSAGE);
        textViewShowText = findViewById(R.id.textViewMessage);
        textViewShowText.setText(msg);
    }
}

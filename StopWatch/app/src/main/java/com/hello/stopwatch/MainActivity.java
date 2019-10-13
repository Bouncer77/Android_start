package com.hello.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private String languageToLoad  = "en"; // your language


    // таймер 1 (НЕ Выключается, когда активность перестает быть видимой для пользователя)
    private int seconds = 0;
    private int milliseconds_x_125 = 0;
    private boolean isRunning = false; // секундомер работает?
    private boolean wasRunning = false; // был запущен? (для смены оринтации экрана)

    public static final String ISRUN = "isRunning";
    public static final String WASRUN = "wasRunning";
    public static final String SEC = "seconds";
    public static final String MSEC = "milliseconds";
    public static final int MSECINCREMENT = 125;

    // таймер 2 (Выключается, когда активность перестает быть видимой для пользователя)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textViewTimer);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt(SEC);
            milliseconds_x_125 = savedInstanceState.getInt(MSEC);
            isRunning = savedInstanceState.getBoolean(ISRUN);
            wasRunning = savedInstanceState.getBoolean(WASRUN);
        }
        runTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        isRunning = wasRunning;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SEC, seconds);
        outState.putInt(MSEC, milliseconds_x_125);
        outState.putBoolean(ISRUN, isRunning);
        outState.putBoolean(WASRUN, wasRunning);
    }

    public void onClickStartTimer(View view) {
        isRunning = true;
    }

    public void onClickPauseTimer(View view) {
        isRunning = false;
    }

    public void onClickResetTimer(View view) {
        isRunning = false;
        seconds = 0;
        milliseconds_x_125 = 0;
    }

    private void runTimer(){

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d:%03d",
                        hours, minutes, secs, milliseconds_x_125);
                textViewTimer.setText(time);

                if(isRunning) {
                    milliseconds_x_125 += MSECINCREMENT;
                    if (milliseconds_x_125 >= 1000) {
                        ++seconds;
                        milliseconds_x_125 -= 1000;
                    }

                }
                handler.postDelayed(this, MSECINCREMENT);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    public void onClickOpenSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

        /*if (languageToLoad.equals("en")) {
            languageToLoad = "ru";
        } else {
            languageToLoad = "en";
        }

        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        this.setContentView(R.layout.activity_main);*/
    }
}

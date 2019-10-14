package com.hello.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private String languageToLoad  = "en"; // your language


    // таймер 1 (НЕ Выключается, когда активность перестает быть видимой для пользователя)
    private int seconds = 0; // количество прошедших секунд
    private int milliseconds_timer = 0; // количество прошедших миллисекунд
    private boolean isRunning = false; // секундомер работает?
    private boolean wasRunning = false; // был запущен? (для смены оринтации экрана)

    /*секундомер останавливается, если приложе-
      ние Stopwatch становится невидимым, и снова запускается,
      когда приложение снова оказывается на экране.*/
    public boolean background_running = true;
    public boolean paused_running = false;
    public boolean show_milliseconds = true;

    public static final String ISRUN = "isRunning"; // флаг отсчета времени
    public static final String WASRUN = "wasRunning"; // флаг отсчета времени до приостановки активности
    public static final String SEC = "seconds";
    public static final String MSEC = "milliseconds";
    private int milliseconds_delta = 125; // рекомендую 125 миллисекунд

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textViewTimer);

        // Получить предыдущее со-
        //стояние секундомера, если
        //активность была уничто-
        //жена и создана заново.
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt(SEC);
            milliseconds_timer = savedInstanceState.getInt(MSEC);
            isRunning = savedInstanceState.getBoolean(ISRUN);
            wasRunning = savedInstanceState.getBoolean(WASRUN);
        }
        runTimer();
    }

    // Сохранить состояние секундомера,
    //если он готовится к уничтожению.
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SEC, seconds);
        outState.putInt(MSEC, milliseconds_timer);
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
        milliseconds_timer = 0;
    }

    // Обновление показателей таймера
    // Метод runTimer() использует объект Handler
    //для увеличения числа секунд и обновления надписи
    private void runTimer(){

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time;
                if (show_milliseconds) {
                    time = String.format(Locale.getDefault(), "%d:%02d:%02d:%03d",
                            hours, minutes, secs, milliseconds_timer);
                } else {
                    time = String.format(Locale.getDefault(), "%d:%02d:%02d",
                            hours, minutes, secs);
                }
                textViewTimer.setText(time);

                if(isRunning) {
                    milliseconds_timer += milliseconds_delta;
                    if (milliseconds_timer >= 1000) {
                        ++seconds;
                        milliseconds_timer -= 1000;
                    }

                }
                handler.postDelayed(this, milliseconds_delta);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        if (background_running) return;

        if (wasRunning) {
            isRunning = true;
            wasRunning = false;
        }
    }

    // Если активность свернута,
    // остановить отсчет времени (при backgroun_running == false)
    // включенный Switch номер 1 (по умолчанию выключен)
    @Override
    protected void onStop(){
        super.onStop();

        if (background_running) return;

        wasRunning = isRunning;
        isRunning = false;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (paused_running) return;

        if (wasRunning) {
            isRunning = true;
            wasRunning = false;
        }
    }

    // Если активность приостанавливается,
    //остановить отсчет времени (при paused_running == false)
    // включенный Switch номер 2 (по умолчанию выключен)
    @Override
    protected void onPause() {
        super.onPause();

        if (paused_running) return;

        wasRunning = isRunning;
        isRunning = false;
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

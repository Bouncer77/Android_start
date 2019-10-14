package com.hello.stopwatch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private Spinner selectLang;
    public static final String LANG = "language";

    private Switch swbackgroundRun;
    public static final String SWBACKGROUND = "swbackground";

    private Switch swpauseRun;
    public static final String SWPAUSE = "swpause";

    private Switch swmilliseconds;
    public static final String SWMILLISECONDS = "swmilliseconds";

    private EditText numMilliseconds;
    public static final String NUMMILLISEC = "numMilliseconds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        selectLang = (Spinner) findViewById(R.id.spinnerLanguage);
        swbackgroundRun = (Switch) findViewById(R.id.switchBackground);
        swpauseRun = (Switch) findViewById(R.id.switchPause);
        swmilliseconds = (Switch) findViewById(R.id.switchMilliseconds);
        numMilliseconds = (EditText) findViewById(R.id.editTextNumMilliseconds);
    }

    public void onClickApplySettings(View view) {

        String lang = getChooseLang();
        int num = Integer.valueOf(numMilliseconds.getText().toString());
        Intent mIntent = new Intent(this, MainActivity.class);
        mIntent.putExtra(LANG, lang);
        mIntent.putExtra(SWBACKGROUND, !(swbackgroundRun.isChecked()));
        mIntent.putExtra(SWPAUSE, !(swpauseRun.isChecked()));
        mIntent.putExtra(SWMILLISECONDS, !(swmilliseconds.isChecked()));
        mIntent.putExtra(NUMMILLISEC, num);
        startActivity(mIntent);
    }

    private String getChooseLang() {
        int nlang = selectLang.getSelectedItemPosition(); // номер языка в Спинере
        String lang;
        switch (nlang) {
            case 0:
                lang = "en";
                break;

            case 1:
                lang = "ru";
                break;

            default:
                lang = "en";
                break;
        }
        return lang;
    }
}
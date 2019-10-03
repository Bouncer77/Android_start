package com.javahints.winelot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.*;
import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {

    private EditText editTextLot;
    private TextView textViewLotInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextLot = findViewById(R.id.editTextLot);
        textViewLotInfo = findViewById(R.id.textViewLotOutInfo);
    }

    public void onClickGetLotInfo(View view) {

        int[] mas = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[] mas_vis = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] months = {"January", "February", "March", "April",
        "May", "June", "July", "August", "September", "October", "November", "December"};

        String lotInfo = editTextLot.getText().toString().trim();

        int yearLastNum = Character.getNumericValue(lotInfo.charAt(0));
        int years = yearLastNum + 2010;
        boolean visYear = false;
        /*if (years % 4 == 0 || (years % 100 == 0 && years % 400 == 0)) {
        } else {
            visYear = true;
        }*/

        GregorianCalendar gr = new GregorianCalendar();
        visYear = gr.isLeapYear(years);

        int days = Integer.valueOf(lotInfo.substring(1));


        if (days < 0 || days > 365) {
            textViewLotInfo.setText("Введено некорректное значение!");
            System.exit(1);
        }

        int monthNum = 0;
        for (int i = 1; days > mas[i - 1]; ++i) {
            if (visYear) {
                days -= mas_vis[i - 1];
            } else {
                days -= mas[i - 1];
            }
            monthNum++;
        }

        Calendar calendarWine = new GregorianCalendar(years, monthNum - 1, days);

        Calendar calendarNow = new GregorianCalendar();


        SimpleDateFormat formattedDate = new SimpleDateFormat("dd / MM / yyyy");
        String dateFormatted = formattedDate.format(calendarWine.getTime());

        textViewLotInfo.setText(dateFormatted);
        // textViewLotInfo.setText(calendarWine.getTime().toString());
    }
}

package com.hello.apexleg_ver_10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.hello.apexleg_ver_10.R;

public class MainActivity extends AppCompatActivity {

    private Spinner spinerOpportunities;
    private TextView textViewDescription;

    final static int N_Bloodhound = 1, N_Gibraltar = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinerOpportunities = findViewById(R.id.spinerOpportunities);
        textViewDescription = findViewById(R.id.textViewDescriptionTemp);
    }

    public void showDescriptionBloodhound(View view) {
        // получили позицию спинера
        int position = spinerOpportunities.getSelectedItemPosition();

        String description = getDescriptionByPosition(position, N_Bloodhound);
        textViewDescription.setText(description);
    }

    private String getDescriptionByPosition(int position, int n_legends) {
            String[] description = getResources().getStringArray(R.array.description_of_bloodhound);
        if (n_legends == N_Gibraltar)
            description = getResources().getStringArray(R.array.description_of_gibraltar);
        return description[position];
    }

    public void showDescriptionGibraltar(View view) {
        int position = spinerOpportunities.getSelectedItemPosition();
        String description = getDescriptionByPosition(position, N_Gibraltar);
        textViewDescription.setText(description);
    }
}

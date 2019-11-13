package com.hello.bitsandpizza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentPagerAdapter pagerAdapter =
                new FragmentPagerAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
                    @NonNull
                    @Override
                    public Fragment getItem(int position) {
                        switch (position) {
                            case 0:
                                return new TopFragment();
                            case 1:
                                return new PizzaFragment();
                            case 2:
                                return new PastaFragmen();
                            case 3:
                                return new StoresFragment();
                        }
                        return new TopFragment();
                    }

                    @Override
                    public int getCount() {
                        return 4;
                    }
                };
        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
    }
}



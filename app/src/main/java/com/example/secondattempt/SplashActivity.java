package com.example.secondattempt;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class SplashActivity extends AppCompatActivity {

    private static final int SLIDE_TIME_OUT = 8000; // 8 seconds
    private ViewPager2 viewPager;
    private Handler handler = new Handler();
    private Runnable runnable;
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        viewPager = findViewById(R.id.viewPager);

        int[] layouts = {R.layout.slide1, R.layout.slide2, R.layout.slide3};
        SlideAdapter adapter = new SlideAdapter(this, layouts);
        viewPager.setAdapter(adapter);

        // Change slide every 2.66 seconds
        runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage < layouts.length) {
                    viewPager.setCurrentItem(currentPage, true);
                    currentPage++;
                    handler.postDelayed(this, SLIDE_TIME_OUT / layouts.length);
                } else {
                    // Navigate to the Quotes activity after slides
                    Intent quotesIntent = new Intent(SplashActivity.this, QuotesActivity.class);
                    startActivity(quotesIntent);
                    finish();
                }
            }
        };
        handler.postDelayed(runnable, SLIDE_TIME_OUT / layouts.length);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }
}

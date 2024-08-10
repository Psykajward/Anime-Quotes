package Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animequotes.R;

import Auth.AuthActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView splashImage;
    private int[] images = {R.mipmap.luffy, R.mipmap.madara, R.mipmap.ken};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        splashImage = findViewById(R.id.splash_image);

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                splashImage.setImageResource(images[currentIndex]);
                currentIndex = (currentIndex + 1) % images.length;

                if (currentIndex == 0) {
                    startActivity(new Intent(SplashActivity.this, AuthActivity.class));
                    finish();
                } else {
                    handler.postDelayed(this, 2000); // Change every 2 seconds
                }
            }
        };

        handler.post(runnable);
    }
}

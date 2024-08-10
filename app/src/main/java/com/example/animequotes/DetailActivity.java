package com.example.animequotes;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView backgroundImageView;
    private TextView quoteTextView;
    private TextView characterNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        // Initialize member variables
        backgroundImageView = findViewById(R.id.detail_background_image);
        quoteTextView = findViewById(R.id.detail_quote_text);
        characterNameTextView = findViewById(R.id.detail_character_name);

        // Get data from Intent
        String quoteText = getIntent().getStringExtra("quote_text");
        String characterName = getIntent().getStringExtra("character_name");
        int backgroundImageResourceId = getIntent().getIntExtra("background_image_resource_id", -1);

        // Set data to views
        quoteTextView.setText(quoteText);
        characterNameTextView.setText(characterName);

        if (backgroundImageResourceId != -1) {
            backgroundImageView.setImageResource(backgroundImageResourceId);
        } else {
            backgroundImageView.setImageResource(R.mipmap.luffy); // Fallback image
        }
    }
}

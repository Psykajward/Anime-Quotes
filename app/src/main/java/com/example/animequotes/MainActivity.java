package com.example.animequotes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Quote> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.quote_list_view);
        quotes = new ArrayList<>();
        quotes.add(new Quote("I am going to be the Pirate King!", "Monkey D. Luffy",
                R.mipmap.luffy, R.mipmap.image2_foreground));
        quotes.add(new Quote("“Never trust anyone too much. Remember, the devil was once an angel.”",
                "Ken Kaneki", R.mipmap.ken, R.mipmap.image1_foreground));
        quotes.add(new Quote("No Matter Who You Are, You Do Not Know What Kind Of Human You Are " +
                "Until The Very End. As Death Comes To Embrace You, You Will Realize What You Are. " +
                "That’s The View Of Death, Don’t You Think?",
                "Itachi Uchiha", R.mipmap.itachi, R.mipmap.image3_foreground));
        quotes.add(new Quote("Wake up to reality. Nothing ever goes as planned in this accursed " +
                "world. The longer you live, the more you realize that the only things that truly" +
                " exist in this reality are merely pain, suffering and futility.",
                "Madara Uchiha", R.mipmap.madara, R.mipmap.image4_foreground));
        quotes.add(new Quote("One who does not know pain cannot possibly understand true peace." +
                " I will never forget Yahiko's pain. And now, the world shall know pain.",
                "Pain", R.mipmap.pain, R.mipmap.image5_foreground));


        QuoteAdapter adapter = new QuoteAdapter(this, quotes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Quote selectedQuote = quotes.get(position);

                // Log the data being passed
                Log.d("MainActivity", "Quote Text: " + selectedQuote.getText());
                Log.d("MainActivity", "Character Name: " + selectedQuote.getCharacterName());
                Log.d("MainActivity", "Background Image ID: " + selectedQuote.getBackgroundImageResourceId());

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("quote_text", selectedQuote.getText());
                intent.putExtra("character_name", selectedQuote.getCharacterName());
                intent.putExtra("background_image_resource_id", selectedQuote.getBackgroundImageResourceId());
                startActivity(intent);
            }

        });
    }
}

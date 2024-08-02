package com.example.secondattempt;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class QuotesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private QuotesAdapter quotesAdapter;
    private List<QuoteItem> quoteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        quoteList = new ArrayList<>();
        quoteList.add(new QuoteItem("Ken Kaneki", R.mipmap.image1));
        quoteList.add(new QuoteItem("Monky D.Luffy", R.mipmap.image2));
        quoteList.add(new QuoteItem("Itachi Uchiha  ", R.mipmap.image3));
        quoteList.add(new QuoteItem("Madara Uchiha", R.mipmap.image4));
        quoteList.add(new QuoteItem("Pain", R.mipmap.image5));

        quotesAdapter = new QuotesAdapter(this, quoteList);
        recyclerView.setAdapter(quotesAdapter);
    }
}

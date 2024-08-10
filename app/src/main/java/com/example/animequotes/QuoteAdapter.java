package com.example.animequotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class QuoteAdapter extends ArrayAdapter<Quote> {
    public QuoteAdapter(Context context, List<Quote> quotes) {
        super(context, 0, quotes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Quote quote = getItem(position);

        ImageView characterImage = convertView.findViewById(R.id.character_image);
        TextView characterName = convertView.findViewById(R.id.character_name);

        characterImage.setImageResource(quote.getCharacterImageResourceId());
        characterName.setText(quote.getCharacterName());

        return convertView;
    }
}

package com.example.secondattempt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder> {

    private Context context;
    private List<QuoteItem> quoteList;

    public QuotesAdapter(Context context, List<QuoteItem> quoteList) {
        this.context = context;
        this.quoteList = quoteList;
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_qoutes, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        QuoteItem quoteItem = quoteList.get(position);
        holder.quoteText.setText(quoteItem.getQuoteText());
        holder.quoteImage.setImageResource(quoteItem.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(context, Quote1Activity.class);
                    break;
                case 1:
                    intent = new Intent(context, Quote2Activity.class);
                    break;
                case 2:
                    intent = new Intent(context, Quote3Activity.class);
                    break;
                case 3:
                    intent = new Intent(context, Quote4Activity.class);
                    break;
                case 4:
                    intent = new Intent(context, Quote5Activity.class);
                    break;
                default:
                    return;
            }
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    static class QuoteViewHolder extends RecyclerView.ViewHolder {
        TextView quoteText;
        ImageView quoteImage;

        QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            quoteText = itemView.findViewById(R.id.quote_text);
            quoteImage = itemView.findViewById(R.id.quote_image);
        }
    }
}

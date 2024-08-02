package com.example.secondattempt;

public class QuoteItem {
    private String quoteText;
    private int imageResId;

    public QuoteItem(String quoteText, int imageResId) {
        this.quoteText = quoteText;
        this.imageResId = imageResId;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public int getImageResId() {
        return imageResId;
    }
}

package com.example.animequotes;

public class Quote {
    private final String text;
    private final String characterName;
    private final int characterImageResourceId;
    private final int backgroundImageResourceId;

    public Quote(String text, String characterName, int characterImageResourceId, int backgroundImageResourceId) {
        this.text = text;
        this.characterName = characterName;
        this.characterImageResourceId = characterImageResourceId;
        this.backgroundImageResourceId = backgroundImageResourceId;
    }

    public String getText() {
        return text;
    }

    public String getCharacterName() {
        return characterName;
    }

    public int getCharacterImageResourceId() {
        return characterImageResourceId;
    }

    public int getBackgroundImageResourceId() {
        return backgroundImageResourceId;
    }
}

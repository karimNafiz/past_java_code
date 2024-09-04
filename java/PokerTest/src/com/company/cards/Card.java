package com.company.cards;

public abstract class Card {
    private int cardValue; // for rank
    private boolean available; // so the card cant be dealt twice
    private String type; // for suit

    public Card(int cardValue , String type)
    {
        this.cardValue = cardValue;
        this.available = true;
        this.type = type;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCardValue()
    {
        return this.cardValue;
    }
    public void setCardValue(int cardValue)
    {
        this.cardValue = cardValue;
    }
    public boolean getAvailable()
    {
        return available;
    }
    public void setAvailable(boolean available)
    {
        this.available = available;
    }




}

package com.company.players;



import com.company.cards.Card;

public class Player extends PlayerTemplate
{
    private Card[] holeCards; // this will hold 2 cards that are initially given to each player at the beginning of each round
    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Card[] getHoleCards() {
        return holeCards;
    }

    public void setHoleCards(Card[] holeCards) {
        this.holeCards = holeCards;
    }

    public Player(String name , int balance)
    {
        super(name , balance);
        this.points = 0;
        // did not initialize hole cards but have been taken care by a setter method
    }
}
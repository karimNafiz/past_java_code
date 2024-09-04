package com.company.players;

// mother fucking fazle khoti poron kintu tor e dewa lagbe

import com.company.cards.Card;
import com.company.cards.CardDeck;


public class Dealer extends PlayerTemplate
{

    private Card[] communityCards; // this will hold 5 communicaty cards in each round

    public Card[] getCommunityCards() {
        return communityCards;
    }
    public void setCommunityCards(Card card , int index) {
        this.communityCards[index] = card;
    }
    public Dealer()
    {
        this.communityCards = new Card[5];
    }// implemented in super class

    public void shuffleHoleCards(PlayerTemplate[] players , CardDeck gameCardDeck)
    {
        for(PlayerTemplate player:players)
        {
            if(player != this && player.isInGame())// just to check if hole cards are not given to dealer
            {
                Card[] temp = {gameCardDeck.getCard() , gameCardDeck.getCard()};
                ((Player)player).setHoleCards(temp); // i am down casting here
            }// dealer is not included in game this caused me 4 hrs cuz fazle doesnt know how poker is played 'crying emoji' xD
        }



    }// this will simulate shuffling of hole cards

    public void callFlopCards(CardDeck gameCardDeck , int sLimit , int eLimit)
    {
//        System.out.println("sLimit "+sLimit+" eLimit"+eLimit);
        for(int i = sLimit; i < eLimit ; i++)
        {
//            System.out.println("how many times is it runnig");
            this.setCommunityCards(gameCardDeck.getCard() , i);
//            this.communityCards[i] = gameCardDeck.getCard();
        }
    }
    // i need a function to clean up the arrayList after each round






}
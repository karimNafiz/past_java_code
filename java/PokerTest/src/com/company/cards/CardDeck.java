package com.company.cards;

import java.util.Random;

public class CardDeck {
    // this is row number for 2d array that will hold the 52 cards 4 suits 13 ranks
    public static final int Spade = 0;
    public static final int Hearts = 1;
    public static final int Clubs = 2;
    public static final int Diamonds = 3;


    private Card[][] cardDeck; // this basically to simulate a default deck of cards of 52
    private Random random = new Random();
    public CardDeck()
    {
        cardDeck = new Card[4][13];// initializes the 2d array
        for(int suits = 0 ; suits < cardDeck.length;suits++)
        {
            for(int card = 1 ; card <= cardDeck[suits].length;card++)
            {
                if(suits == 0)
                {
                    this.cardDeck[suits][card - 1] = new Spade(card + 1);
                }else if(suits == 1)
                {
                    this.cardDeck[suits][card - 1] = new Hearts(card + 1);
                }else if(suits == 2)
                {
                    this.cardDeck[suits][card - 1] = new Clubs(card + 1);
                }else
                {
                    this.cardDeck[suits][card - 1] = new Diamonds(card + 1);
                }
            } // inner loop will loop 13 times

        } // outer loop will loop 4 times
    }// end of constructor

    public Card getCard()
    {
        int suit = random.nextInt(4); // randomizesa a number from 0 to 3
        int rank = random.nextInt(13);// randomizesa a number from 0 to 12
        while(!this.cardDeck[suit][rank].getAvailable()) // to check to if the card is available
        {
            suit = random.nextInt(4) ;
            rank = random.nextInt(13);
        }
        this.cardDeck[suit][rank].setAvailable(false); // sets a false could have been more efficient but life is life
        return this.cardDeck[suit][rank];

    }


}

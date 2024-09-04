package com.company.gamefunctions;
import com.company.cards.Card;
import com.company.cards.CardDeck;
import com.company.players.Dealer;
import com.company.players.Player;
import com.company.players.PlayerTemplate;


import java.util.Arrays;
import java.util.Scanner;

public class GameBoard
{
    private Scanner user = new Scanner(System.in);
    private CardDeck gameCardDeck;
    private PlayerTemplate[] players;
    private int noOfPlayers;
    private int noOfRounds = 1;
    private int initialBet = 15;
    private int potAmount = 0;
    private int noOfFolds = 0;
    private int winnerIndex = 0;
    private int winningPoints = 0;
    private boolean gameOver;

    public GameBoard()
    {
        gameCardDeck = new CardDeck();

        int x = 0;
        while(x == 0 )
        {
            try {
                System.out.println("enter the number of rounds");
                this.noOfRounds = user.nextInt();
                System.out.println("enter the number of players ");
                this.noOfPlayers = user.nextInt();
                x =1;
            }
            catch (Exception e)
            {
                user.next();
                x = 0;
            }
        }// exception handling

//        System.out.println("enter the no of players ");
//        this.noOfPlayers = user.nextInt();
        this.players = new PlayerTemplate[this.noOfPlayers+1];
        this.players[0] = new Dealer();
        addPlayers();
        gameFunction();


    }

    private void addPlayers()
    {
        for(int i = 0 ; i < this.noOfPlayers;i++)
        {
            System.out.println("enter name of player "+(i+1));
            String temp = user.next();
            int x = 0;
            int tempBal = 0;
            while(x <= 2)
            {
                try
                {
                    if(x == 0)
                    {
                        System.out.println("enter amount for player "+(i+1));
                    }else if(x == 1)
                    {
                        System.out.println("brah i said amount not some greek alphabet \uD83E\uDD28");
                        System.out.println("enter the amount for player "+(i+1)+" or else i wont work");

                    }
                    tempBal = user.nextInt();
                    while (tempBal <= 0 )
                    {
                        System.out.println("from when did we start having negative money? \uD83E\uDD14 ");
                        System.out.println("enter the amount for player "+(i+1)+" or else i wont work");
                        tempBal = user.nextInt();

                    }
                    x = 3;

                }catch (Exception e) {
                    user.next();

                    x = 1;
                }
//                }catch (ArithmeticException e)
//                {
//                    user.next();
//                    x = 2;
//                }
            }// exception handling



            this.players[i+1] = new Player(temp , tempBal);
        }
    }
    private void gameFunction()
    {
        int x = 0;
        while(x < this.noOfRounds)
        {
            for(int j = 1;j< this.players.length;j++)
            {
                if(this.players[j].getBalance() < this.initialBet)
                {
                    this.players[j].setInGame(false);
                }else
                {
                    this.players[j].setInGame(true);
                }
            }// checks if the player has enough money to even play this round
            this.gameOver = false;


            this.decoration("this is round "+Integer.toString(x+1));
            this.preFlop();
            this.commonGameLoop();
            this.Flop(0, 3 , true);
            this.commonGameLoop();
            this.Flop(3 , 5 , false);
            this.commonGameLoop();
            if(!gameOver)
            {
                this.cleanUpRound();
            }
            x++;
        }

//        this.cleanUpRound();


    }

    private void preFlop()
    {

        if(!this.gameOver) {
//        System.out.println("this is round  "+this.noOfRounds);
            System.out.println("dealer will shuffle hole cards xD (honestly the whole fucking thing is a joke)");
            // initial bet amount stuff needs to be solved
            this.dealerShuffleCard();
            for (int i = 1; i < this.players.length; i++) {
                // this is for decoration
                if(this.players[i].isInGame()) {
                    for (int x = 0; x < 30; x++) {
                        System.out.print('=');
                    }
                    System.out.println();
                    // end of decoration

                    System.out.println("player name " + this.players[i].getName());
                    System.out.println("player balance " + this.players[i].getBalance());
                    // this is for decoration
                    for (int x = 0; x < 30; x++) {
                        System.out.print('=');
                    }
                    System.out.println();
                    // end of decoration

                    this.drawCards(2, ((Player) this.players[i]).getHoleCards());

                }// end of if
            }// end of for loop
        }
    }
    private void Flop(int sLimit , int eLimit , boolean flag)
    {
        if(!gameOver) {
            ((Dealer) this.players[0]).callFlopCards(this.gameCardDeck, sLimit, eLimit);
            if (flag)
                this.drawCards(3, ((Dealer) this.players[0]).getCommunityCards());
            else
                this.drawCards(5, ((Dealer) this.players[0]).getCommunityCards());

        }
    }

    private void commonGameLoop()
    {

        if(!gameOver) {
            for (int i = 1; i < this.players.length; i++) {


                if (this.players[i].isInGame()) {

                    if(gameOver)
                        break;
                    else if(this.players[i].getBalance() < this.initialBet)
                    {
                        this.players[i].setInGame(false);
                        continue;
                    }


                    System.out.println(" turn for player " + this.players[i].getName());
                    System.out.println(" amount u have  " + this.players[i].getBalance());
                    System.out.println(" initial bet " + this.initialBet);
                    // this is for decoration
                    this.decoration(null);
                    System.out.println();
                    System.out.println("enter r for raise , c for call , f for fold");
                    char temp = user.next().charAt(0);
                    if (temp == 'r') {

                        System.out.println("enter amount to bet ");
                        int rBetTemp = user.nextInt();
                        while (rBetTemp <= initialBet) {

                            System.out.println("enter amount to bet this should be more than initial bet amount ");
                            rBetTemp = user.nextInt();
                        }

                        this.setBalanceWhileBetting((Player) this.players[i], rBetTemp);
                    } else if (temp == 'c') {
                        this.setBalanceWhileBetting((Player) this.players[i], initialBet);
                    } else {
                        this.players[i].setInGame(false);
                        noOfFolds++;
                        if (this.noOfFolds == this.noOfPlayers - 1) {
                            this.gameOver = true;
                            for(int j = 1; j < this.players.length;j++)
                            {
//                                System.out.println("im inside the loop xD");
                                if(((Player)this.players[j]).isInGame())
                                {
                                    this.winnerIndex = j;
//                                    System.out.println("value of winnig index "+this.winnerIndex);
                                    this.cleanUpRound();
                                    break;
                                }
                            }
                        }
                    }
                }
            }// end of for loop
            System.out.println("total amount in pot " + this.potAmount);
            // this is for decoration
            this.decoration(null);
        }
    }


    private void dealerShuffleCard()
    {
        ((Dealer)this.players[0]).shuffleHoleCards(players , this.gameCardDeck );
    }// end of dealerShuffleCard

    // utility methods
    private void setBalanceWhileBetting(Player player , int betAmount)
    {
        if(betAmount > this.initialBet)
        {
            this.initialBet = betAmount;
        };
        player.setBalance(player.getBalance() - betAmount);
        this.potAmount += betAmount;
    }// end of function
    //                    this.initialBet = rBetTemp;
//                    this.players[i].setBalance(this.players[i].getBalance() - rBetTemp);
//                    this.potAmount += rBetTemp;



    // this function will clean up the whole thing and start fresh for next round
    private void cleanUpRound()
    {
        if(!this.gameOver) {
            int[] winIndex = new int[this.players.length];
            int counter = 0;
            Card[] communityCard = ((Dealer) this.players[0]).getCommunityCards();
            int[] communityAndHoleCardValues = new int[communityCard.length + 2];
            int[] communityAndHoleCardSuit = new int[communityCard.length + 2];
            for (int i = 0; i < communityCard.length; i++) {
                communityAndHoleCardValues[i] = communityCard[i].getCardValue();
                communityAndHoleCardSuit[i] = communityCard[i].getType().charAt(0);
            }

            for (int i = 1; i < players.length; i++) {
                if(players[i].isInGame()) {
                    communityAndHoleCardValues[5] = ((Player) players[i]).getHoleCards()[0].getCardValue();
                    communityAndHoleCardValues[6] = ((Player) players[i]).getHoleCards()[1].getCardValue();
                    communityAndHoleCardSuit[5] = ((Player) players[i]).getHoleCards()[1].getType().charAt(0);
                    communityAndHoleCardSuit[6] = ((Player) players[i]).getHoleCards()[1].getType().charAt(0);
                    System.out.println("name of player "+players[i].getName());
//                    for(int test:communityAndHoleCardValues)
//                        System.out.println("value of test "+test);

                    int points = this.checkForPointsInEachHand(communityAndHoleCardValues , communityAndHoleCardSuit);
//                    if (points == 0) {
//                        points = this.checkForPointsInEachHand(communityCard);
//                    }
                    if (points >= this.winningPoints) {
                        this.winningPoints = points;
                        winIndex[counter] = i;
                        counter++;
                    }

                    System.out.println(" player " + this.players[i].getName() + " has " + points + " points");
                }// end of if
            }// end of for



        }// end of if


        if(winnerIndex != 0) {
            
            System.out.println("winner is " + this.players[this.winnerIndex].getName());
            ((Player) this.players[this.winnerIndex]).setBalance(this.potAmount + ((Player) this.players[this.winnerIndex]).getBalance());
        }
        for(int i = 1 ; i < this.players.length;i++)
        {
            System.out.println("player name "+this.players[i].getName());
            System.out.println("player balance "+((Player)this.players[i]).getBalance());

        }
        int[] temp1 = {1 , 2 , 3 , 3 ,3 , 3 , 3};
        int[] temp = {7 , 8 , 9 , 10 , 11 , 14 , 2};
        System.out.println("return value "+this.checkForPointsInEachHand(temp , temp1 ));
        this.potAmount = 0;
        this.noOfFolds = 0;
        this.winnerIndex = 0;
        this.winningPoints = 0;
//        this.gameOver = false;
        this.gameCardDeck = new CardDeck();

    }// end of clean up method+


    // this two functions are for assigning points to player after each round, the array of cards will be sorted before processing
    // return 28 for royal flush
    // return 27 straight flush
    // return 26 four of a kind
    // return 25 for full house
    // return 24 for flush
    // return 23 for straight
    // return 22 for threeofakind
    private int checkForPointsInEachHand(int[] communityAndHoleCards , int[] communityAndHoleCardSuits)
    {
        //may apply a sorting algorithm
        Arrays.sort(communityAndHoleCards);
        Arrays.sort(communityAndHoleCardSuits);
        int counter = 1;
        int finalCard = 0;
//        boolean cons2 = false;
        boolean cons3 = false;
        int pairs = 0;
        boolean match;
        boolean flush = false;
        int points = 0;

        for(int i = 0 ; i < communityAndHoleCards.length;i++)
        {

            match = false;
            if(i + 1 == communityAndHoleCards.length)
            {
                break;
            }
            else if(communityAndHoleCardSuits[i] == communityAndHoleCardSuits[i + 1] && !flush)
            {
                int temp = checkForConsecutiveSameRankCards(i , i + 1 , communityAndHoleCardSuits);
                System.out.println(" value of flush temp "+temp+" value of temp - i "+(temp - i)+" value of i "+i);
                if((temp - i) >= 5)
                {

                    flush = true;
                }
            }


            else if(communityAndHoleCards[i] + 1 == communityAndHoleCards[i + 1])
            {
                counter++;

                match = true;

            }

            else if(communityAndHoleCards[i] == communityAndHoleCards[i + 1])
            {
                int temp = checkForConsecutiveSameRankCards(i , i + 1 , communityAndHoleCards);
//                System.out.println("value of temp "+temp+" value of i"+" value of temp - i "+(temp - i));
                if(temp - i >=2)
                {

                    if(temp - i >= 3)
                    {
                        if(temp - i >= 4)
                        {
                            return 26;
                        }
                        cons3 = true;
//                        pairs++;
                        if(temp < communityAndHoleCards.length)
                        {
                            i = temp-1;
                        }else
                        {
                            break;
                        }
                        continue;
                    }
//                    cons2 = true;
                    pairs++;


                    if(temp < communityAndHoleCards.length)
                    {
                        i = temp-1;
                    }else
                    {
                        break;
                    }
                }// end of cycling loop
            }
            if(match)
            {
                if(counter >= 5)
                {
                    finalCard = communityAndHoleCards[i + 1];
                }
            }else
            {
                counter = 0;
            }


        }

        System.out.println("value of final card "+finalCard+" value of cons2 "+pairs+" value of cons3 "+cons3+" value of counter "+counter);
        if(finalCard != 0)
        {
            if(finalCard == 14)
                points = this.setPoints(28 , points);
            if(finalCard == 11)
                points = this.setPoints(27 , points);
//            else if(cons3 && pairs >= 1)
//                return 25;
//            else if(flush)
//                return 24;
            else
                points = this.setPoints(23 , points);

        }

        if(cons3 && pairs >= 1)
            points = this.setPoints(25 , points);
        if(flush)
            points = this.setPoints(24 , points);
        if(cons3)
            points = this.setPoints(22 , points);
        if(pairs >= 1) {
            points = this.setPoints(20 , points);
            if (pairs >= 2)
                points = this.setPoints(21 , points);

        }
        if(points == 0)
            points = this.setPoints(communityAndHoleCards[communityAndHoleCards.length - 1] , points);



        return points;

//        return checkForPointsInEachHand(sameCards);

    }
//    private int checkForPointsInEachHand(String[] communityAndHoleCards)
//    {
//        Arrays.sort(communityAndHoleCards);
//
//
//        for(int i = 0 ; i < communityAndHoleCards.length;i++)
//        {
//            if()
//
//
//
//        }
//        return 0;

//        int counter = 0;
//        int suitCounter = 1;
//        for(int i  = 0 ; i < communityAndHoleCards.length;i++)
//        {
//            if(i + 1 >= communityAndHoleCards.length)
//            {
//                break;
//            }
//            else if(communityAndHoleCards[i].getType() == communityAndHoleCards[i + 1].getType())
//            {
//                counter++;
//                suitCounter++;
//            }else if(communityAndHoleCards[i].getType() == communityAndHoleCards[i + 1].getType())
//            {
//                suitCounter++;
//            }
//
//        }
//        if(suitCounter >= 5)
//        {
//            return 24;
//        }else if(counter >= 1 )
//        {
//            if(counter >= 2)
//            {
//                return 21;
//            }
//            return 20;
//        }
//        return communityAndHoleCards[communityAndHoleCards.length - 1].getCardValue();
//    }



    // method for recursively checking cards with the same number in a cluster as the array will be sorted before points are assigned to players
    private int checkForConsecutiveSameRankCards(int sIndex , int lIndex , int[] communityAndHoleCards)
    {
        if(lIndex + 1 == communityAndHoleCards.length && communityAndHoleCards[lIndex - 1] == communityAndHoleCards[lIndex])
            return lIndex + 1;
        else if(lIndex + 1 == communityAndHoleCards.length)
            return lIndex;
        else if(communityAndHoleCards[sIndex] == communityAndHoleCards[lIndex])
            return checkForConsecutiveSameRankCards(sIndex + 1, lIndex + 1 , communityAndHoleCards);
        else
            return lIndex;

    }



//  functions for decoration and other complimentary stuff
    private void decoration(String text)
    {
        for(int i = 0; i <30 ; i++)
        {
            System.out.print("=");
        }
        System.out.println();
        if(text != null)
        {
            System.out.println(text);
        }
        for(int i = 0; i < 30; i++)
        {
            System.out.print("=");
        }
        System.out.println();
    }
    private int checkForException(String text)
    {
        int x = 0;
        while(x == 0)
        {
            try {
                System.out.println(text);
                int tempUser = user.nextInt();
                x = 1;
                return tempUser;
            }
            catch (Exception e)
            {
                user.next();
                x  = 1;
            }
        }
        return 0;// this will nrever be returned
    }
    private int setPoints(int nPoint , int cPoint)
    {
        if(nPoint > cPoint)
            return nPoint;
        return  cPoint;
    }
    private void drawCards(int arrLimit , Card[] tempFlopCardList)
    {
        String[] tempSuit = new String[arrLimit];
        String[] tempRank = new String[arrLimit];



        for(int i = 0; i < arrLimit;i++)
        {
            tempSuit[i] = tempFlopCardList[i].getType();
            String forTempRank = Integer.toString(tempFlopCardList[i].getCardValue());
            forTempRank = "0"+forTempRank;
            if(forTempRank.length() == 2)
            {
                forTempRank += "0";
            }
            else if(forTempRank.length() == 3)
            {
                int lastIndex = forTempRank.length() -1;
                if(forTempRank.charAt(lastIndex) == '4')
                {
                    forTempRank = "0A0";
                }else if(forTempRank.charAt(lastIndex) == '3')
                {
                    forTempRank = "0K0";
                }else if(forTempRank.charAt(lastIndex) == '2')
                {
                    forTempRank = "0Q0";
                }else
                {
                    forTempRank = "0J0";
                }
            }

            tempRank[i] = forTempRank;
        }// end of for loop
        this.drawLines(arrLimit , tempSuit , tempRank);
    }// end of method

    private void drawLines(int eLimit , String[] tempSuit , String[] tempRank)
    {
        DrawCard.drawLines(0 , 13 , 13 , false , eLimit);
        DrawCard.drawLines(3 , 11 , 13 , false , eLimit);
        DrawCard.drawLines(3 , 11 , 13 , true , eLimit);
        DrawCard.drawLines(3 , 11 , 13 , true ,tempSuit,tempSuit.length);
        DrawCard.drawLines(3 , 11 , 13 , true ,tempRank,tempRank.length);
        DrawCard.drawLines(3 , 11 , 13 , true ,eLimit);
        DrawCard.drawLines(3 , 11 , 13 , false , eLimit);
        DrawCard.drawLines(0 , 13 , 13 , false , eLimit);
    }
}
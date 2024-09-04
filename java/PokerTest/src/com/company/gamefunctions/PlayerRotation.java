//package com.company.gamefunctions;
//
//import com.company.cards.Card;
//import com.company.cards.CardDeck;
//import com.company.players.Player;
//import com.company.players.RealPlayer;
//
//public class PlayerRotation {
//    private Player Head;
//    private Player Tail;
//
//
//    public PlayerRotation()
//    {
//        this.Head = null;
//        this.Tail = null;
//    }
//    public void addPlayer(Player player)
//    {
//        if(this.isEmpty())
//        {
//            this.Head = player;
//
//        }else
//        {
//            Player temp = this.Head;
//
//            while(temp.getNext() != null) {
//                temp = temp.getNext();
//            }
//            player.setPrev(temp);
//            temp.setNext(player);
//        }// end of false
//        this.Tail = player;
//
//    }
//    public void showAll()
//    {
//        if(!this.isEmpty())
//        {
//            Player temp = this.getHead();
//            while (temp != null)
//            {
//                System.out.println("i just wanna see how many times this runs xD");
//                Card[] tempHoleCards = temp.getHoleCards();
//                if(tempHoleCards != null) {
//                    for (int i = 0; i < tempHoleCards.length; i++) {
//                        System.out.println("card value = " + tempHoleCards[i].getCardValue() + " and card class type " + tempHoleCards[i].getClass());
//                    }
//                }
//                temp = temp.getNext();
//            }
//        }
//    }
//    public void dealerSuffleCards(CardDeck cardDeck , Player dealer)
//    {
//        dealer.setHoleCards(cardDeck , this);
//    }
//    public boolean isEmpty()
//    {
//        return (this.Head == null);
//    }
//
//
//
//    public Player getHead() {
//        return Head;
//    }
//
//    public void setHead(Player head) {
//        Head = head;
//    }
//
//    public Player getTail() {
//        return Tail;
//    }
//
//    public void setTail(Player tail) {
//        Tail = tail;
//    }
//}
//  this code is pretty impressive no shit xD
// some one give me the last place in a marathon cuz the wrld doesnt care about position only about money

package com.company.players;
public abstract class PlayerTemplate
{
    private String name;
    private int balance;
    private boolean inGame; // if player folds or the balance is less than default bet value then player will no be available for the next round


    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public PlayerTemplate(String name , int balance)
    {
        this.name = name;
        this.balance = balance;
        this.inGame = true;
    }

    public PlayerTemplate()
    {
        this.name = "dealer";
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
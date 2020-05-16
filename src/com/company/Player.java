package com.company;

public class Player {

    int position;
    int money;
    int jailcards;
    boolean isinjail;
    int numofstationowned;

    public Player()
    {
        position=0;
        money=1500;
        jailcards=0;
        isinjail=false;
        numofstationowned=0;

    }

    public void ChangePosition(int number)
    {
        position=position+number;
    }

    public void BuyPlace(int number)
    {
        int moneyneeded=GameLogic.price[number];
        money=money-moneyneeded;

    }



}

package com.company;

public class Player {

    int position;
    int money;
    int jailcards;

    public Player()
    {
        position=0;
        money=1500;
        jailcards=0;
    }

    public void ChangePosition(int number)
    {
        position=position+number;
    }

    public void BuyPlace(int number)
    {
        int moneyneeded=GameLogic.price[number];
        System.out.println(moneyneeded);
        money=money-moneyneeded;

    }



}

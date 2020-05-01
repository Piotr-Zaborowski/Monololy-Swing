package com.company;

public class GameLogic {

    public GameLogic()
    {

    }

    int PlayerCounter(String a, String b, String c, String d)
    {
        int tmp=0;
        if (a.length()>0) tmp++;
        if (b.length()>1) tmp++;
        if (c.length()>2) tmp++;
        if (d.length()>3) tmp++;
        return tmp;
    }





}
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

    int XonMap(int place)
    {
        if (place==0) return 772;
        if (place==1) return 700;
        if (place==2) return 622;
        if (place==3) return 555;
        if (place==4) return 478;
        if (place==5) return 405;
        if (place==6) return 335;
        if (place==7) return 262;
        if (place==8) return 190;
        if (place==9) return 120;
        if (place==10) return 2;
        if (place==11) return 15;
        if (place==12) return 15;
        if (place==13) return 15;
        if (place==14) return 15;
        if (place==15) return 15;
        if (place==16) return 15;
        if (place==17) return 15;
        if (place==18) return 15;
        if (place==19) return 15;
        if (place==20) return 15;


        return 400;
    }








}
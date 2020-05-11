package com.company;

import java.util.Arrays;

public class GameLogic {

    static int price[]=new int[40];
    static int owner[]=new int[40];

    public GameLogic()
    {
        fillpricearray();

    }

    void fillpricearray()
    {

        //nothing happens
        price[0]=0;
        price[10]=0;
        price[20]=0;

        price[30]=-666; //jail

        price[2]=-777; //comm chest
        price[17]=-777;
        price[33]=-777;

        price[7]=-888; //chance
        price[22]=-888;

        price[4]=-200; //tax
        price[38]=-100;

        price[5]=200; //rails
        price[15]=200;
        price[25]=200;
        price[35]=200;

        price[1]=60;
        price[3]=60;
        price[6]=100;
        price[8]=100;
        price[9]=120;

        price[11]=140;
        price[12]=150;
        price[13]=140;
        price[14]=160;
        price[16]=180;
        price[18]=180;
        price[19]=200;

        price[21]=220;
        price[23]=240;
        price[24]=240;
        price[26]=260;
        price[27]=260;
        price[28]=150;
        price[29]=280;

        price[31]=300;
        price[32]=300;
        price[34]=320;
        price[37]=350;
        price[39]=400;
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




    int XonMap(int placetotal)
    {
        int place=placetotal%40;
        if (place==-1) return -100;
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
        if (place==21) return 120;
        if (place==22) return 190;
        if (place==23) return 262;
        if (place==24) return 335;
        if (place==25) return 405;
        if (place==26) return 478;
        if (place==27) return 555;
        if (place==28) return 622;
        if (place==29) return 700;
        if (place==30) return 772;
        if (place==31) return 772;
        if (place==32) return 772;
        if (place==33) return 772;
        if (place==34) return 772;
        if (place==35) return 772;
        if (place==36) return 772;
        if (place==37) return 772;
        if (place==38) return 772;
        if (place==39) return 772;
        return 400;
    }
    int YonMap(int placetotal)
    {
        int place=placetotal%40;
        if (place==-1) return -100;
        if (place==0) return 800;
        if (place==1) return 800;
        if (place==2) return 800;
        if (place==3) return 800;
        if (place==4) return 800;
        if (place==5) return 800;
        if (place==6) return 800;
        if (place==7) return 800;
        if (place==8) return 800;
        if (place==9) return 800;
        if (place==10) return 772-15;
        if (place==11) return 700-15;
        if (place==12) return 622-15;
        if (place==13) return 555-15;
        if (place==14) return 478-15;
        if (place==15) return 405-15;
        if (place==16) return 335-15;
        if (place==17) return 262-15;
        if (place==18) return 190-15;
        if (place==19) return 120-15;
        if (place==20) return 30;
        if (place==21) return 30;
        if (place==22) return 30;
        if (place==23) return 30;
        if (place==24) return 30;
        if (place==25) return 30;
        if (place==26) return 30;
        if (place==27) return 30;
        if (place==28) return 30;
        if (place==29) return 30;
        if (place==30) return 30;
        if (place==31) return 120-15;
        if (place==32) return 190-15;
        if (place==33) return 262-15;
        if (place==34) return 335-15;
        if (place==35) return 405-15;
        if (place==36) return 478-15;
        if (place==37) return 555-15;
        if (place==38) return 622-15;
        if (place==39) return 700-15;

        return 400;
    }
    public int returnprice(int place)
    {
        return price[place%40];
    }








}
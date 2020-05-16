package com.company;

import java.util.Arrays;

public class GameLogic {

    static int price[]=new int[40];
    static int owner[]=new int[40];
    static int numofhouses[]=new int[40];
    static int partsarr[][]=new int[40][7];

    public GameLogic()
    {
        Arrays.fill(owner,0);
        Arrays.fill(numofhouses,0);
        fillpricearray();
        fillpartsarr();

    }

    void fillpartsarr()
    {
        //partsarr[3]=new int[]{};
        partsarr[1]= new int[]{2, 4, 10, 30, 90, 160, 250};
        partsarr[3]=new int[]{4,8,20,60,180,320,450};
        partsarr[6]=new int[]{6,12,30,90,270,400,550};
        partsarr[8]=new int[]{6,12,30,90,270,400,550};
        partsarr[9]=new int[]{8,16,40,100,300,450,600};

        partsarr[11]=new int[]{10,20,50,150,450,625,750};
        partsarr[13]=new int[]{10,20,50,150,450,625,750};
        partsarr[14]=new int[]{12,24,60,180,500,700,900};
        partsarr[16]=new int[]{14,28,70,200,550,750,950};
        partsarr[18]=new int[]{14,28,70,200,550,750,950};
        partsarr[19]=new int[]{16,32,80,220,600,800,1000};

        partsarr[21]=new int[]{18,36,90,250,700,875,1050};
        partsarr[23]=new int[]{18,36,90,250,700,875,1050};
        partsarr[24]=new int[]{20,40,100,300,750,925,1100};
        partsarr[26]=new int[]{22,44,110,330,800,975,1150};
        partsarr[27]=new int[]{22,44,110,330,800,975,1150};
        partsarr[29]=new int[]{24,48,120,360,850,1025,1200};

        partsarr[31]=new int[]{26,52,130,390,900,1100,1275};
        partsarr[32]=new int[]{26,52,130,390,900,1100,1275};
        partsarr[34]=new int[]{28,56,150,450,1000,1200,1400};
        partsarr[37]=new int[]{35,70,175,500,1100,1300,1500};
        partsarr[39]=new int[]{50,100,200,600,1400,1700,2000};


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

    int XonMapposition(int placetotal)
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

        int tempdef=100;
        if (place==11) return tempdef;
        if (place==12) return tempdef;
        if (place==13) return tempdef;
        if (place==14) return tempdef;
        if (place==15) return tempdef;
        if (place==16) return tempdef;
        if (place==17) return tempdef;
        if (place==18) return tempdef;
        if (place==19) return tempdef;
        if (place==20) return tempdef;
        if (place==21) return 120;
        if (place==22) return 190;
        if (place==23) return 262;
        if (place==24) return 335;
        if (place==25) return 405;
        if (place==26) return 478;
        if (place==27) return 555;
        if (place==28) return 622;
        if (place==29) return 700;

        int tmpdef2=720;
        if (place==30) return tmpdef2;
        if (place==31) return tmpdef2;
        if (place==32) return tmpdef2;
        if (place==33) return tmpdef2;
        if (place==34) return tmpdef2;
        if (place==35) return tmpdef2;
        if (place==36) return tmpdef2;
        if (place==37) return tmpdef2;
        if (place==38) return tmpdef2;
        if (place==39) return tmpdef2;
        return 400;
    }
    int YonMapposition(int placetotal)
    {
        int place=placetotal%40;
        if (place==-1) return -100;

        int tmpdef=720;
        if (place==0) return tmpdef;
        if (place==1) return tmpdef;
        if (place==2) return tmpdef;
        if (place==3) return tmpdef;
        if (place==4) return tmpdef;
        if (place==5) return tmpdef;
        if (place==6) return tmpdef;
        if (place==7) return tmpdef;
        if (place==8) return tmpdef;
        if (place==9) return tmpdef;
        if (place==10) return 772;
        if (place==11) return 700;
        if (place==12) return 622;
        if (place==13) return 555;
        if (place==14) return 478;
        if (place==15) return 405;
        if (place==16) return 335;
        if (place==17) return 262;
        if (place==18) return 190;
        if (place==19) return 120;

        int tmpdef2=100;
        if (place==20) return tmpdef2;
        if (place==21) return tmpdef2;
        if (place==22) return tmpdef2;
        if (place==23) return tmpdef2;
        if (place==24) return tmpdef2;
        if (place==25) return tmpdef2;
        if (place==26) return tmpdef2;
        if (place==27) return tmpdef2;
        if (place==28) return tmpdef2;
        if (place==29) return tmpdef2;
        if (place==30) return tmpdef2;
        if (place==31) return 120;
        if (place==32) return 190;
        if (place==33) return 262;
        if (place==34) return 335;
        if (place==35) return 405;
        if (place==36) return 478;
        if (place==37) return 555;
        if (place==38) return 622;
        if (place==39) return 700;

        return 400;
    }








}
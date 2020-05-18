package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

class MyJComponent extends JComponent {

    Timer t;
    Timer t2;
    Timer taxtimer;
    Timer starttimer;
    Timer payfeetimer;
    static int NumberOfPlayers=0;
    static int CurrentPlayer=1;
    boolean CanEndTurn=false;
    boolean CanRollDice=true;
    static int CurrentDiceRoll=0;
    boolean IsGameGoing=false;
    boolean CanShowImage=false;
    boolean CanBuy=false;
    boolean CanManageprops=true;


    JButton End_Turn = new JButton("End Turn");
    JButton Buyb = new JButton("BUY");
    JButton RollDice = new JButton("Roll Dice");
    JButton ManageProp = new JButton("Manage Properties");
    JLabel Dice1=new JLabel("");
    JLabel Dice2=new JLabel("");
    JLabel currimglabel=new JLabel();
    JLabel currentowneris=new JLabel();



    public void paint(Graphics g) {

        g.setColor(Color.green);
        if (IsGameGoing)
        {
            try {
                BufferedImage image = ImageIO.read(getClass().getResource("/monopoly-plansza.jpg"));
                g.drawImage(image,0,0,null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.paintComponents(g);


    }


    public ImageIcon createImageIcon(String path,
                                     String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public Player getCurrent(int i)
    {
        if(i==1) return P1;
        if(i==2) return P2;
        if(i==3) return P3;
        return P4;
    }

    public Player getCurrent()
    {
        int i=CurrentPlayer;
        if(i==1) return P1;
        if(i==2) return P2;
        if(i==3) return P3;
        return P4;
    }


    GameLogic G1=new GameLogic();

    Player P1=new Player();
    Player P2=new Player();
    Player P3=new Player();
    Player P4=new Player();

    JLabel P1l=new JLabel();
    JLabel P2l=new JLabel();
    JLabel P3l=new JLabel();
    JLabel P4l=new JLabel();


    JLabel playerlabel=new JLabel();
    void currentplayerthread()
    {
        remove(playerlabel);
        String tmpcurrentplayer=String.valueOf(CurrentPlayer);

        int cpmoney=-888;
        if(CurrentPlayer==1)
        {
            cpmoney=P1.money;
            playerlabel.setForeground(Color.RED);
        }
        if(CurrentPlayer==2)
        {
            cpmoney=P2.money;
            playerlabel.setForeground(Color.BLACK);
        }
        if(CurrentPlayer==3)
        {
            cpmoney=P3.money;
            playerlabel.setForeground(Color.BLUE);
        }
        if(CurrentPlayer==4)
        {
            cpmoney=P4.money;
            playerlabel.setForeground(Color.magenta);
        }
        String cmponeystring=String.valueOf(cpmoney)+"M";

        playerlabel.setText("The current player is: "+tmpcurrentplayer+" "+cmponeystring);
        playerlabel.setFont(new Font("Serif", Font.PLAIN, 30));
        playerlabel.setBounds(200, 120, 400, 80);
        add(playerlabel);

        P1l.setBounds(G1.XonMap(P1.position),G1.YonMap(P1.position),35,40);
        P2l.setBounds(G1.XonMap(P2.position)+35,G1.YonMap(P2.position),35,40);
        P3l.setBounds(G1.XonMap(P3.position),G1.YonMap(P3.position)+40,35,40);
        P4l.setBounds(G1.XonMap(P4.position)+35,G1.YonMap(P4.position)+40,35,40);

        P1l.setText("P1");
        P2l.setText("P2");
        P3l.setText("P3");
        P4l.setText("P4");

        P1l.setForeground(Color.RED);
        P2l.setForeground(Color.BLACK);
        P3l.setForeground(Color.BLUE);
        P4l.setForeground(Color.magenta);

        P1l.setFont(new Font("Serif", Font.BOLD, 30));
        P2l.setFont(new Font("Serif", Font.BOLD, 30));
        P3l.setFont(new Font("Serif", Font.BOLD, 30));
        P4l.setFont(new Font("Serif", Font.BOLD, 30));

        add(P1l);
        add(P2l);
        add(P3l);
        add(P4l);


        //repaint(270,100,300,80);
        repaint(0,0,900,900);
    }


    JLabel p1money=new JLabel();
    JLabel p2money=new JLabel();
    JLabel p3money=new JLabel();
    JLabel p4money=new JLabel();
    void showmoney()
    {
        remove(p1money);
        remove(p2money);
        remove(p3money);
        remove(p4money);
        p1money.setText("P1: "+String.valueOf(P1.money)+"M");
        p2money.setText("P2: "+String.valueOf(P2.money)+"M");
        p3money.setText("P3: "+String.valueOf(P3.money)+"M");
        p4money.setText("P4: "+String.valueOf(P4.money)+"M");

        p1money.setFont(new Font("Serif", Font.PLAIN, 20));
        p2money.setFont(new Font("Serif", Font.PLAIN, 20));
        p3money.setFont(new Font("Serif", Font.PLAIN, 20));
        p4money.setFont(new Font("Serif", Font.PLAIN, 20));

        p1money.setForeground(Color.RED);
        p2money.setForeground(Color.BLACK);
        p3money.setForeground(Color.BLUE);
        p4money.setForeground(Color.magenta);

        p1money.setBounds(150,330,150,50);
        p2money.setBounds(250,330,150,50);
        p3money.setBounds(150,360,150,50);
        p4money.setBounds(250,360,150,50);

        add(p1money);
        add(p2money);
        if(NumberOfPlayers>2) add(p3money);
        if(NumberOfPlayers==4) add(p4money);
        repaint(0,0,900,900);

    }


    JLabel board[]=new JLabel[40];
    void showowner()
    {
        for (int i=0; i<40; i++)
        {
            board[i]=new JLabel("TEST");
        }
        for (int i=0; i<40; i++)
        {
            remove(board[i]);
        }
        for (int i=0; i<40; i++)
        {

            board[i].setFont(new Font("Arial", Font.BOLD, 20));
            board[i].setForeground(Color.black);
            board[i].setText("P"+String.valueOf(GameLogic.owner[i]));
            board[i].setBounds(G1.XonMapposition(i)+20,G1.YonMapposition(i),60,60);
            if(GameLogic.owner[i]==1) board[i].setForeground(Color.RED);
            if(GameLogic.owner[i]==2) board[i].setForeground(Color.BLACK);
            if(GameLogic.owner[i]==3) board[i].setForeground(Color.BLUE);
            if(GameLogic.owner[i]==4) board[i].setForeground(Color.magenta);

            if(GameLogic.owner[i]!=0) add(board[i]);
            //System.out.println(board[i]);

        }
        repaint(0,0,900,900);
    }


    JLabel taxlabel=new JLabel();
    public void PayTaxIfNeeded()
    {
        remove(taxlabel);
        taxlabel.setFont(new Font("Serif", Font.PLAIN, 50));
        taxlabel.setBounds(400,500,500,200);
        int tmp=getCurrent().position%40;
        if (tmp==38)
        {
            getCurrent().money-=100;
            taxlabel.setText("TAX! -100M");
        }

        if (tmp==4)
        {
            getCurrent().money-=200;
            taxlabel.setText("TAX! -200M");
        }
        if(tmp==4||tmp==38)
        {
            showmoney();
            add(taxlabel);
            taxtimer=new Timer(300, new ActionListener() {
                int i=0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (i==0) taxlabel.setForeground(Color.BLACK);
                    if (i==1) taxlabel.setForeground(Color.DARK_GRAY);
                    if (i==2) taxlabel.setForeground(Color.gray);
                    if(i==3)
                    {
                        remove(taxlabel);
                        taxtimer.stop();
                        repaint(0,0,900,900);
                    }
                    i++;
                }
            });
            taxtimer.start();
        }
        repaint(0,0,900,900);
    }


    JLabel startlabel=new JLabel();
    public void GetMoneyOnStart()
    {
        int a=getCurrent().position/40;
        int b=(getCurrent().position+CurrentDiceRoll)/40;
        //System.out.println(a+" "+b);
        if (a!=b)
        {
            //System.out.println("ADDING MOENY");
            getCurrent().money+=200;
            remove(startlabel);
            startlabel.setFont(new Font("Serif", Font.PLAIN, 50));
            startlabel.setBounds(400,400,500,200);
            startlabel.setText("START! 200M");
            add(startlabel);
            starttimer=new Timer(300, new ActionListener() {
                int i=0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (i==0) startlabel.setForeground(Color.green);
                    if (i==1) startlabel.setForeground(Color.yellow);
                    if (i==2) startlabel.setForeground(Color.red);
                    if (i==3) startlabel.setForeground(Color.blue);
                    if (i==4) startlabel.setForeground(Color.magenta);
                    if (i==5) startlabel.setForeground(Color.black);
                    if (i==6) startlabel.setForeground(Color.white);
                    if (i==7) startlabel.setForeground(Color.green);
                    if(i==8)
                    {
                        remove(startlabel);
                        starttimer.stop();
                        repaint(0,0,900,900);
                    }
                    i++;
                }
            });
            starttimer.start();



        }
        repaint(0,0,900,900);
    }


    JLabel Payfeel=new JLabel();
    public void Payfee()
    {
        remove(Payfeel);
        Payfeel.setFont(new Font("Serif", Font.PLAIN, 40));
        Payfeel.setBounds(400,500,500,200);
        int tmp=getCurrent().position%40;
        int moneytransfered=0;

        if(GameLogic.price[tmp]>1&&GameLogic.owner[tmp]!=0&&GameLogic.owner[tmp]!=CurrentPlayer)
        {
            if(GameLogic.partsarr[tmp][0]>0)
            {
                //System.out.println("NORMAL");
                int numofhouses=GameLogic.numofhouses[tmp];
                int priceoftrans=GameLogic.partsarr[tmp][numofhouses];
                moneytransfered=priceoftrans;
                Payfeel.setText("P"+String.valueOf(CurrentPlayer)+" PAYED "+"P"+String.valueOf(GameLogic.owner[tmp])+" "+String.valueOf(priceoftrans)+"M");
            }
            if(tmp==5||tmp==15||tmp==25||tmp==35)
            {
                //System.out.println("STATION");
                int stationcounter=0;
                int stationowner=GameLogic.owner[tmp];
                if(GameLogic.owner[5]==stationowner) stationcounter++;
                if(GameLogic.owner[15]==stationowner) stationcounter++;
                if(GameLogic.owner[25]==stationowner) stationcounter++;
                if(GameLogic.owner[35]==stationowner) stationcounter++;
                int priceoftrans=0;
                if (stationcounter==1) priceoftrans=25;
                if (stationcounter==2) priceoftrans=50;
                if (stationcounter==3) priceoftrans=100;
                if (stationcounter==4) priceoftrans=200;
                moneytransfered=priceoftrans;
                Payfeel.setText("P"+String.valueOf(CurrentPlayer)+" PAYED "+"P"+String.valueOf(GameLogic.owner[tmp])+" "+String.valueOf(priceoftrans)+"M");
            }
            if(tmp==12||tmp==28)
            {
                //System.out.println("UTILITY");
                int utilitycounter=0;
                int utilowner=GameLogic.owner[tmp];
                if(GameLogic.owner[12]==utilowner) utilitycounter++;
                if(GameLogic.owner[28]==utilowner) utilitycounter++;
                int multiplyier=0;
                if(utilitycounter==1) multiplyier=4;
                if(utilitycounter==2) multiplyier=10;
                int priceoftrans=multiplyier*CurrentDiceRoll;
                moneytransfered=priceoftrans;
                Payfeel.setText("P"+String.valueOf(CurrentPlayer)+" PAYED "+"P"+String.valueOf(GameLogic.owner[tmp])+" "+String.valueOf(priceoftrans)+"M");
            }

            Player ploosing=getCurrent();
            Player pgaining=getCurrent(GameLogic.owner[tmp]);
            ploosing.money-=moneytransfered;
            pgaining.money+=moneytransfered;



            showmoney();
            add(Payfeel);
            payfeetimer=new Timer(1500, new ActionListener() {
                int i=0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (i==0) Payfeel.setForeground(Color.BLACK);
                    if (i==1) Payfeel.setForeground(Color.DARK_GRAY);
                    if (i==2) Payfeel.setForeground(Color.gray);
                    if(i==3)
                    {
                        remove(Payfeel);
                        payfeetimer.stop();
                        repaint(0,0,900,900);
                    }
                    i++;
                }
            });
            payfeetimer.start();
        }
        repaint(0,0,900,900);
    }


    public void manageprops()
    {
        remove(ManageProp);
        remove(End_Turn);
        try {
            for (int i=0; i<40; i++)
            {
                remove(board[i]);
            }

        } catch (Exception e) {
        }
        JButton backtogame=new JButton("Back to game");
        backtogame.setBounds(520, 330, 200, 40);
        add(backtogame);
        repaint(0,0,900,900);
        backtogame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(backtogame);
                add(End_Turn);
                add(ManageProp);
                showowner();
                repaint(0,0,900,900);
            }
        });
    }

    MyJComponent()
    {

        GameLogic g1=new GameLogic();
        setLayout(null);
        ImageIcon image1=createImageIcon("/monopoly.jpg","");
        JLabel image1l=new JLabel(image1);
        image1l.setBounds(400-image1.getIconWidth()/2, 0, image1.getIconWidth(), image1.getIconHeight());
        add(image1l);
        JButton LocalMultipleyerButton = new JButton("Local mode");
        LocalMultipleyerButton.setBounds(330, 200, 140, 60);
        JButton OnlineMultipleyerButton = new JButton("Online multiplayer");
        OnlineMultipleyerButton.setBounds(330, 300, 140, 60);
        JButton quit = new JButton("QUIT");
        quit.setBounds(330, 400, 140, 60);
        add(LocalMultipleyerButton);
        //f.add(OnlineMultipleyerButton);
        add(quit);

        quit.addActionListener(e -> System.exit(0));

        LocalMultipleyerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                removeAll();
                repaint();
                ImageIcon image2=createImageIcon("/LocalMode.jpg","");
                JLabel image2l=new JLabel(image2);
                image2l.setBounds(400-image2.getIconWidth()/2, 0, image2.getIconWidth(), image2.getIconHeight());
                add(image2l);

                ImageIcon image3=createImageIcon("/Playersname.png","");
                JLabel image3l=new JLabel(image3);
                image3l.setBounds(400-image3.getIconWidth()/2, 130, image3.getIconWidth(), image3.getIconHeight());
                add(image3l);

                JLabel p1l=new JLabel("P1");
                p1l.setBounds(250, 250, 140, 30);
                JLabel p2l=new JLabel("P2");
                p2l.setBounds(250, 300, 140, 30);
                JLabel p3l=new JLabel("P3");
                p3l.setBounds(250, 350, 140, 30);
                JLabel p4l=new JLabel("P4");
                p4l.setBounds(250, 400, 140, 30);
                add(p1l);
                add(p2l);
                add(p3l);
                add(p4l);


                JTextField p1=new JTextField();
                p1.setBounds(330, 250, 140, 30);
                JTextField p2=new JTextField();
                p2.setBounds(330, 300, 140, 30);
                JTextField p3=new JTextField();
                p3.setBounds(330, 350, 140, 30);
                JTextField p4=new JTextField();
                p4.setBounds(330, 400, 140, 30);
                add(p1);
                add(p2);
                add(p3);
                add(p4);
                JButton StartGame = new JButton("Start game");
                StartGame.setBounds(330, 500, 140, 60);
                add(StartGame);

                StartGame.addActionListener(arg01 -> {
                    String p1name=p1.getText();
                    String p2name=p2.getText();
                    String p3name=p3.getText();
                    String p4name=p4.getText();
                    int PlayerCounter=g1.PlayerCounter(p1name,p2name,p3name,p4name);
                    //System.out.println(PlayerCounter);
                    NumberOfPlayers=PlayerCounter;

                    if (NumberOfPlayers>=2)
                    {
                        removeAll();
                        repaint();
                        if(NumberOfPlayers==2)
                        {
                            P3.ChangePosition(-1);
                            P4.ChangePosition(-1);
                        }
                        if (NumberOfPlayers==3) P4.ChangePosition(-1);


                        ImageIcon image5=createImageIcon("/StartingGameIn.jpg","");
                        JLabel image5l=new JLabel(image5);
                        image5l.setBounds(400-image5.getIconWidth()/2, 0, image5.getIconWidth(), image5.getIconHeight());
                        add(image5l);

                        JLabel timerlabel=new JLabel();
                        timerlabel.setText("5");
                        timerlabel.setFont(new Font("Serif", Font.PLAIN, 90));
                        timerlabel.setBounds(350, 300, 800, 80);
                        add(timerlabel);


                        t=new Timer(100, new ActionListener() {
                            int countdown=4;
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                timerlabel.setText(String.valueOf(countdown));
                                countdown--;
                                if (countdown==-1)
                                {
                                    timerlabel.setText("START");
                                    t.stop();
                                    t2.start();
                                }

                            }
                        });
                        t.start();

                        t2=new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                removeAll();
                                repaint();
                                currentplayerthread();
                                t2.stop();
                                IsGameGoing=true;

                                showmoney();

                                Dice1.setBounds(450, 210, 140, 30);
                                Dice1.setFont(new Font("Serif", Font.PLAIN, 30));

                                Dice2.setBounds(480, 210, 140, 30);
                                Dice2.setFont(new Font("Serif", Font.PLAIN, 30));



                                End_Turn.setBounds(620, 150, 100, 40);
                                add(End_Turn);




                                End_Turn.addActionListener(e13 -> {
                                    if(CanEndTurn==true)
                                    {
                                        remove(startlabel);
                                        remove(taxlabel);
                                        remove(Payfeel);
                                        CanBuy=false;
                                        remove(currentowneris);
                                        remove(Buyb);
                                        remove(currimglabel);
                                        CanShowImage=false;
                                        CanEndTurn=false;
                                        CurrentDiceRoll=0;
                                        Dice1.setText("");
                                        Dice2.setText("");
                                        CanRollDice=true;
                                        CurrentPlayer++;
                                        if(CurrentPlayer>NumberOfPlayers)
                                        {
                                            CurrentPlayer=1;
                                        }
                                        currentplayerthread();
                                        //System.out.println(CurrentPlayer);
                                    }
                                });

                                RollDice.setBounds(620, 210, 100, 40);
                                add(RollDice);



                                RollDice.addActionListener(e12 -> {
                                    if(CanRollDice==true)
                                    {
                                        CanBuy=true;
                                        remove(startlabel);
                                        remove(taxlabel);
                                        remove(Payfeel);
                                        remove(Buyb);
                                        remove(currimglabel);
                                        CanShowImage=true;

                                        int random1 = (int)(Math.random() * 6 + 1);
                                        int random2 = (int)(Math.random() * 6 + 1);
                                        //int random1=12;
                                        //int random2=0;

                                        Dice1.setText(String.valueOf(random1));
                                        Dice2.setText(String.valueOf(random2));
                                        add(Dice1);
                                        add(Dice2);
                                        CurrentDiceRoll=random1+random2;
                                        GetMoneyOnStart();
                                        if(CurrentPlayer==1) P1.ChangePosition(CurrentDiceRoll);
                                        if(CurrentPlayer==2) P2.ChangePosition(CurrentDiceRoll);
                                        if(CurrentPlayer==3) P3.ChangePosition(CurrentDiceRoll);
                                        if(CurrentPlayer==4) P4.ChangePosition(CurrentDiceRoll);


                                        repaint();
                                        CanRollDice=false;
                                        CanEndTurn=true;
                                        if (random1==random2)
                                        {
                                            CanEndTurn=false;
                                            CanRollDice=true;
                                        }

                                        String pathtoimagemovedto="/parts/"+String.valueOf(getCurrent(CurrentPlayer).position%40+".jpg");

                                        ImageIcon currentimage=createImageIcon(pathtoimagemovedto,"");
                                        currimglabel.setIcon(currentimage);
                                        currimglabel.setBounds(160,450,300,300);
                                        add(currimglabel);

                                        int ownerofcurrenttile=GameLogic.owner[getCurrent(CurrentPlayer).position%40];
                                        String currentowner="P"+String.valueOf(ownerofcurrenttile);
                                        if(ownerofcurrenttile==0)
                                        {
                                            currentowner="none";
                                        }
                                        if(ownerofcurrenttile==CurrentPlayer)
                                        {
                                            currentowner="YOU";
                                        }
                                        int currentposition=getCurrent(CurrentPlayer).position%40;

                                        currentowneris.setText("Current owner is: "+currentowner);
                                        currentowneris.setBounds(300, 270, 300, 35);
                                        currentowneris.setFont(new Font("Serif", Font.PLAIN, 30));
                                        Buyb.setBounds(620, 270, 100, 40);

                                        int priceofcurrenttile=G1.returnprice(getCurrent(CurrentPlayer).position);
                                        //System.out.println(priceofcurrenttile);

                                        if (priceofcurrenttile>0)
                                        {
                                            add(currentowneris);
                                        }

                                        if (priceofcurrenttile>0 && ownerofcurrenttile==0&&priceofcurrenttile<getCurrent().money)
                                        {
                                            add(Buyb);
                                        }
                                        PayTaxIfNeeded();
                                        Payfee();
                                        currentplayerthread();
                                        showmoney();



                                        Buyb.addActionListener(e1 -> {

                                            if(CanBuy==true)
                                            {
                                                remove(currentowneris);
                                                remove(Buyb);
                                                getCurrent(CurrentPlayer).BuyPlace(currentposition);
                                                GameLogic.owner[currentposition]=CurrentPlayer;
                                                currentowneris.setText("You bought the place!");
                                                add(currentowneris);
                                                showmoney();
                                                CanBuy=false;
                                                showowner();
                                                currentplayerthread();
                                            }
                                        });

                                    }
                                });

                                ManageProp.setBounds(520, 330, 200, 40);
                                if(CanManageprops==true)
                                {
                                    add(ManageProp);
                                }
                                ManageProp.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        manageprops();
                                    }
                                });





                            }
                        });

                    }

                });

            }
        });

    }



}
public class Main {
    public static void main(String[] arguments) {

        MyJComponent com = new MyJComponent();
        JFrame f = new JFrame("Monopoly");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.add(com);
        f.setVisible(true);
        f.pack();
        f.setSize(900,920);
        f.setLocationRelativeTo(null);
    }
}
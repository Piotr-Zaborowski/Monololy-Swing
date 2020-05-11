package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

class MyJComponent extends JComponent {

    Timer t;
    Timer t2;
    static int NumberOfPlayers=0;
    static int CurrentPlayer=1;
    boolean CanEndTurn=false;
    boolean CanRollDice=true;
    static int CurrentDiceRoll=0;
    boolean IsGameGoing=false;
    boolean CanShowImage=false;
    boolean CanBuy=false;



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

    JLabel playerlabel=new JLabel();
    Thread thread1;

    GameLogic G1=new GameLogic();

    Player P1=new Player();
    Player P2=new Player();
    Player P3=new Player();
    Player P4=new Player();

    JLabel P1l=new JLabel();
    JLabel P2l=new JLabel();
    JLabel P3l=new JLabel();
    JLabel P4l=new JLabel();


    void currentplayerthread()
    {
        thread1 = new Thread(() -> {
            while(true)
            {
                remove(playerlabel);
                String tmpcurrentplayer=String.valueOf(CurrentPlayer);

                int cpmoney=-888;
                if(CurrentPlayer==1) cpmoney=P1.money;
                if(CurrentPlayer==2) cpmoney=P2.money;
                if(CurrentPlayer==3) cpmoney=P3.money;
                if(CurrentPlayer==4) cpmoney=P4.money;
                String cmponeystring=String.valueOf(cpmoney)+"M";

                playerlabel.setText("The current player is: "+tmpcurrentplayer+" "+cmponeystring);
                playerlabel.setFont(new Font("Serif", Font.PLAIN, 30));
                playerlabel.setBounds(270, 100, 400, 80);
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
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
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

        p1money.setBounds(120,330,150,50);
        p2money.setBounds(220,330,150,50);
        p3money.setBounds(120,360,150,50);
        p4money.setBounds(220,360,150,50);

        add(p1money);
        add(p2money);
        if(NumberOfPlayers>2) add(p3money);
        if(NumberOfPlayers==4) add(p4money);

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

                StartGame.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
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
                                    JLabel Dice1=new JLabel("");
                                    Dice1.setBounds(450, 180, 140, 30);
                                    Dice1.setFont(new Font("Serif", Font.PLAIN, 30));
                                    JLabel Dice2=new JLabel("");
                                    Dice2.setBounds(480, 180, 140, 30);
                                    Dice2.setFont(new Font("Serif", Font.PLAIN, 30));


                                    JButton End_Turn = new JButton("End Turn");
                                    End_Turn.setBounds(650, 120, 100, 40);
                                    add(End_Turn);

                                    JLabel currimglabel=new JLabel();

                                    JLabel currentowneris=new JLabel();
                                    JButton Buyb = new JButton("BUY");

                                    End_Turn.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(CanEndTurn==true)
                                            {
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
                                                //System.out.println(CurrentPlayer);
                                            }
                                        }
                                    });




                                    JButton RollDice = new JButton("Roll Dice");
                                    RollDice.setBounds(650, 180, 100, 40);
                                    add(RollDice);



                                    RollDice.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(CanRollDice==true)
                                            {
                                                CanBuy=true;

                                                remove(Buyb);
                                                remove(currimglabel);
                                                CanShowImage=true;

                                                int random1 = (int)(Math.random() * 6 + 1);
                                                int random2 = (int)(Math.random() * 6 + 1);

                                                Dice1.setText(String.valueOf(random1));
                                                Dice2.setText(String.valueOf(random2));
                                                add(Dice1);
                                                add(Dice2);
                                                CurrentDiceRoll=random1+random2;

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
                                                currimglabel.setBounds(150,500,300,200);
                                                add(currimglabel);

                                                int ownerofcurrenttile=GameLogic.owner[getCurrent(CurrentPlayer).position%40];
                                                String currentowner="P"+String.valueOf(ownerofcurrenttile);
                                                if(ownerofcurrenttile==0)
                                                {
                                                    currentowner="none";
                                                }
                                                int currentposition=getCurrent(CurrentPlayer).position%40;

                                                currentowneris.setText("Current owner is: "+currentowner);
                                                currentowneris.setBounds(350, 240, 300, 30);
                                                currentowneris.setFont(new Font("Serif", Font.PLAIN, 30));
                                                Buyb.setBounds(650, 240, 100, 40);

                                                int priceofcurrenttile=G1.returnprice(getCurrent(CurrentPlayer).position);
                                                //System.out.println(priceofcurrenttile);

                                                if (priceofcurrenttile>0)
                                                {
                                                    add(currentowneris);
                                                }

                                                if (priceofcurrenttile>0 && ownerofcurrenttile==0)
                                                {
                                                    add(Buyb);
                                                }
                                                showmoney();

                                                Buyb.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {

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
                                                        }


                                                    }
                                                });


                                            }
                                        }
                                    });








                                }
                            });

                        }

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
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



    public void paint(Graphics g) {

        g.setColor(Color.green);
        if (IsGameGoing)
        {
            try {
                BufferedImage image = ImageIO.read(getClass().getResource("/plansza.jpg"));
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

    JLabel playerlabel=new JLabel();
    Thread thread1;

    void currentplayerthread()
    {
        thread1 = new Thread(() -> {
            while(true)
            {
                remove(playerlabel);
                String tmpcurrentplayer=String.valueOf(CurrentPlayer);
                playerlabel.setText("The current player is: "+tmpcurrentplayer);
                playerlabel.setFont(new Font("Serif", Font.PLAIN, 30));
                playerlabel.setBounds(270, 100, 300, 80);
                add(playerlabel);

                repaint(270,100,300,80);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
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

                                    JLabel Dice1=new JLabel("");
                                    Dice1.setBounds(450, 180, 140, 30);
                                    Dice1.setFont(new Font("Serif", Font.PLAIN, 30));
                                    JLabel Dice2=new JLabel("");
                                    Dice2.setBounds(480, 180, 140, 30);
                                    Dice2.setFont(new Font("Serif", Font.PLAIN, 30));


                                    JButton End_Turn = new JButton("End Turn");
                                    End_Turn.setBounds(570, 120, 100, 40);
                                    add(End_Turn);
                                    End_Turn.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(CanEndTurn==true)
                                            {
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
                                    RollDice.setBounds(570, 180, 100, 40);
                                    add(RollDice);
                                    RollDice.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            if(CanRollDice==true)
                                            {
                                                int random1 = (int)(Math.random() * 6 + 1);
                                                int random2 = (int)(Math.random() * 6 + 1);

                                                Dice1.setText(String.valueOf(random1));
                                                Dice2.setText(String.valueOf(random2));
                                                add(Dice1);
                                                add(Dice2);
                                                CurrentDiceRoll=random1+random2;

                                                repaint();
                                                CanRollDice=false;
                                                CanEndTurn=true;
                                                if (random1==random2)
                                                {
                                                    CanEndTurn=false;
                                                    CanRollDice=true;
                                                }
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
        f.setSize(850,850);
        f.setLocationRelativeTo(null);
    }
}
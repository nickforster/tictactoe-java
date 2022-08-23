import javafx.scene.text.TextAlignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextLayout;

public class TicTacToe implements ActionListener {
    Bot botAmZug = new Bot();

    private int spieler = 0;
    private int gegenBot = 0;
    private int counter1 = 0;
    private int counter2 = 0;
    private JLabel label = new JLabel(counter1 + " - " + counter2);
    private JFrame frame = new JFrame();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JButton button4 = new JButton();
    private JButton button5 = new JButton();
    private JButton button6 = new JButton();
    private JButton button7 = new JButton();
    private JButton button8 = new JButton();
    private JButton button9 = new JButton();
    private JButton reset = new JButton("Reset");
    private JButton bot = new JButton("Gegen Bot spielen");
    int[][] spielfeld = new int[3][3];
    JPanel panel = new JPanel();

    public TicTacToe() {
        button1.addActionListener(this::actionPerformed1);
        button2.addActionListener(this::actionPerformed2);
        button3.addActionListener(this::actionPerformed3);
        button4.addActionListener(this::actionPerformed4);
        button5.addActionListener(this::actionPerformed5);
        button6.addActionListener(this::actionPerformed6);
        button7.addActionListener(this::actionPerformed7);
        button8.addActionListener(this::actionPerformed8);
        button9.addActionListener(this::actionPerformed9);
        reset.addActionListener(this::reset);
        bot.addActionListener(this::bot);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(4, 4));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(label);
        panel.add(reset);
        panel.add(bot);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("TicTacToe");
        frame.pack();
        //frame.setSize(700, 700);
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setVisible(true);

    }

    public void actionPerformed1(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button1, 0, 0);

        botSpielen();
    }

    public void actionPerformed2(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button2, 0, 1);

        botSpielen();
    }

    public void actionPerformed3(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button3, 0, 2);

        botSpielen();
    }

    public void actionPerformed4(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button4, 1, 0);

        botSpielen();
    }

    public void actionPerformed5(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button5, 1, 1);

        botSpielen();
    }

    public void actionPerformed6(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button6, 1, 2);

        botSpielen();
    }

    public void actionPerformed7(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button7, 2, 0);

        botSpielen();
    }

    public void actionPerformed8(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button8, 2, 1);

        botSpielen();
    }

    public void actionPerformed9(ActionEvent e) {
        buttonPressedAuswertung(spielfeld, button9, 2, 2);

        botSpielen();
    }

    public void buttonPressedAuswertung(int[][] spielfeld, JButton button2, int ersteKoord, int zweiteKoord) {
        if (spieler % 2 == 0 && spielfeld[ersteKoord][zweiteKoord] == 0) {
            button2.setBackground(Color.blue);
            spielfeld[ersteKoord][zweiteKoord] = 2;
            spieler++;
        } else if (spieler % 2 == 1 && spielfeld[ersteKoord][zweiteKoord] == 0) {
            button2.setBackground(Color.red);
            spielfeld[ersteKoord][zweiteKoord] = 1;
            spieler++;
        }
        siegerErmitteln(spielfeld);

    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    void siegerErmitteln(int[][] spielfeld) {
        int sieger = 0;
        int zaehler = 0;
        for (int i = 0; i < 3; i++) {
            if (spielfeld[i][0] == spielfeld[i][1] && spielfeld[i][0] == spielfeld[i][2] && spielfeld[i][0] > 0) {
                sieger = spielfeld[i][0];
                zaehler++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (spielfeld[0][i] == spielfeld[1][i] && spielfeld[0][i] == spielfeld[2][i] && spielfeld[0][i] > 0) {
                sieger = spielfeld[0][i];
                zaehler++;
            }
        }
        if (spielfeld[0][0] == spielfeld[1][1] && spielfeld[0][0] == spielfeld[2][2] && spielfeld[1][1] > 0) {
            sieger = spielfeld[1][1];
            zaehler++;
        }
        if (spielfeld[0][2] == spielfeld[1][1] && spielfeld[0][2] == spielfeld[2][0] && spielfeld[1][1] > 0) {
            sieger = spielfeld[1][1];
            zaehler++;
        }
        if (zaehler > 1) {
            sieger = 0;
        }
        if (sieger == 2){
            sieger = 1;
        } else if (sieger != 0){
            sieger = 2;
        }


        if (sieger == 1) {
            counter1++;
            label.setText(counter1 + " - " + counter2);
            sieger(sieger);
        } else if (sieger == 2) {
            counter2++;
            label.setText(counter1 + " - " + counter2);
            sieger(sieger);
        }
    }

    public void reset(ActionEvent e) {
        spieler = 0;
        //counter1 = 0;
        //counter2 = 0;
        botAmZug.zuSpielen = 0;
        botAmZug.gespielt = 0;
        botAmZug.erstZug = 0;
        botAmZug.zweitZug = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                spielfeld[i][j] = 0;
            }
        }
        label.setText(counter1 + " - " + counter2);
        button1.setBackground(Color.white);
        button2.setBackground(Color.white);
        button3.setBackground(Color.white);
        button4.setBackground(Color.white);
        button5.setBackground(Color.white);
        button6.setBackground(Color.white);
        button7.setBackground(Color.white);
        button8.setBackground(Color.white);
        button9.setBackground(Color.white);
    }

    public void bot(ActionEvent e) {
        gegenBot++;
        if (gegenBot % 2 == 1) {
            bot.setText("Nicht mehr gegen Bot spielen");
        } else {
            bot.setText("Gegen Bot spielen");
        }
    }

    private void sieger(int sieger) {
        JPanel panel2 = new JPanel();
        JFrame frame2 = new JFrame();
        JLabel label2 = new JLabel("Spieler " + sieger + " ist Sieger");
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(1, 1));
        panel2.add(label2);
        frame2.add(panel2, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Sieger");
        frame2.pack();
        frame2.setMinimumSize(new Dimension(300, 300));
        frame2.setVisible(true);
    }

    public void botSpielen() {
        if (gegenBot % 2 == 1) {
            if (spieler % 2 == 1) {
                int zuSpielen = botAmZug.botSpielen(spielfeld);

                switch (zuSpielen) {
                    case 1:
                        buttonPressedAuswertung(spielfeld, button1, 0, 0);
                        break;
                    case 2:
                        buttonPressedAuswertung(spielfeld, button2, 0, 1);
                        break;
                    case 3:
                        buttonPressedAuswertung(spielfeld, button3, 0, 2);
                        break;
                    case 4:
                        buttonPressedAuswertung(spielfeld, button4, 1, 0);
                        break;
                    case 5:
                        buttonPressedAuswertung(spielfeld, button5, 1, 1);
                        break;
                    case 6:
                        buttonPressedAuswertung(spielfeld, button6, 1, 2);
                        break;
                    case 7:
                        buttonPressedAuswertung(spielfeld, button7, 2, 0);
                        break;
                    case 8:
                        buttonPressedAuswertung(spielfeld, button8, 2, 1);
                        break;
                    case 9:
                        buttonPressedAuswertung(spielfeld, button9, 2, 2);
                        break;
                }
            }
        }
    }
}
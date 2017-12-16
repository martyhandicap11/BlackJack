package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GUI extends JFrame
{

    /**
     * Actual screen resolution
     */
    int actualWidth = 1300;
    int actualHeight = 800;

    //colors
    Color colorBackground = new Color(39,118,28);
    Color colorButton = new Color(204,204, 0);

    //fonts
    Font fontBtn = new Font("Times New Roman", Font.PLAIN, 30);
    Font fontCard = new Font("Times New Roman", Font.BOLD, 30);

    //Buttons
    JButton btnHit = new JButton();
    JButton btnStay = new JButton();
    JButton btnYes = new JButton();
    JButton btnNo = new JButton();

    //card grid position and dimensions
    int gridX = 50;
    int gridY = 50;
    int gridW = 900;
    int gridH = 420;

    //card dimensions and spacing
    int cardSpacing = 10;
    int cardEdgeSofting = 7;
    int cardTotalWidth = gridW/6;
    int cardTotalHeight = gridH/2;
    int cardActualWidth  = cardTotalWidth - 2 * cardSpacing;
    int cardActualHeight = cardTotalHeight -2 * cardSpacing;


    //totals and hit-stay positioning and dimensions
    int hitStayX = gridX + gridW + 50;
    int hitStayY = gridY;
    int hitStayW = 230;
    int hitStayH = 400;

    //play more question grid positioning and dimensions
    int playMoreX = hitStayX;
    int playMoreY = hitStayY + hitStayH + 50;
    int playMoreW = hitStayW;
    int playMoreH = 200;

    //arraylist that contains all the cards
    ArrayList<Card> allCards = new ArrayList<Card>();
    ArrayList<Card> playerCards = new ArrayList<Card>();
    ArrayList<Card> dealerCards = new ArrayList<Card>();

    //integer used to generate random numbers for the cards to be given
    int rand = new Random().nextInt(52);

    public GUI()
    {
        this.setSize(actualWidth+6,actualHeight+29);
        this.setTitle("BlackJack");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        this.setContentPane(board);
        this.setLayout(null);

        /**
         * All aspects of Buttons Used
         */

        ActHit aHit = new ActHit();
        btnHit.addActionListener(aHit);
        btnHit.setBounds(hitStayX+ 55,hitStayY + 40, 120, 80);
        btnHit.setBackground(colorButton);
        btnHit.setFont(fontBtn);
        btnHit.setText("Hit");
        board.add(btnHit);

        ActStay aStay = new ActStay();
        btnStay.addActionListener(aStay);
        btnStay.setBounds(hitStayX + 55,hitStayY + 280, 120, 80);
        btnStay.setBackground(colorButton);
        btnStay.setFont(fontBtn);
        btnStay.setText("Stay");
        board.add(btnStay);

        ActYes aYes = new ActYes();
        btnYes.addActionListener(aYes);
        btnYes.setBounds(playMoreX + 10  ,playMoreY + 110, 100, 80);
        btnYes.setBackground(colorButton);
        btnYes.setFont(fontBtn);
        btnYes.setText("Yes");
        board.add(btnYes);

        ActNo aNo = new ActNo();
        btnNo.addActionListener(aNo);
        btnNo.setBounds(playMoreX + 120, playMoreY + 110, 100, 80);
        btnNo.setBackground(colorButton);
        btnNo.setFont(fontBtn);
        btnNo.setText("No");
        board.add(btnNo);

        String suitOfCard ;
        int id_Setter = 0;
        for (int st = 0; st < 4; st++)
        {
            if (st == 0)
            {
                suitOfCard = "Spades";
            }
            else if (st == 1)
            {
                suitOfCard = "Hearts";
            }
            else if (st == 2)
            {
                suitOfCard = "Diamonds";
            }
            else
            {
                suitOfCard = "Clubs";
            }
            for (int i = 2; i < 15; i++)
            {
                allCards.add(new Card(i,suitOfCard, id_Setter ));
                id_Setter++;
            }//end of int(i)

        }//end of fof(st)

        rand = new Random().nextInt(52);
        dealerCards.add(allCards.get(rand));
        allCards.get(rand).cardUsed = true;

        rand = new Random().nextInt(52);
        while (true)
        {
            if(allCards.get(rand).cardUsed == false)
            {
                dealerCards.add(allCards.get(rand));
                allCards.get(rand).cardUsed = true;
                break;

            }//end of if (allCards)
            else
            {
                rand = new  Random().nextInt(52);
            }

        }//end of while

        rand = new Random().nextInt(52);
        playerCards.add(allCards.get(rand));
        allCards.get(rand).cardUsed = true;

        rand = new Random().nextInt(52);
        while (true)
        {
            if(allCards.get(rand).cardUsed == false)
            {
                playerCards.add(allCards.get(rand));
                allCards.get(rand).cardUsed = true;
                break;

            }//end of if (allCards)
            else
            {
                rand = new  Random().nextInt(52);
            }
        }//end of while

        for (Card crd : playerCards)
        {
            System.out.println("Player has the card\t" + crd.cardName
            + "\tof\t" + crd.cardSuit);

        }//end of for(playerCards)

        for (Card crd : dealerCards)
        {
            System.out.println("Dealer has the card\t" + crd.cardName
                    + "\tof\t" + crd.cardSuit);

        }//end of for(dealerCards)

    }//end of constructor

    /**
     * Create class to draw all the
     * required to create graphics
     */
    public class Board extends JPanel
    {
        public void paintComponent(Graphics graphics)
        {
            graphics.setColor(colorBackground);
            graphics.fillRect(0,0, actualWidth, actualHeight);

            //temporary grid painting
            graphics.setColor(Color.black);
            graphics.drawRect(gridX,gridY,gridW,gridH);

            //temporary log borders painting
            graphics.drawRect(gridX, gridY + gridH + 50, gridW, 500);

            //temporary totals and hit-stay messages and buttons grid
            graphics.drawRect(hitStayX,hitStayY,hitStayW,hitStayH);

            //temporary play more grid
            graphics.drawRect(playMoreX,playMoreY,playMoreW,playMoreH);

            /**
             * This for loop will generate grids for
             * both players and dealers cards
             */
            for (int i = 0; i < 6; i++)
            {
                //Players Cards Grid
                graphics.drawRect(gridX +i * cardTotalWidth + cardSpacing, gridY + cardSpacing, cardActualWidth, cardActualHeight);

                //Dealers Cards Grid
               graphics.drawRect(gridX +i * cardTotalWidth + cardSpacing,
                       gridY + cardSpacing + cardTotalHeight, cardActualWidth, cardActualHeight);

            }//end of for

            int index = 0;
            //Draw player's cards
            for (Card cd : playerCards)
            {
                graphics.setColor(Color.white);
                graphics.fillRect(gridX +index * cardTotalWidth + cardSpacing, gridY + cardSpacing + cardEdgeSofting, cardActualWidth, cardActualHeight -2 * cardEdgeSofting);

                graphics.fillOval(gridX +index * cardTotalWidth + cardSpacing, gridY + cardSpacing, 2 * cardEdgeSofting, 2 * cardEdgeSofting);
                graphics.fillOval(gridX +index * cardTotalWidth + cardSpacing + cardActualWidth - 2 * cardEdgeSofting, gridY + cardSpacing, 2 * cardEdgeSofting, 2 * cardEdgeSofting);
                graphics.fillOval(gridX +index * cardTotalWidth + cardSpacing, gridY + cardSpacing + cardActualHeight - 2 * cardEdgeSofting, 2 * cardEdgeSofting, 2 * cardEdgeSofting);
                graphics.fillOval(gridX +index * cardTotalWidth + cardSpacing + cardActualWidth - 2 * cardEdgeSofting, gridY + cardSpacing + cardActualHeight - 2 * cardEdgeSofting, 2 * cardEdgeSofting, 2 * cardEdgeSofting);

                graphics.fillRect(gridX +index * cardTotalWidth + cardSpacing + cardEdgeSofting, gridY + cardSpacing , cardActualWidth - 2 * cardEdgeSofting, cardActualHeight);

                graphics.setColor(Color.black);
                if (cd.cardSuit.equalsIgnoreCase("Hearts") || cd.cardSuit.equalsIgnoreCase("Diamonds"))
                {
                    graphics.setColor(Color.RED);
                }

                graphics.setFont(fontCard);
                graphics.drawString(cd.cardSymbol, gridX + index * cardTotalWidth + cardSpacing *2 , gridY + cardSpacing + cardActualHeight);


               if (cd.cardSuit.equalsIgnoreCase("Spades"))
                {
                    graphics.setColor(Color.black);
                    graphics.fillOval(gridX + index * cardTotalWidth + 40, gridY + 85, 40, 40);
                    graphics.fillOval(gridX + index * cardTotalWidth + 70, gridY + 85, 40, 40);
                    graphics.fillArc(gridX + index * cardTotalWidth + 30, gridY + 28, 90, 70, 230,80);
                    graphics.fillRect(gridX + index * cardTotalWidth + 70, gridY + 90, 10, 50 );
                }
               else if (cd.cardSuit.equalsIgnoreCase("Hearts"))
                    {
                    graphics.setColor(Color.red);
                    graphics.fillOval(gridX + index * cardTotalWidth + 40, gridY + 70, 40, 40);
                    graphics.fillOval(gridX + index * cardTotalWidth + 70, gridY + 70, 40, 40);
                    graphics.fillArc(gridX + index * cardTotalWidth + 30, gridY + 96, 90, 70, 50,80);

                }
               else if (cd.cardSuit.equalsIgnoreCase("Diamonds"))
                {
                    int x1,x2,x3,x4,y1,y2,y3,y4;

                    x1 = 75 + gridX + index * cardTotalWidth;
                    y1 = 60 + gridY;
                    x2 = 50  + gridX + index * cardTotalWidth;;
                    y2 = 100 + gridY;
                    x3 = 75  + gridX + index * cardTotalWidth;;
                    y3 = 140 + gridY;
                    x4 = 100  + gridX + index * cardTotalWidth;;
                    y4 = 100 + gridY;

                    int [] xDiamond= {x1,x2,x3,x4};
                    int [] yDiamond= {y1,y2,y3,y4};
                    graphics.setColor(Color.red);
                    graphics.fillPolygon(xDiamond,yDiamond, 4);


                }
               else
                {
                  graphics.setColor(Color.black);
                  graphics.fillOval(gridX + index * cardTotalWidth + 35, gridY + 85, 40, 40);
                  graphics.fillOval(gridX + index * cardTotalWidth + 75, gridY + 85, 40, 40);
                  graphics.fillOval(gridX +index * cardTotalWidth + 55, gridY + 55, 40, 40);
                  graphics.fillRect(gridX + index * cardTotalWidth + 70, gridY + 90, 10, 50 );
                }

                index++;


            }//end of for (Card cd playerCards)



        }//end of paintComponent

    }//end of Board

    public class ActHit implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("You just clicked the HIT button!");
        }

    }//end of ActHit

    public class ActStay implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("You just clicked the STAY button!");

        }
    }

    public class ActYes implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("You just clicked the YES button!");

        }
    }

    public class ActNo implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("You just clicked the NO button!");

        }
    }

}// end of class GUU

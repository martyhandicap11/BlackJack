package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame
{

    /**
     * Actual screen resolution
     */
    int actualWidth = 1200;
    int actualHeight = 800;

    //colors
    Color colorBackground = new Color(39,118,28);
    Color colorButton = new Color(204,204, 0);

    //fonts
    Font fontBtn = new Font("Times New Roman", Font.PLAIN, 30);
    Font fontBtn01 = new Font("Times New Roman", Font.PLAIN, 20);
    Font fontBtn02 = new Font("Times New Roman", Font.PLAIN, 20);

    //Buttons
    JButton btnHit = new JButton();
    JButton btnStay = new JButton();
    JButton btnYes = new JButton();
    JButton btnNo = new JButton();

    //card grid position and dimensions
    int gridX = 50;
    int gridY = 50;
    int gridW = 900;
    int gridH = 400;

    //totals and hit-stay positioning and dimensions
    int hitStayX = gridX + gridW + 50;
    int hitStayY = gridY;
    int hitStayW = 150;
    int hitStayH = 400;

    //play more question grid positioning and dimensions
    int playMoreX = hitStayX;
    int playMoreY = hitStayY + hitStayH + 50;
    int playMoreW = hitStayW;
    int playMoreH = 200;

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
        btnHit.setBounds(hitStayX+18,hitStayY + 40, 120, 80);
        btnHit.setBackground(colorButton);
        btnHit.setFont(fontBtn);
        btnHit.setText("Hit");
        board.add(btnHit);

        ActStay aStay = new ActStay();
        btnStay.addActionListener(aStay);
        btnStay.setBounds(hitStayX + 18,hitStayY + 290, 120, 80);
        btnStay.setBackground(colorButton);
        btnStay.setFont(fontBtn);
        btnStay.setText("Stay");
        board.add(btnStay);

        ActYes aYes = new ActYes();
        btnYes.addActionListener(aYes);
        btnYes.setBounds(playMoreX + 2  ,playMoreY + 110, 60, 40);
        btnYes.setBackground(colorButton);
        btnYes.setFont(fontBtn02);
        btnYes.setText("Yes");
        board.add(btnYes);

        ActNo aNo = new ActNo();
        btnNo.addActionListener(aNo);
        btnNo.setBounds(playMoreX + 80, playMoreY + 110, 60, 40);
        btnNo.setBackground(colorButton);
        btnNo.setFont(fontBtn01);
        btnNo.setText("No");
        board.add(btnNo);

    }//end of public GUI

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

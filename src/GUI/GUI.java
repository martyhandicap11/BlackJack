package GUI;

import javax.swing.*;

public class GUI extends JFrame
{
    int actualWidth = 1200;
    int actualHeight = 800;

    public GUI()
    {
        this.setSize(actualWidth+6,actualHeight+29);
        this.setTitle("BlackJack");
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }//end of public GUI


}// end of class GUU

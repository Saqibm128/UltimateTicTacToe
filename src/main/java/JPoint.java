
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author saqib
 */
public class JPoint extends Point{
    private JButton pointButton;
    private boolean isTurn=true;
    private static boolean isX=true;
    private int row;
    private int col;
    private static int nextrow=-1;
    private static int nextcol=-1;
    private static String comment="ULTIMATE TIC TAC TOE!!";
    
    
    public JPoint(int row, int col)
    {
        super();
        this.row=row;
        this.col=col;
        pointButton= new JButton(" ");
        pointButton.setPreferredSize(new Dimension(60, 60));
        pointButton.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                {
                    if(isTurn)
                {
                    play(isX);
                    isX=!isX;
                }
                }
                });
    }
    public static String getComment()
    {
        return comment;
    }
    @Override
    public boolean play(boolean isX)//updated play method where true if move possible
    {
        boolean temp=false;
        temp= super.play(isX);
        if(this.isFinished())
        if(isX)
            pointButton.setText("X");
        else
            pointButton.setText("O");
        nextrow=row;
        nextcol=col;
        return temp;
    }
    
    public static int nextRow()
    {
        return nextrow;
    }
    
    public static int nextCol()
    {
        return nextcol;
    }
    
    public void turn(boolean isTurn)
    {
        this.isTurn=isTurn;
 
    }
    public JButton button()
    {
        return this.pointButton;
    }
    public static boolean getX()
    {
        return isX;
    }
}

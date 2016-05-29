/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author saqib
 */
public class NormalBoard extends Winnable {
    
    public NormalBoard(int num)//initialize a board with pieces
    {
        super(num);
        for(int row=0; row<num; row++)
            for(int col=0; col<num; col++)
            {
                this.replace(new JPoint(row, col), row, col);
            }
    }
    @Override
    public boolean play(boolean isX, int row, int col)//play a move
    {
        return this.access(row, col).play(isX);
        
    }
   
    public String toString(int row) //this is necessary to properly format ultimate board
    {
        String temp="";
        for(int col=0; col<this.getNum(); col++)
            temp+=this.access(row, col).toString();
        return temp;
    }
}
  





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingApp;

import Model.NormalBoard;
import Model.Winnable;

/**
 *
 * @author saqib
 */
public class JNormalBoard extends NormalBoard {
    public JNormalBoard(int num)
    {
        super(num);
    }
    public void turnOn(boolean isX)
            {
                if(!this.isFinished())
                {
                int num=this.getNum();
                for(int row=0; row<num; row++)
                    for(int col=0; col<num; col++)
                    {
                        Winnable temp = this.access(row, col);
                        ((JPoint)temp).turn(true);
                    }
                }
                else
                    this.turnOff();
                
            }
    public void turnOff()
            {
                int num=this.getNum();
                for(int row=0; row<num; row++)
                    for(int col=0; col<num; col++)
                    {
                        Winnable temp=this.access(row, col);
                        ((JPoint)temp).turn(false);
                    }
                
            }
    
}

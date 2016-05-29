/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingApp;

import Model.UltimateBoard;
import Model.Winnable;

/**
 *
 * @author saqib
 */
public class JUltimateBoard extends UltimateBoard {
    public JUltimateBoard(int num)
    {
        super(num);
    }
    public void turnOn(boolean isX)
            {
                int num=this.getNum();
                for(int row=0; row<num; row++)
                    for(int col=0; col<num; col++)
                    {
                        Winnable temp=this.access(row, col);
                        ((JNormalBoard)temp).turnOn(isX);
                    }
                
            }
    public void turnOff(boolean isX)
            {
                int num=this.getNum();
                for(int row=0; row<num; row++)
                    for(int col=0; col<num; col++)
                    {
                        Winnable temp=this.access(row, col);
                        ((JNormalBoard)temp).turnOff();
                    }
                
            }
}

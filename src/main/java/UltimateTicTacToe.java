/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe;
import java.util.*;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author saqib
 */
public class UltimateTicTacToe extends JFrame{
    private static JUltimateBoard board;
    private static boolean isX=false;
    private static Scanner scan= new Scanner(System.in);
    private static int keyNum=1;
    private static final int CELLSIZE=60;
    private int width;
    private int height;
    private static JTextField comment;
    private static Object lock= new Object();
    private void initUI(int num) {
        comment= new JTextField("ULTIMATE TIC TAC TOE!!!", width-CELLSIZE);
        Container cp=this.getContentPane();
        comment.setEditable(false);
        
        cp.setLayout(new BorderLayout());
        Container bottomPart = new Container();
       
    bottomPart.setLayout(new FlowLayout());
    for(int i=0; i<num*num*num*num; i++)
        {
            bottomPart.add(((JPoint)(board.superAccess().get(i))).button());
        }
    
        setTitle("Ultimate Tic Tac Toe!!");
        cp.add(comment, BorderLayout.NORTH);
        setSize(width,height );
        cp.add(bottomPart, BorderLayout.CENTER);
        
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
public UltimateTicTacToe(int num)
{
    width=CELLSIZE*(num*num+2);
    height=CELLSIZE*(num*num+2);
    initUI(num);
    
}

public static void main(String[] args)
{
    int num,superRow, superCol, row, col;
        /*
        System.out.println("ULTIMATE TIC TAC TOE!!");
        System.out.println("Choose the size of board");
        num=scan.nextInt();
        keyNum=num;
        board= new JUltimateBoard(keyNum);
    */

    keyNum=3;
    board= new JUltimateBoard(keyNum);
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
            public void run() {
                new UltimateTicTacToe(keyNum);
            }
        });
    }
    Thread whichBoard=new Thread()
    {
        @Override
        public void run()
        {
            
                while(!board.isFinished())
                {
                    int row=JPoint.nextRow();
                    int col=JPoint.nextCol();
                    if(row==-1||col==-1)
                        ((JUltimateBoard)board).turnOn(isX);
                    else if (((JNormalBoard)board.access(row,col)).isFinished())
                        ((JUltimateBoard)board).turnOn(isX);
                    else
                    {
                        ((JUltimateBoard)board).turnOff(isX);
                        ((JNormalBoard)board.access(row,col)).turnOn(isX);
                    }
                    yield();
                }   
        }
    };
    Thread findX=new Thread()
    {
        @Override
        public void run()
        {
            while(!board.isFinished())
            {
                isX=JPoint.getX();
                yield();
            }
            
        }
    };
    /*Thread update = new Thread()
    {
        @Override
        public void run() 
        {
            
            String temp="Ultimate Tic Tac Toe!!";
           while(!board.isFinished())
            {
              
                if(isX)
                    temp="X's turn to play!!";
                else 
                    temp="O's turn to play!!";
                comment.setText(temp);
                yield();
            } 
           if(board.winner()=='x'||board.winner()=='X')
               comment.setText("X has won!");
           else if (board.winner()=='o'||board.winner()=='O')
               comment.setText("O has won!");
           else
               comment.setText("CATSCRATCH!!! >:)");
            
        }
    };
    */

{
         whichBoard.start();
         findX.start();
}
         
    
         
    
    
}






    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {

        int num,superRow, superCol, row, col;
        int[] temp;
        System.out.println("ULTIMATE TIC TAC TOE!!");
        System.out.println("Choose the size of board");
        num=scan.nextInt();
        keyNum=num;
        board= new UltimateBoard(keyNum);
        new UltimateTicTacToe(keyNum);
        System.out.println(board);
      
        System.out.println("Player X: Choose the first superrow and first supercolumn to play");
        System.out.println("Enter the superrow");
        superRow=scan.nextInt()-1;
        System.out.println("Enter the supercolumn");
        superCol=scan.nextInt()-1;
        do
        {
            
            isX = !isX;
            temp=play(superRow, superCol);
            System.out.println(board);
            superRow=temp[0];
            superCol=temp[1];
        }
        while(!board.isFinished());
        if(board.winner()=='x')
            System.out.println("Player X has won.");
        else if(board.winner()=='o')
            System.out.println("Player O has won.");
        else
            System.out.println("Catscratch!");
                    
        
    }
    public static int[] play(int superRow, int superCol)
    {
        
        int row=0;
        int col=0;
        if(isX)
            System.out.println("Player X's turn:");
        else
            System.out.println("Player O's turn:");
                   
        
        while(board.access(superRow,superCol).isFinished())
        {
        System.out.println("This board is already finished. Enter in another superrow and supercolumn");
        System.out.println("Enter the superrow");
        superRow=scan.nextInt()-1;
        System.out.println("Enter the supercolumn");
        superCol=scan.nextInt()-1;
        }
        
        while((superRow>=keyNum)||(superCol>=keyNum)||(superRow<0)||(superCol<0))
        {
        System.out.println("These are invalid numbers. Enter in another superrow and supercolumn");
        System.out.println("Enter the superrow");
        superRow=scan.nextInt()-1;
        System.out.println("Enter the supercolumn");
        superCol=scan.nextInt()-1;
        }
        do
        {
            System.out.println("Please enter a row to play in.");
            row=scan.nextInt()-1;
            System.out.println("\nPlease enter a column to play in.");
            col=scan.nextInt()-1;
            if(row>=keyNum||col>=keyNum||row<0||col<0)
            {
            System.out.println("Invalid Numbers");
            }
            else if(board.access(superRow,superCol).access(row, col).isFinished())
            {
                System.out.println("This cell is already played.");
            }
            
        }
        while(((row>=keyNum||col>=keyNum||row<0||col<0)||(board.access(superRow,superCol).access(row, col).isFinished())));
        board.play(isX,superRow,superCol,row,col);
        int[] temp= { row, col};
        return temp;
                
    }
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToeGUI extends JFrame
{
   private char currentPlayer = 'X' ;
   private JButton[] buttons = new JButton[9];
   private char[] board = new char[9];

  public TicTacToeGUI()
  {
    setTitle("Tic-Tac-Toe");
    
    setSize(400,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLayout(new GridLayout(3,3));

 for(int i=0; i<9; i++)
{
  buttons[i]=new JButton();
  buttons[i].setFont(new Font("Arial",Font.PLAIN,60));
  buttons[i].setFocusPainted(false);
  buttons[i].addActionListener(new ButtonClickListener(i));
  add(buttons[i]);
   board[i]=' ';
}  
   }
private class ButtonClickListener implements ActionListener 
{
   int index;
   public ButtonClickListener(int index)
   {
      this.index=index;
    }
   public void actionPerformed(ActionEvent e)
   {
      if(board[index] == ' ' && !isGameOver())
      {
         buttons[index].setText(String.valueOf(currentPlayer));
	 board[index]=currentPlayer;
         if(checkWinner())
  	 {
		JOptionPane.showMessageDialog(null,"Player"  + currentPlayer  + "wins!" );
 	 }
        else if(isBoardFull())
          {
  	     JOptionPane.showMessageDialog(null,"The Game is a tie!" );
	   }
	  else
 	  {
             currentPlayer= (currentPlayer == 'X' )? 'O' : 'X';
 	  }
      }
   }
}
private boolean checkWinner()
{
   for(int i=0;i<3;i++)
   {
        if(board[i*3]== currentPlayer && board[i*3+1] == currentPlayer && board [i*3+2]== currentPlayer)
            return true;
       if(board[i]== currentPlayer && board[i+3] == currentPlayer && board [i+6]== currentPlayer)
            return true;
   }
        if(board[0]== currentPlayer && board[4] == currentPlayer && board [8]== currentPlayer)
            return true;
         if(board[2]== currentPlayer && board[4] == currentPlayer && board [6]== currentPlayer)
            return true;        
  
  return false;
}
private boolean isBoardFull()
{
   for(int i=0 ;i<9 ;i++)
   {
      if(board[i]==' ' )
      {
          return false;
      }
   }
  return true;
}
private boolean isGameOver()
{
   return checkWinner() || isBoardFull();
}
public static void main(String[] args)
{
  SwingUtilities.invokeLater(new Runnable()
{
    public void run()
    {
       new TicTacToeGUI().setVisible(true);
     }
}
);
}
}

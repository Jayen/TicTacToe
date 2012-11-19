import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 * This class implements the actionlistener
 * updates the GUI when a move is made
 * and also updates the backEnd
 * @author Jayen
 */
public class ButtonListener implements ActionListener
{
	private BackEndTicTacToe game;
	private GUI gui;
	private int row;
	private int col;
	
	public ButtonListener(GUI frame,BackEndTicTacToe game,int row,int col)
	{
		this.gui=frame;
		this.game=game;
		this.row=row;
		this.col=col;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//if player 1's turn
		if(game.turn().equals(game.getPlayer1Name()))
		{
			JButton button = (JButton)arg0.getSource();
			if(button.getText().equals("")||button.getText()==null)//check if the position is empty
			{
				button.setForeground(Color.blue);
				button.setText("X");
				game.move(row, col);
				game.incrementCount();
				gui.updateStatus();
				this.winCheck();
			}
		}
		//if player 2's turn
		else if(game.turn().equals(game.getPlayer2Name()))
		{
			JButton button = (JButton)arg0.getSource();
			if(button.getText().equals("")||button.getText()==null)//check if the position is empty
			{
				button.setForeground(Color.yellow);
				button.setText("O");
				game.move(row, col);
				game.incrementCount();
				gui.updateStatus();
				this.winCheck();
			}
		}
	}
	/**
	 * Method to check is someone has won
	 * @return -1 if no one has won, 0 for draw, 1 if player1 wins and 2 if player 2 wins
	 */
	private int winCheck()
	{
		String check=game.winCheck();//check if there is a winner using the back-end winCheck method
		//if check is not null then there is a result
		if(check!=null)
		{
			if(check.equals("Draw"))
			{
				JOptionPane.showMessageDialog(gui,"It is a Draw!");
				gui.resetButtons();
				gui.updateScore();
				return 0;
			}
			else if(check.equals(game.getPlayer1Name()))
			{
				JOptionPane.showMessageDialog(gui,game.getPlayer1Name()+" wins!");
				gui.resetButtons();
				gui.updateScore();
				return 1;
			}
			else if(check.equals(game.getPlayer2Name()))
			{
				JOptionPane.showMessageDialog(gui,game.getPlayer2Name()+" wins!");
				gui.resetButtons();
				gui.updateScore();
				return 2;
			}
		}
		return -1;
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * Class that  creates the GUI for the 
 * game.
 * @author Jayen
 */
public class GUI extends JFrame
{
	private BackEndTicTacToe game = new BackEndTicTacToe();
	//labels that will hold the players name and score
	JLabel player1;
	JLabel player2;
	//JButton name format _RowCol
	private JButton _00= new JButton();
	private JButton _01= new JButton();
	private JButton _02= new JButton();
	private JButton _10= new JButton();
	private JButton _11= new JButton();
	private JButton _12= new JButton();
	private JButton _20= new JButton();
	private JButton _21= new JButton();
	private JButton _22= new JButton();
	private JLabel statusLabel;
	
	/**
	 * GUI constructor
	 */
	public GUI()
	{
		super("Tic-Tac-Toe");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(350, 350);
		this.getPlayerNames();
		this.setupMenu();
		this.setupBoard();
	}
	/**
	 * Method to setup the menu of the 
	 * game screen.
	 */
	private void setupMenu() 
	{
		JMenuBar menu= new JMenuBar();
		JMenu gameOptions=new JMenu("Game Options");
		JMenuItem newGame=new JMenuItem("New Game");
		JMenuItem resetScore=new JMenuItem("Reset Score");
		JMenuItem exit=new JMenuItem("Exit");
		
		newGame.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						game.resetBoard();
						GUI.this.resetButtons();
						GUI.this.updateStatus();
					}
				});
		
		resetScore.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				game.setPlayer1Score(0);
				game.setPlayer2Score(0);
				GUI.this.updateScore();
			}
		});
		
		exit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GUI.this.dispose();
			}
		});
		
		gameOptions.add(newGame);
		gameOptions.add(resetScore);
		gameOptions.add(exit);
		menu.add(gameOptions);
		this.setJMenuBar(menu);
	}
	
	/**
	 * Method to setup the GUI for the 
	 * tic-tac-toe board
	 */
	private void setupBoard() 
	{
		JPanel scorePanel= new JPanel(new BorderLayout());
		player1= new JLabel(" "+game.getPlayer1Name()+"'s score: "+game.getPlayer1Score());
		player2= new JLabel(game.getPlayer2Name()+"'s score: "+game.getPlayer2Score()+" ");
		scorePanel.add(player1,BorderLayout.WEST);
		scorePanel.add(player2,BorderLayout.EAST);
		this.add(scorePanel,BorderLayout.NORTH);
		
		JPanel board = new JPanel(new GridLayout(3,3));
		_00.setBackground(Color.lightGray);
		_01.setBackground(Color.lightGray);
		_02.setBackground(Color.lightGray);
		_10.setBackground(Color.lightGray);
		_11.setBackground(Color.lightGray);
		_12.setBackground(Color.lightGray);
		_20.setBackground(Color.lightGray);
		_21.setBackground(Color.lightGray);
		_22.setBackground(Color.lightGray);
		
		_00.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		_01.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		_02.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		_10.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		_11.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		_12.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		_20.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		_21.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		_22.setFont(new Font(_00.getFont().getName(),_00.getFont().getStyle(),45));
		
		_00.setName("_00");
		_01.setName("_01");
		_02.setName("_02");
		_10.setName("_10");
		_11.setName("_11");
		_12.setName("_12");
		_20.setName("_20");
		_21.setName("_21");
		_22.setName("_22");
		
		_00.addActionListener(new ButtonListener(this,game,0,0));
		_01.addActionListener(new ButtonListener(this,game,0,1));
		_02.addActionListener(new ButtonListener(this,game,0,2));
		_10.addActionListener(new ButtonListener(this,game,1,0));
		_11.addActionListener(new ButtonListener(this,game,1,1));
		_12.addActionListener(new ButtonListener(this,game,1,2));
		_20.addActionListener(new ButtonListener(this,game,2,0));
		_21.addActionListener(new ButtonListener(this,game,2,1));
		_22.addActionListener(new ButtonListener(this,game,2,2));
	
		board.add(_00);
		board.add(_01);
		board.add(_02);
		board.add(_10);
		board.add(_11);
		board.add(_12);
		board.add(_20);
		board.add(_21);
		board.add(_22);
		
		this.add(board,BorderLayout.CENTER);
		
		statusLabel = new JLabel("It is currently "+game.turn()+"'s turn");
		this.add(statusLabel,BorderLayout.SOUTH);
	}
	
	/**
	 * Method to get the player names at the
	 * start of the game
	 */
	private void getPlayerNames() 
	{
		game.setPlayer1Name(JOptionPane.showInputDialog(this, "Please enter player 1's name"));
		if(game.getPlayer1Name().equals(""))
		{
			game.setPlayer1Name("Player 1");
		}

		game.setPlayer2Name(JOptionPane.showInputDialog(this, "Please enter player 2's name"));
		if(game.getPlayer2Name().equals(""))
		{
			game.setPlayer2Name("Player 2");
		}
	}
	
	/**
	 * Method to reset the buttons to empty
	 * used to clear the game board
	 */
	public void resetButtons()
	{
		_00.setText("");
		_01.setText("");
		_02.setText("");
		_10.setText("");
		_11.setText("");
		_12.setText("");
		_20.setText("");
		_21.setText("");
		_22.setText("");
	}
	
	/**
	 * method to update the part of the GUI 
	 * that shows the score
	 */
	public void updateScore()
	{
		player1.setText(" "+game.getPlayer1Name()+"'s score: "+game.getPlayer1Score());
		player2.setText(game.getPlayer2Name()+"'s score: "+game.getPlayer2Score()+" ");
	}
	
	/**
	 * method to update the status part of the GUI
	 */
	public void updateStatus()
	{
		statusLabel.setText("It is currently "+game.turn()+"'s turn");
	}
	
}

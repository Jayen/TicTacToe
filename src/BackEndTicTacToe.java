/**
 * This class is the back-end of the game
 * Score, scoreboard and player
 * details held here.
 * @author Jayen
 */
public class BackEndTicTacToe 
{
	private int player1Score=0;
	private int player2Score=0;
	private String player1Name = "player 1";
	private String player2Name = "player 2";
	/*
	 * If turnCount is even player 1's turn
	 * If turnCount is odd player 2's turn
	 */
	private int turnCount=0;
	//player 1 indicator is 1
	//player 2 indicator is -1
	//[row][col]
	int[][] scoreArray;
	/**
	 * BackEndTicTacToe constructor
	 */
	public BackEndTicTacToe()
	{
		scoreArray=new int[3][3];
	}
	
	/**
	 * Method to check the board for any
	 * 3 matches on the board
	 * @return String-WinnersName or Draw. 
	 */
	public String winCheck()
	{
		//if the sum is 3 then player 1 wins
		if(scoreArray[0][0]+scoreArray[0][1]+scoreArray[0][2]==3
				||scoreArray[1][0]+scoreArray[1][1]+scoreArray[1][2]==3
				||scoreArray[2][0]+scoreArray[2][1]+scoreArray[2][2]==3
				||scoreArray[0][0]+scoreArray[1][0]+scoreArray[2][0]==3
				||scoreArray[0][1]+scoreArray[1][1]+scoreArray[2][1]==3
				||scoreArray[0][2]+scoreArray[1][2]+scoreArray[2][2]==3
				||scoreArray[0][0]+scoreArray[1][1]+scoreArray[2][2]==3
				||scoreArray[0][2]+scoreArray[1][1]+scoreArray[2][0]==3)
		{
			player1Score++;
			//reset score board
			this.resetBoard();
			return player1Name;
		}
		//if the sum is -3 then player 2 wins
		else if(scoreArray[0][0]+scoreArray[0][1]+scoreArray[0][2]==-3
				||scoreArray[1][0]+scoreArray[1][1]+scoreArray[1][2]==-3
				||scoreArray[2][0]+scoreArray[2][1]+scoreArray[2][2]==-3
				||scoreArray[0][0]+scoreArray[1][0]+scoreArray[2][0]==-3
				||scoreArray[0][1]+scoreArray[1][1]+scoreArray[2][1]==-3
				||scoreArray[0][2]+scoreArray[1][2]+scoreArray[2][2]==-3
				||scoreArray[0][0]+scoreArray[1][1]+scoreArray[2][2]==-3
				||scoreArray[0][2]+scoreArray[1][1]+scoreArray[2][0]==-3)
		{
			player2Score++;
			//reset score board
			this.resetBoard();
			return player2Name;
		}
		
		//check if game board is full
		boolean full;
		check:
			{	for(int i=0;i<3;i++)
				{
					for(int j=0;j<3;j++)
					{
						if(scoreArray[i][j]==0)
						{
							full=false;
							break check;
						}
					}
				}
				full=true;//if loop fully runs it means game board is full
			}
		if(full==true)//if game board is full
		{
			//reset score board
			this.resetBoard();
			return "Draw";
		}
		else//if no winner return null
		{
			return null;
		}
	}
	
	/**
	 * Reset the scoreArray with 0
	 * and the turnCount to 0
	 * so that the board is ready for a new game
	 */
	public void resetBoard()
	{
		turnCount=0;//reset count
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				scoreArray[i][j]=0;//set the position with the value 0
			}
		}
	}
	
	/**
	 * Method to register a move 
	 * on the scoreArray game board
	 * @param row
	 * @param col
	 */
	public void move(int row,int col)
	{
		//if turnCount is even then its player 1's turn
		if(turnCount%2==0)
		{
			scoreArray[row][col]=1;
		}
		else
		{
			scoreArray[row][col]=-1;
		}
	}
	
	/**
	 * Method to check which player turn it is.
	 * @return String-players name
	 */
	public String turn()
	{
		if(turnCount%2==0)
		{
			return player1Name;
		}
		else
		{
			return player2Name;
		}
	}
	
	/**
	 * method to increment the turnCount.
	 * Helper method to increase count as count is used to 
	 * manage the turns between players.
	 */
	public void incrementCount()
	{
		turnCount++;
	}
	
	/**
	 * Method to set the players1's score
	 * @param score
	 */
	public void setPlayer1Score(int score)
	{
		this.player1Score=score;
	}
	
	/**
	 * Method to set the player2's score
	 * @param score
	 */
	public void setPlayer2Score(int score)
	{
		this.player2Score=score;
	}
	/**
	 * Method to set the player1's name
	 * @param name
	 */
	public void setPlayer1Name(String name)
	{
		player1Name=name;
	}
	/**
	 * Methos to se the player2's name
	 * @param name
	 */
	public void setPlayer2Name(String name)
	{
		player2Name=name;
	}
	/**
	 * Method to get the player1's name
	 * @return
	 */
	public String getPlayer1Name()
	{
		return player1Name;
	}
	/**
	 * Method to get the player2's name
	 * @return
	 */
	public String getPlayer2Name()
	{
		return player2Name;
	}
	/**
	 * Method to get the player1's score
	 * @return
	 */
	public int getPlayer1Score()
	{
		return player1Score;
	}
	/**
	 * Method to get the player2's score
	 * @return
	 */
	public int getPlayer2Score()
	{
		return player2Score;
	}
}

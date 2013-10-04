import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;


//class represents a JPanel with a master-mind-board drawn on it.
class MasterMindBoard extends JPanel
{
	final static int BOARD_HEIGHT = 500;
	final static int BOARD_WIDTH = 200;
	final static int FIRST_ROW_OFFSET = 25;
	final static int SIDE_OFFSET = 35;
	final static int RESULTS_OFFSET = 6;

	private boolean gameOver = false;
	private int numGuesses = 1;
	private int rowSpace;
	private ArrayList<String> prevGuesses = new ArrayList<String>();
	private int[] numCorrect;
	private int[] numClose;
	private String correctGuess = "????";

	final static Color boardColor = new Color(100,150,150);
	final static Color holeColor = new Color(10,10,10);
	final static Color guessedCode = new Color(200,50,25);

	public MasterMindBoard(int pNumGuesses, String pCorrectGuess)
	{
		numGuesses = pNumGuesses;
		correctGuess = pCorrectGuess;
		rowSpace = 425 / numGuesses;
		numCorrect = new int [numGuesses];
		numClose = new int [numGuesses];
		/*prevGuesses.add("ABCD");
		prevGuesses.add("DVBA");
		prevGuesses.add("ADDA");
		numCorrect[0] = 1;
		numCorrect[1] = 0;
		numCorrect[2] = 2;
		numClose[0] = 1;
		numClose[1] = 2;
		numClose[2] = 2;*/
		gameOver = false;
	}

	//physically paints the panel
	@Override
	public void paintComponent(Graphics g)
	{
		drawBoard(g,100,30);
	}

	//stores the information of a guess, so that the board can display the appropriate images
	public void registerGuess(String guess, int numRight, int pNumClose)
	{
		int index = prevGuesses.size();
		if(index < numGuesses)
		{
			prevGuesses.add(guess);
			numCorrect[index] = numRight;
			numClose[index] = pNumClose;
		}
	}

	//Tells the board that the game is over, so it can display the solution
	public void gameOver()
	{
		gameOver = true;
	}

	public void setSolution(String newSolution)
	{
		correctGuess = newSolution;
	}

	//draws the board at the given location of the JPanel
	private void drawBoard(Graphics g, int xOffset, int yOffset)
	{
		g.translate(xOffset,yOffset);
		g.setColor(boardColor);
		g.fillRect(0,0,BOARD_WIDTH,BOARD_HEIGHT);
		int x = 30;
		int y = 30;


		//draws the player guess area
		for(int row = 0; row < numGuesses; row++)
		{
			if(row < prevGuesses.size())
			{
				paintGuess(g,x,y+row*rowSpace,prevGuesses.get(row));
			}
			else
			{
				paintNonGuess(g,x,y+row*rowSpace);
			}
			paintResults(g, x + 4*SIDE_OFFSET, y + row*rowSpace - 3,numCorrect[row],numClose[row]);
		}


		//draws the solution area
		g.setColor(Color.GREEN);
		g.fillRect(x-10,500 - (int)(1.5 * y), 130,y);

		if(gameOver)
		{
			paintGuess(g,x,500-y,correctGuess);
		}
		else
		{
			paintGuess(g,x,500-y,"????");
		}

	}

	//paints one "empty" row of the gameboard
	private void paintNonGuess(Graphics g, int xOffset, int yOffset)
	{
		g.setColor(holeColor);
		for(int count = 0; count < 4; count++)
		{
			g.fillArc(xOffset + count*SIDE_OFFSET - 6,yOffset - 6,12,12,0,360);
		}
	}

	//paints a guess on the board
	private void paintGuess(Graphics g, int xOffset, int yOffset, String code)
	{
		g.setColor(guessedCode);
		g.setFont(new Font("arial",Font.BOLD,16));
		for(int count = 0; count < 4 && count < code.length(); count++)
		{
			g.drawString("" + code.charAt(count),xOffset + count*SIDE_OFFSET - 5,yOffset + 5);
		}
	}

	//paints the results of an unspecified gues on the board
	private void paintResults(Graphics g, int xOffset, int yOffset, int numCorrect, int numClose)
	{
		g.setColor(getColor(numCorrect,numClose,1));
		g.fillOval(xOffset - 3,yOffset - 3,6,6);
		g.setColor(getColor(numCorrect,numClose,2));
		g.fillOval(xOffset + RESULTS_OFFSET - 3,yOffset - 3,6,6);
		g.setColor(getColor(numCorrect,numClose,3));
		g.fillOval(xOffset - 3,yOffset + RESULTS_OFFSET - 3,6,6);
		g.setColor(getColor(numCorrect,numClose,4));
		g.fillOval(xOffset + RESULTS_OFFSET - 3,yOffset + RESULTS_OFFSET - 3,6,6);
	}

	//returns the color of a results peg, given that it is the numpeg'th peg t be placed, and that there were the given number of correct guesses and correct colors
	private Color getColor(int numRight, int numClose, int numPeg)
	{
		if(numPeg <= numRight)
			return Color.RED;
		if(numPeg <= numRight + numClose)
			return Color.WHITE;
		return Color.BLACK;
	}
}
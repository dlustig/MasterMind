import java.awt.*;
import java.util.*;
import javax.swing.*;//System.currentTimeMillis();
import java.awt.geom.*;
import java.awt.event.*;

public class MasterGUI extends JFrame
{

	JTextField guessBox = new JTextField(5);
	JButton submit = new JButton("Guess!");

	public MasterGUI()
	{
		super("MasterMind");
		BorderLayout org = new BorderLayout();
		BorderLayout org2 = new BorderLayout();
		JPanel menu = new JPanel();
		setLayout(org);
		menu.setLayout(org2);
		menu.add(guessBox,BorderLayout.NORTH);
		menu.add(submit,BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(400,600);
		add(menu,BorderLayout.NORTH);
		//add(guessBox);
		MasterMindBoard graphic = new MasterMindBoard();
		add(graphic);
		setVisible(true);
	}

	public static void main(String[] args)
	{
		MasterGUI obj = new MasterGUI();
		while(true)
		{
			obj.repaint();
		}
	}
}

class MasterMindBoard extends JPanel
{
	final static int FIRST_ROW_OFFSET = 25;
	final static int SIDE_OFFSET = 35;
	final static int RESULTS_OFFSET = 6;

	private boolean gameOver = false;
	private int numGuesses = 26;
	private int rowSpace = 425 / numGuesses;
	private ArrayList<String> prevGuesses = new ArrayList<String>();
	private int[] numCorrect = new int[numGuesses];
	private int[] numClose = new int [numGuesses];
	private String correctGuess = "ABCD";

	final static Color boardColor = new Color(100,150,150);
	final static Color holeColor = new Color(10,10,10);
	final static Color guessedCode = new Color(200,50,25);

	public MasterMindBoard()
	{
		prevGuesses.add("ABCD");
		prevGuesses.add("DVBA");
		prevGuesses.add("ADDA");
		numCorrect[0] = 1;
		numCorrect[1] = 0;
		numCorrect[2] = 2;
		numClose[0] = 1;
		numClose[1] = 2;
		numClose[2] = 2;
		gameOver = true;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		drawBoard(g,50,50);
	}

	private void drawBoard(Graphics g, int xOffset, int yOffset)
	{
		//g.offset(xOffset,yOffset);
		g.setColor(boardColor);
		g.fillRect(0,0,200,500);
		int x = 30;
		int y = 30;
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

	private void paintNonGuess(Graphics g, int xOffset, int yOffset)
	{
		g.setColor(holeColor);
		for(int count = 0; count < 4; count++)
		{
			g.fillArc(xOffset + count*SIDE_OFFSET - 6,yOffset - 6,12,12,0,360);
		}
	}

	private void paintGuess(Graphics g, int xOffset, int yOffset, String code)
	{
		g.setColor(guessedCode);
		g.setFont(new Font("arial",Font.BOLD,16));
		for(int count = 0; count < 4 && count < code.length(); count++)
		{
			g.drawString("" + code.charAt(count),xOffset + count*SIDE_OFFSET - 5,yOffset + 5);
		}
	}

	private void paintResults(Graphics g, int xOffset, int yOffset, int numCorrect, int numClose)
	{
		g.setColor(getColor(numCorrect,numClose,1));
		g.fillArc(xOffset - 3,yOffset - 3,6,6,0,360);
		g.setColor(getColor(numCorrect,numClose,2));
		g.fillArc(xOffset + RESULTS_OFFSET - 3,yOffset - 3,6,6,0,360);
		g.setColor(getColor(numCorrect,numClose,3));
		g.fillArc(xOffset - 3,yOffset + RESULTS_OFFSET - 3,6,6,0,360);
		g.setColor(getColor(numCorrect,numClose,4));
		g.fillArc(xOffset + RESULTS_OFFSET - 3,yOffset + RESULTS_OFFSET - 3,6,6,0,360);
	}

	private Color getColor(int numRight, int numClose, int numPeg)
	{
		if(numPeg <= numRight)
			return Color.RED;
		if(numPeg <= numRight + numClose)
			return Color.WHITE;
		return Color.BLACK;
	}
}
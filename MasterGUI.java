import java.awt.*;
import java.util.*;
import javax.swing.*;//System.currentTimeMillis();
import java.awt.geom.*;
import java.awt.event.*;

public class MasterGUI extends JFrame
{

	final static Font TEXT_FONT = new Font("arial",Font.BOLD,16);
	final static Font MESSAGE_FONT = new Font("arial",Font.BOLD,12);

	JTextField guessBox = new JTextField(5);
	JButton submit = new JButton("Guess!");
	MasterMindBoard graphic;

	public MasterGUI(int numGuesses)
	{
		super("MasterMind");

		//layouts for the window and the menu-panel
		BorderLayout org = new BorderLayout();
		FlowLayout org2 = new FlowLayout();


		//sets up the top menu
		JPanel menu = new JPanel();
		menu.setLayout(org2);
		guessBox.setSize(new Dimension(200,50));
		guessBox.setFont(TEXT_FONT);
		submit.setSize(new Dimension(200,50));
		submit.setFont(TEXT_FONT);
		menu.add(guessBox,BorderLayout.NORTH);
		menu.add(submit,BorderLayout.SOUTH);

		graphic = new MasterMindBoard(numGuesses);

		//sets the values for the window
		setLayout(org);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setSize(400,600);
		add(menu,BorderLayout.NORTH);
		//add(guessBox);
		add(graphic);
		setVisible(true);
	}

	public void submitFeedback(String guess, int numRight, int numClose)
	{
		graphic.registerGuess(guess,numRight,numClose);
		guessBox.setText("");
	}

	public static void main(String[] args)
	{
		MasterGUI obj = new MasterGUI(8);
		while(true)
		{
			for(int x = 0; x<10000;x++)
			{
				System.out.println(".");
			}
			obj.submitFeedback("ADCA",1,2);
			obj.repaint();
		}
	}
}

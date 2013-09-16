import java.util.*;
public class Board{
	public static void main(String args[]){
		CodeR CorrectCodeR = new CodeR();
		getRounds();
		CorrectCodeR.setAlf();
		CorrectCodeR.setCodeR(1);
//		CorrectCodeR.printCodeR();
		boolean won = false;
		int onRound=0;
		CodeR GuessCodeR = new CodeR();
		System.out.println("Start guessing!");
		while(won==false && onRound<numRounds)
		{
			GuessCodeR.setCodeR(2);
			won=CorrectCodeR.compareCodeR(GuessCodeR);
			onRound++;
		}
		if(won==true)
		{
			System.out.println("CodeRbreaker wins!");
		} else {
			System.out.println("CodeRmaker wins!");
		}
	}
	private static int numRounds;
	private static void getRounds() {
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("How many rounds do you want to play?");
			numRounds = in.nextInt();
		}while(numRounds<1);
	}
}
/*
scrap all that
game begins
Board calls "getAlfSize" on code
Board calls "getRounds" and stores the int in "numRounds"
Board creates a code object and names it "CorrectCodeR"
Board calls "inputCodeRSecret" on "CorrectCodeR", giving it a value
	function "inputCodeRSecret" has input validation (assume validation function)
Board sets boolean "won" to false
Board sets "onRound" to zero
while(won==false && onRound < numRounds)
	accept input and put it in "GuessCodeR"
	call "compareCodeR" on "CorrectCodeR" with "GuessCodeR" as argument
		"compareCodeR" prints string of form "x correct y in puzzle"
		"compareCodeR" returns a boolean which is true if "GuessCodeR" is the same as "CorrectCodeR"
	make "won" equal to output of "compareCodeR"
	increment "onRound"
if(won==true)
	print "CodeRbreaker wins!"
else
	print "CodeRmaker wins!"
*/

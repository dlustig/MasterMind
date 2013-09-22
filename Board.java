import java.util.*;
public class Board{
	public static void main(String args[]){
		Code CorrectCode = new Code();
		getRounds();
		CorrectCode.setAlf();
		CorrectCode.setCode(1);
//		CorrectCode.printCode();
		boolean won = false;
		int onRound=0;
		Code GuessCode = new Code();
		System.out.println("Start guessing!");
		while(won==false && onRound<numRounds)
		{
			GuessCode.setCode(2);
			won=CorrectCode.compareCode(GuessCode);
			onRound++;
		}
		if(won==true)
		{
			System.out.println("Codebreaker wins!");
		} else {
			System.out.println("Codemaker wins!");
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
Board creates a code object and names it "CorrectCode"
Board calls "inputCodeSecret" on "CorrectCode", giving it a value
	function "inputCodeSecret" has input validation (assume validation function)
Board sets boolean "won" to false
Board sets "onRound" to zero
while(won==false && onRound < numRounds)
	accept input and put it in "GuessCode"
	call "compareCode" on "CorrectCode" with "GuessCode" as argument
		"compareCode" prints string of form "x correct y in puzzle"
		"compareCode" returns a boolean which is true if "GuessCode" is the same as "CorrectCode"
	make "won" equal to output of "compareCode"
	increment "onRound"
if(won==true)
	print "Codebreaker wins!"
else
	print "Codemaker wins!"
*/

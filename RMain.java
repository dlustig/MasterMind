public class Main{
	public static void main(String args[]){

	}
}

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

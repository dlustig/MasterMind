import java.util.*;
import java.io.Console;
public class Code{
	/*
	* Determine whether a string is valid
	* @param c a string to check with the alphabet
	* @return a boolean which indicates the validity of the string
	*/
	private boolean isCodeValid(String c) {
		if(c.length()!=4) {
			return false;
		}
		c = c.toUpperCase();
		for(int i=0; i<4; i++) {
			if(c.charAt(i)>alfSize+64 || c.charAt(i)<65) {
				return false;
			}
		}
		return true;
	}

	/*
	*
	*
	*/

	/*
	* Set the code string attribute of a Code object
	* @param a a string to set the code string to
	* @return a boolean which indicates whether the input string was valid
	*/
	public boolean setCode(String a) {
		if(isCodeValid(a)) {
			this.code=a;
			return true;
		} else {
			return false;
		}
	}

	/*
	* Tell how many characters the cracker guessed which are in the puzzle, but in the wrong spot
	* @param guess a Code object to compare to the correct code
	* @return int which is the number of characters in the puzzle, but not in the right places
	*/
	public int ins(Code guess) {
		boolean[] incorrect = {true,true,true,true};
		boolean[] untaken = {true,true,true,true};
		int corr = 0;
		int in = 0;
		for(int i=0; i<4; i++) {
			if(guess.code.charAt(i)==code.charAt(i)) {
				incorrect[i]=false;
				untaken[i]=false;
			}
		}
		for(int i=0; i<4; i++) {
			if(incorrect[i]==true) {
				for(int k=0; k<4; k++) {
					if(guess.code.charAt(i)==code.charAt(k) && untaken[k]==true) {
						in++;
						untaken[k]=false;
						k=5;
					}
				}
			}
		}
		return in;
	}

	/*
	* Tell how many correct characters the cracker guessed
	* @param guess a Code object to compare to the correct code
	* @return int which is the number of characters in the right places
	*/
	public int corrects(Code guess) {
		boolean[] incorrect = {true,true,true,true};
		boolean[] untaken = {true,true,true,true};
		int corr = 0;
		int in = 0;
		for(int i=0; i<4; i++) {
			if(guess.code.charAt(i)==code.charAt(i)) {
				incorrect[i]=false;
				untaken[i]=false;
				corr++;
			}
		}
		return corr;	
	}

	/*
	* Tell whether the player won
	* @param guess a Code object to compare to the correct code
	* @return boolean which indicates whether the correct code was guessed
	*/
	public boolean won(Code guess) {
		return code.equals(guess.code);
	}
	
	/*
	* Set the alphabet size for all Code objects
	* @param a the integer size of alphabet the user wants
	* @return a boolean that says whether it was an acceptable alphabet size
	*/
	public boolean setAlf(int a) {
		if(a<1 || a>26) {
			return false;
		} else {
			alfSize=a;
			return true;
		}
	}

	/*
	* Public constructor for a Code
	*/
	public Code() {
		code="";
	}
	//Data
	private static int alfSize;
	private String code;
}

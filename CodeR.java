import java.util.*;
import java.io.Console;
public class CodeR{
	public boolean isCodeRValid(String c)
	{
		if(c.length()!=4)
		{
			return false;
		}
		for(int i=0; i<4; i++)
		{
			if(c.charAt(i)>alfSize+64 || c.charAt(i)<65)
			{
				return false;
			}
		}
		return true;
	}
	private static String readCodeR( ) {
	    Console console = System.console( );
	    System.out.println("Enter code:");
	    return new String(console.readPassword( ));
	}
	private String acceptCodeR() {
		Scanner in = new Scanner(System.in);
		String blah = in.next();
		return blah;
	}
	private String makeCodeR() {
		char [] arrr = new char [4];
		for(int i=0; i<4; i++) {
			int bleh=(int)(Math.random()*1000);
			arrr[i]=(char)((bleh%alfSize)+65);
		}
		String blah = new String(arrr);
		return blah;
	}
	public void setCodeR(int a)
	{
		String thing;
		do{
			if(a==1){
				thing = readCodeR();
			}
			else if (a==2){
				thing = acceptCodeR();
			}
			else{
				thing = makeCodeR();
			}
		}while(!isCodeRValid(thing));
		code=thing;
	}
	public void printCodeR()
	{
		System.out.println(code);
	}

	public boolean compareCodeR(CodeR guess)
	{
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
		System.out.printf("%d correct, %d in.\n",corr,in);
		return code.equals(guess.code);
	}

	public void setAlf()
	{
		Scanner in = new Scanner(System.in);
		int size;
		System.out.println("How large is your alphabet?");
		do{
			size=in.nextInt();
		}while(size<1 || size>26);
		alfSize=size;
	}
	public CodeR()
	{
		code="";
	}
	//Data
	private static int alfSize;
	private String code;
}

import java.util.*;
import java.io.Console;
public class MakeCode{
	public boolean isCodeValid(String c)
	{
		if(c.length()!=4)
		{
			return false;
		}
		for(int i=0; i<4; i++)
		{
			if(c.charAt(i)>alfSize+91 || c.charAt(i)<65)
			{
				return false;
			}
		}
		return true;
	}
	private static String readCode( ) {
	    Console console = System.console( );
	    System.out.println("Enter code:");
	    return new String(console.readPassword( ));
	}
	public void setCode()
	{
		String thing;
		do{
			thing = readCode();
		}while(!isCodeValid(thing));
		code=thing;
	}
	public void printCode()
	{
		System.out.println(code);
	}
	public boolean compCode(String guess)
	{
		return code.equals(guess);
	}
	public void setAlf()
	{
		Scanner in = new Scanner(System.in);
		int size;
		System.out.println("How large is your alphabet?\n");
		do{
			size=in.nextInt();
		}while(size<1 || size>26);
		alfSize=size;
	}
	public MakeCode()
	{
		alfSize=0;
		code="";
	}
	//Data
	private int alfSize;
	private String code;
}

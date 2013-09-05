import java.util.*;
public class MakeCode{
	public bool isCodeValid(String c)
	{
		if(c.length()!=3)
		{
			return false;
		}
		for(int i=0; i<4; i++)
		{
			if(c[i]>alfSize || c[i]<0)
			{
				return false;
			}
		}
		return true;
	}
	public void setCode();
	{
		Console console = System.console();
		do{
			System.out.println("Enter code: ");
			String thing = new String(console.readPassword());
		}while(isCodeValid(thing));
	}
	public bool compCode(String guess)
	{
		return code.equals(guess);
	}
	public void setAlf()
	{
		Scanner in = new Scanner();
		int size;
		System.out.println("How large is your alphabet?\n");
		do{
			size=in.next();
		}while(size<1 || size>26);
		alfSize=size;
	}
	//Data
	private int alfSize;
	private String code;
}

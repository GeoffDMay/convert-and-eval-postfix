/*
 * Geoff May
 * Homework 3
 * CS253
 */
public class Eval 
{
	boolean binaryOp = false;
	
	public boolean isOperator(String n)
    {
        switch(n)
        {
        case "(":
            return true;
        case ")":
            return true;
        case "*":
            ;
        case "/":
            ;
        case "+":
            binaryOp = true;
            return true;
        case "-":
        	if (binaryOp)
        	{
        		break;
        	}
        case "#":
            return true;
        }
        
        binaryOp = false;
        return false;
     }
	
	public int Priority(String op)
	{
		switch(op)
		{
			case "(":
				return 3;
			case "*":
				return 2;
			case "/":
				return 2;
			case "+":
				return 1;
			case "-":
				return 1;
		}
		return 0;
	}
}

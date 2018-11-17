/*
 * Geoff May
 * Homework 3
 * CS253
 */
public class Driver
{
	public static void main(String[] args)
	{
		LLStack opStack = new LLStack();
		LLStack valueStack = new LLStack();
		LLQueue infix = new LLQueue();
		LLQueue postfix = new LLQueue();
		Eval eval = new Eval();
		Double result = null;

		String expression = "6*72-(3/2+4-3)";
		System.out.println(expression);
		
		for(int i = 0;i < expression.length();i++) // add all items from the expression to the infix queue
		{
			String value = String.valueOf(expression.charAt(i));
			
			if(eval.isOperator(value) == true)
			{
				infix.add(value);
			}
			else
			{
				for(int j = i+1; eval.isOperator(String.valueOf(expression.charAt(j))) == false; j++)//add token to value until an operator is found and that number ends
				{
					value += expression.charAt(j);
					i++;
				}

					infix.add(value);
			}
		}
		
		infix.add("#");
		
		while(infix.empty() == false)
		{
			String current = infix.dequeue();
			
			if(eval.isOperator(current) == false)//value is an operand
			{
				postfix.add(current);
			}
			else if(current.equals("#"))//value is #
			{
				while(opStack.empty() == false) //add all remaining operators to the postfix queue
				{
					postfix.add(opStack.pop());
				}			
			}
			else 
			{
				if(current.equals(")"))
				{
					String token = opStack.pop();
					
					while(!token.equals("("))
					{
						postfix.add(token);
						token = opStack.pop();
					}				
				}
				else
				{
					while(opStack.empty() == false &&  !opStack.top().equals("(") && eval.Priority(opStack.top()) >= eval.Priority(current))
					{
						postfix.add(opStack.pop());
					}
					
					opStack.push(current);
				}

			}
			
		}
		
		while(postfix.empty() == false) //evaluate postfix expression
		{
			String token = postfix.dequeue();

			if(eval.isOperator(token) == false)
			{
				valueStack.push(token);
			}
			else
			{
				double operand1 = Double.parseDouble(valueStack.pop());
				double operand2 = Double.parseDouble(valueStack.pop());
				
				switch(token)
				{
					case "*":
						result = operand2 * operand1;
						break;
					case "/":
						result = operand2 / operand1;
						break;
					case "+":
						result = operand2 + operand1;
						break;
					case "-":
						result = operand2 - operand1;
						break;
				}
				
				valueStack.push(Double.toString(result));
				eval.binaryOp = false;
			}
			

					
		}
		System.out.print("Evaluated: " + valueStack.pop());
	}
}

/*
 * Geoff May
 * Homework 3
 * CS253
 */
public class LLStack implements Stack
{
	private Node top;
	private int size;
	
	public LLStack()
	{
		size = 0;
		top = null;
	}
	
	public void push(String item)
	{
		Node newNode = new Node(item);
		newNode.setNext(top);
		top = newNode;
		
		size++;
	}
	
	public String pop()
	{
		Node oldTop = top;
		
		if(top.getNext() == null)
		{
			top = null;		
		}
		else
		{
			top = top.getNext();
		}
		
		size--;		
		return oldTop.getData();
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean empty()
	{
		return size == 0;
	}
	
	public String top()
	{
		return top.getData();
	}
}

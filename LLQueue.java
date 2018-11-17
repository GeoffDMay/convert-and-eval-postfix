/*
 * Geoff May
 * Homework 3
 * CS253
 */
public class LLQueue implements Queue
{
	private int size = 0;
	private Node front;
	private Node rear;
	
	public LLQueue()
	{
		size = 0;
		front = null;
		rear = null;
	}
	
	public String dequeue()
	{
		String data = front.getData();
		size--;
		
		if(this.empty())
		{		
			rear = null;
			front = null;
		}
		else
		{
			front = front.getNext();
		}
		return data;
	
	}
	
	public void add(String data)
	{
		Node newNode = new Node(data);
		
		if(this.empty())
		{
			front = newNode;
			rear = newNode;
		}
		else
		{
			rear.setNext(newNode);
			rear = newNode;
		}
		size++;
	}
	public int size()
	{
		return size;
	}
	
	public String front()
	{
		return front.getData();
		
	}
	
	public boolean empty()
	{
		return size == 0;
	}

}

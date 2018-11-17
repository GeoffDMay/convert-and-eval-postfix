/*
 * Geoff May
 * Homework 3
 * CS253
 */		
public class Node
{
	private String data;
	private Node next;
	
	public Node(String data)
	{
		this.data = data;
		next = null;
	}
	
	public void setData(String data)
	{
		this.data = data;
	}
	
	public void setNext(Node node)
	{
		next = node;
	}
	
	public String getData()
	{
		return data;
	}
	
	public Node getNext()
	{
		return next;
	}
}

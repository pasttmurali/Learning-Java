class Node
{
	String data;
	Node next;
	public Node(String data)
	{
		this.data = data;
		this.next = null;
	}
}
class LinkedListADT
{
	Node top;
	public LinkedListADT()
	{
		this.top = null;
	}
	public boolean isEmpty()
	{
		return top == null;
	}
	public void push(String data)
	{
		Node newNode = new Node(data);
		if(isFull())
		{
			top = newNode;
		}
		else
		{
			newNode.next =top;
			top = newNode;
		}
		
	}
	public String peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return null;
		}
		else 
		{
			return top.data;
		}
	}
	
	public String pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
	        return null;
		}
		else
		{
			String data = top.data;
			top = top.next;
			return data;
		}
	}
	
}

public class StackADTArray2
{
	public static void main(String [] args)
	{
		LinkedListADT linkedliststack = new LinkedListADT();
		linkedliststack.push(1);
		linkedliststack.push(2);
		linkedliststack.push(3);
		linkedliststack.display();
		
		linkedliststack.peek();
		linkedliststack.display();
		linkedliststack.pop();
		linkedliststack.display();
		// not finished
	}
}
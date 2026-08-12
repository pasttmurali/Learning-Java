class StackADT
{
	int maxSize;
	int [] stackArray;
	int top;
	
	public StackADT(int maxSize)
	{
		this.maxSize = maxSize;
		this.stackArray = new int [maxSize];
		this.top = -1; //Initialize the top of the stack to -1 (empty)
		
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	public boolean isFull()
	{
		return top == maxSize-1;
	}
	
	public void push(int data)
	{
		if(isFull())
		{
			System.out.println("Stack overflow.cannot push " + data);
		}
		else
		{
			stackArray[++top] = data;
		}
		
	}
	
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.print("Stack: ");
			for(int i = top; i > 0; i--)
			{
				System.out.print(stackArray[i] + " ");
			}
			System.out.println();
		}
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty.");
			return -1;
		}
		else
		{
			return stackArray[top];
		}
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty.Cannot pop");
			return -1;
		}
		else
		{
			return stackArray[top--];
		}
	}
	
}

public class StackADTArray
{
	public static void main(String [] args)
	{
		StackADT stack = new StackADT(3);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.display();
		
		stack.peek();
		stack.display();
		stack.pop();
		stack.display();
	}
}
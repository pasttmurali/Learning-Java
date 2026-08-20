class GenericStackArrayBasedADT<T>{
	private Object[] stack;
	private int top;
	private int max;
	
	GenericStackArrayBasedADT(int size){
		max=size;
		stack =new Object[max];
		top=-1;
	}
	
	boolean isEmpty(){
		return top == -1;
	}
	
	boolean isFull(){
		return top == max-1;
	}
	
	public void push(T item){
		if(isFull()){
			System.out.println("Stack overflow");
			return;
		}else{
			stack[++top]=item;
			System.out.println("Push into System");
		}
	}
	
	public Object pop(){
		if(isEmpty()){
			System.out.println("Stack underflow");
			return null;
		}
		Object item=stack[top];
		top--;
		return item;
	}
	
	public Object peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return null;
		}
		
		return stack[top];
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return;
		}
		
		int temp=top;
		
		while(temp != -1){
			System.out.println(stack[temp]);
			temp--;
		}
	}
	
	public int size(){
		return top + 1;
	}
	
	public void clear(){
		top = -1;
	}
	
	public boolean contains(T item){
		for(int i = 0; i <= top; i++){
			if(stack[i].equals(item)){
				return true;
			}
		}
		return false;
	}
	
	public Object bottom(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}

		return stack[0];
	}
	
	public void reverseDisplay(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return;
		}

		for(int i = 0; i <= top; i++){
			System.out.println(stack[i]);
		}
	}
	
}

public class GenericStackArrayBased{
	public static void main(String args[]){
		GenericStackArrayBasedADT<Integer> stack=new GenericStackArrayBasedADT<Integer>(5);
		stack.push(10);
		stack.pop();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println("After pop:"+stack.pop());
		System.out.println("After pop Stack:");
		stack.display();
		System.out.println("After peek:"+stack.peek());
		System.out.println("IsFull:"+stack.isFull());
		System.out.println("IsEmpty:"+stack.isEmpty());
		
	}
}
		
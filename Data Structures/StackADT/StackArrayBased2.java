class StackArrayBased2ADT{
	private int top;
	private int[] stack;
	private int max;
	
	public StackArrayBased2ADT(int max){
		this.max=max;
		stack=new int[max];
		top=0;
	}
	
	public boolean isFull(){
		return top == max-1;
	}
	
	public boolean isEmpty(){
		return stack[top]==0;
	}
	
	public void push(int item){
		if(isFull()){
			System.out.println("Stack overflow");
		}
		if(isEmpty()){
			stack[top]=item;
		}else{
			stack[++top]=item;
		}
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack underflow");
		}
		
		if(top==0){
			int item=stack[top];
			top=0;
			stack[top]=0;
			return item;
		}
		int item=stack[top];
		top--;
		return item;
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
		}
		return stack[top];
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Stack is empty");
		}
		
		int position=top;
		
		while(position != -1){
			System.out.println(stack[position--]);
		}
	}
}

public class StackArrayBased2{
	public static void main(String args[]){
		StackArrayBased2ADT stackArray = new StackArrayBased2ADT(5);
		stackArray.push(10);
		stackArray.pop();
		stackArray.display();
		stackArray.push(10);
		stackArray.push(30);
		stackArray.push(40);
		stackArray.push(50);
		stackArray.display();
		System.out.println("After pop:"+stackArray.pop());
		System.out.println("After pop Stack:");
		stackArray.display();
		System.out.println("After peek:"+stackArray.peek());
		System.out.println("IsFull:"+stackArray.isFull());
		System.out.println("IsEmpty:"+stackArray.isEmpty());
	}
}
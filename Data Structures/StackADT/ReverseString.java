
class StackArrayBasedADT{

	private int[] stack;
	private int top;
	private int max;
	
	StackArrayBasedADT(int size){
		max=size;
		stack =new int[max];
		top=-1;
	}
	
	boolean isEmpty(){
		return top == -1;
	}
	
	boolean isFull(){
		return top == max-1;
	}
	
	public void push(int item){
		if(isFull()){
			System.out.println("Stack overflow");
			return;
		}else{
			stack[++top]=item;
			System.out.println("Push into System");
		}
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}
		int item=stack[top];
		top--;
		return item;
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
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
}


public class ReverseString{
	public static void reverseString(String input){
		int length=input.length();
		StackArrayBasedADT stack =new StackArrayBasedADT(length);
		
		for(int i=0;i<length;i++){
			char ch=input.charAt(i);
			System.out.println(ch);
			stack.push(ch);
		}
		
		System.out.println("Ascii value of top Element In Stack : "+stack.peek());
		
		while(!stack.isEmpty()){
			System.out.print((char)stack.pop());
		}
		
	}
	
	public static void main(String args[]){
		String item="Murali";
		reverseString(item);
	}
}
		
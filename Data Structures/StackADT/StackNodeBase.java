class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data=data;
		this.next=null;
	}
}

class StackNodeBaseADT{
	Node top;
	
	public StackNodeBaseADT(){
		this.top=null;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void push(int data){
		Node newNode=new Node(data);
		newNode.next=top;
		top=newNode;
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return -1;
		}
		
		int itetm= top.data;
		top=top.next;
		return itetm;
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return -1;
		}
		return top.data;
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return ;
		}
		
		Node current=top;
		
		while(current != null){
			System.out.println(current.data);
			current=current.next;
		}
	}
}

public class StackNodeBase{
	public static void main(String[] args){
		StackNodeBaseADT stack =new StackNodeBaseADT();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		stack.display();
		System.out.println("Pop"+stack.pop());
		System.out.println("After pop stack:");
		stack.display();
		
		System.out.println("Peek :"+stack.peek());
		System.out.println("IsEmpty :"+stack.isEmpty());
		
		
	}
}
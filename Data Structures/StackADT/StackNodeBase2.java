class Node{
	String data;
	Node next;
	
	public Node(String data){
		this.data=data;
		this.next=null;
	}
}

class StackNodeBase2ADT{
	Node top;
	
	public StackNodeBase2ADT(){
		this.top=null;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public void push(String data){
		Node newNode=new Node(data);
		newNode.next=top;
		top=newNode;
	}
	
	public String pop(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return null;
		}
		
		String itetm= top.data;
		top=top.next;
		return itetm;
	}
	
	public String peek(){
		if(isEmpty()){
			System.out.println("Stack is Empty");
			return null ;
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

public class StackNodeBase2{
	public static void main(String[] args){
		StackNodeBase2ADT stack =new StackNodeBase2ADT();
		stack.push("AA");
		stack.push("BB");
		stack.push("CC");
		stack.push("DD");
		stack.push("EE");
		
		stack.display();
		System.out.println("Pop"+stack.pop());
		System.out.println("After pop stack:");
		stack.display();
		
		System.out.println("Peek :"+stack.peek());
		System.out.println("IsEmpty :"+stack.isEmpty());
		
		
	}
}
class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data=data;
		this.next=null;
	}
}

class LinkedListQueueADT2{
	Node rear;
	Node front;

	
	LinkedListQueueADT2(){
		front=null;
		rear=null;
	}
	
	public void enqueue(int value){
		Node newNode=new Node(value);
		
		if(isEmpty()){
			front=newNode;
			rear=newNode;
		}else{
			rear.next=newNode;
			rear=newNode;
		}
	}
	
	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		
		int value=front.data;
		front=front.next;
		
		if(front==null){
			rear=null;
		}
		
		return value;
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		
		return front.data;
	}
	
	public boolean isEmpty(){
		return front == null;
	}
	
	public int getSize(){
		int count;
		if(isEmpty()){
			return 0;
		}else{
			Node current=front;
			count=1;
			while(current!=rear){
				count++;
				current=current.next;
			}
		}
		return count;
	}
	
	public void display(){
		Node current=front;
		
		while(current != null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		
		System.out.println("");
	}
	
	public boolean contains(int value){
		Node current=front;
		
		while(current!=null){
			if(current.data == value){
				return true;
			}
			
			current=current.next;
		}
		return false;
	}
	
	// cut the previous node's connection.
	public void clear(){
		Node current=front;
		while(current!=null){
			Node temp=current;
			current=current.next;
			temp.next=null;
		}
		
		front = null;
		rear = null;
	}
	
	/*
	public void clear() {
		front = null;
		rear = null;
		size = 0;
	}
		
	*/
	
	public void reversePrint(){

		Node previous = null;
		Node current = front;
		Node next = null;

		// Reverse the queue
		while(current != null){
			next = current.next;
			current.next = previous;

			previous = current;
			current = next;
		}

		// Print reversed
		current = previous;

		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();

		// Restore original queue
		current = previous;
		previous = null;

		while(current != null){
			next = current.next;
			current.next = previous;

			previous = current;
			current = next;
		}
	}
	
}
	
	
	


public class LinkedListQueue2 {

    public static void main(String[] args) {

        LinkedListQueueADT2 q = new LinkedListQueueADT2();
		
		System.out.println("count of Queve: "+q.getSize());
		System.out.println(" ");

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
		System.out.println("count of Queve: "+q.getSize());
		System.out.println(" ");
		q.display();
		
		System.out.println("count of Queve: "+q.getSize());
		System.out.println(" ");
		
        System.out.println("Front:"+q.peek());

        System.out.println("call dequeue for removed: "+q.dequeue());

		
		System.out.println(q.contains(20));
		System.out.println(q.contains(50)); 

		System.out.print("Reverse Print: ");
		q.reversePrint();

		
		q.clear();
		System.out.println("Empty check: "+q.isEmpty());
		

		
    }
}
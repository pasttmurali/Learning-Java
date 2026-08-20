class Node<T>{
	T data;
	Node<T> next;
	
	Node(T data){
		this.data=data;
		this.next=null;
	}
}

class GenericLinkedListQueueADT<T>{
	Node<T> rear;
	Node<T> front;

	
	GenericLinkedListQueueADT(){
		front=null;
		rear=null;
	}
	
	public void enqueue(T value){
		Node<T> newNode=new Node<T>(value);
		
		if(isEmpty()){
			front=newNode;
			rear=newNode;
		}else{
			rear.next=newNode;
			rear=newNode;
		}
	}
	
	public Object dequeue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return null;
		}
		
		Object value=front.data;
		front=front.next;
		
		if(front==null){
			rear=null;
		}
		
		return value;
	}
	
	public Object peek(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return null;
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
			Node<T> current=front;
			count=0;
			while(current!=rear){
				count++;
				current=current.next;
			}
		}
		return count;
	}
	
	public void display(){
		Node<T> current=front;
		
		while(current != null){
			System.out.print(current.data+" ");
			current=current.next;
		}
		
		System.out.println("");
	}
	
	public boolean contains(T value){
		Node<T> current=front;
		
		while(current!=null){
			if(current.data.equals(value)){
				return true;
			}
			
			current=current.next;
		}
		return false;
	}
	
	// cut the previous node's connection.
	public void clear(){
		Node<T> current=front;
		while(current!=null){
			Node<T> temp=current;
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

		Node<T> previous = null;
		Node<T> current = front;
		Node<T> next = null;

	
		while(current != null){
			next = current.next;
			current.next = previous;

			previous = current;
			current = next;
		}

	
		current = previous;

		while(current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();


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
	
	
	


public class GenericLinkedListQueue {

    public static void main(String[] args) {

        GenericLinkedListQueueADT<Object> q = new GenericLinkedListQueueADT<Object>();
		
		System.out.println("count of Queve: "+q.getSize());
		System.out.println(" ");

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
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
		
		System.out.println("\n\n\nCheck for String\n-----------------\n");
		
		GenericLinkedListQueueADT<Object> q2= new GenericLinkedListQueueADT<Object>();
		
		System.out.println("count of Queve: "+q2.getSize());
		System.out.println(" ");

        q2.enqueue("AA");
        q2.enqueue("BB");
        q2.enqueue("cc");
		q2.display();
		
		System.out.println("count of Queve: "+q2.getSize());
		System.out.println(" ");
		
        System.out.println("Front:"+q2.peek());

        System.out.println("call dequeue for removed: "+q2.dequeue());

		
		System.out.println(q2.contains("cc"));
		System.out.println(q2.contains("DD")); 

		System.out.print("Reverse Print: ");
		q2.reversePrint();

		
		q2.clear();
		System.out.println("Empty check: "+q2.isEmpty());
    }
}
class GenericArrayQueueADT<T>{
	Object[] queue;
	int rear;
	int front;
	int capacity;
	
	public GenericArrayQueueADT(int capacity){
		this.capacity=capacity;
		queue=new Object[capacity];	
		front=0;
		rear=-1;
	}
	
	public void enqueue(T value){
		if(isFull()){
			System.out.println("Queue Overflow");
			return;
		}
		
		rear++;
		queue[rear]=value;
		
	}
	
	public Object dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return -1;
		}
		
		Object value=queue[front];
		front++;
		
		return value;
	}
	
	public Object peek(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		}
		return queue[front];
	}
	
	public boolean isEmpty(){
		return rear+1==front;
	}
	
	public boolean isFull(){
		return rear+1== capacity;
	}
	
	public int size(){
		return rear+1;
	}
	
	public void display(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return;
		}
		
		for(int i=front;i<=rear;i++){
			System.out.print(queue[i] + " ");
			System.out.println();
		}
	}
	
	public boolean contains(T value) {

		for (int i = front; i <= rear; i++) {
			if (queue[i] == value) {
				return true;
			}
		}

		return false;
	}
	
	public void clear() {
		for (int i = 0; i < queue.length; i++) {
			queue[i] = 0;
		}

		front = 0;
		rear = -1;
	}
}

public class GenericArrayQueue {

    public static void main(String[] args) {

        GenericArrayQueueADT<Integer> q = new GenericArrayQueueADT<Integer>(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

		q.display();
		
        System.out.println("call peek: "+q.peek());

        System.out.println("call dequeue: "+q.dequeue());
        System.out.println("call dequeue: "+q.dequeue());

        System.out.println("call peek: "+q.peek());
        System.out.println("get size: "+q.size());
		
		System.out.println(q.contains(20));
		System.out.println(q.contains(50)); 
		
		q.clear();
		System.out.println("Empty check: "+q.isEmpty());
		
		System.out.printf("\n\n\nUsing Object for common type\n---------------------\n\n\n");		
		GenericArrayQueueADT<Object> q1 = new GenericArrayQueueADT<Object>(5);

        q1.enqueue("AA");
        q1.enqueue("BB");
        q1.enqueue("CC");

		q1.display();
		
        System.out.println("call peek: "+q1.peek());

        System.out.println("call dequeue: "+q1.dequeue());
        System.out.println("call dequeue: "+q1.dequeue());

        System.out.println("call peek: "+q1.peek());
        System.out.println("get size: "+q1.size());
		
		System.out.println(q1.contains("BB"));
		System.out.println(q1.contains("DD")); 
		
		q1.clear();
		System.out.println("Empty check: "+q1.isEmpty());
		
    }
}
class ArrayQueueADT{
	private int[] queue;
	private int rear;
	private int front;
	private int size;
	private int capacity;
	
	public ArrayQueueADT(int capacity){
		this.capacity=capacity;
		queue=new int[capacity];	
		front=0;
		rear=-1;
		size=0;
	}
	
	public void enqueue(int value){
		if(isFull()){
			System.out.println("Quevue is full");
			return;
		}
		
		rear++;
		queue[rear]=value;
		size++;
	}
	
	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		
		int value=queue[front];
		front++;
		size--;
		
		return value;
	}
	
	public int peek(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		}
		return queue[front];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public boolean isFull(){
		return size== capacity;
	}
	
	public int size(){
		return size;
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
	
	public boolean contains(int value) {

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
		size = 0;
	}
}

public class ArrayQueue {

    public static void main(String[] args) {

        ArrayQueueADT q = new ArrayQueueADT(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

		q.display();
		
        System.out.println("call peek"+q.peek());

        System.out.println("call dequeue: "+q.dequeue());
        System.out.println("call dequeue: "+q.dequeue());

        System.out.println("call peek: "+q.peek());
        System.out.println("get size: "+q.size());
		
		System.out.println(q.contains(20));
		System.out.println(q.contains(50)); 
		
		q.clear();
		System.out.println("Empty check: "+q.isEmpty());
		
    }
}
class ArrayQueueADT2{
	int[] queue;
	int rear;
	int front;
	int capacity;
	
	public ArrayQueueADT2(int capacity){
		this.capacity=capacity;
		queue=new int[capacity];	
		front=0;
		rear=-1;
	}
	
	public void enqueue(int value){
		if(isFull()){
			System.out.println("Queue Overflow");
			return;
		}
		
		rear++;
		queue[rear]=value;
		
	}
	
	public int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return -1;
		}
		
		int value=queue[front];
		front++;
		
		return value;
	}
	
	public int peek(){
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
	}
}

public class ArrayQueue2 {

    public static void main(String[] args) {

        ArrayQueueADT2 q = new ArrayQueueADT2(5);

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
		
    }
}
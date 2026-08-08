public class SinglyLinkedList{
	//instance variables
	private Node head;
	private Node tail;
	private int size;
	// private:- Only code inside the SinglyLinkedList class can directly access these variables.
	
	
	//A linked list is made from objects called nodes.Node is inside SinglyLinkedList, it is called a nested class.
	
	private static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
		}
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public int size(){
		return size;
	}
	
	private Node getNode(int index){
		checkElementIndex(index);
		Node current=head;
		for(int i=0;i< index;i++){
			current=current.next;
		}
		return current;
	}
	
	public int get(int index) {
		checkElementIndex(index);
		return getNode(index).data;
	}

	//01.
	/*
		public void travesal(){
		ensureNotEmpty();
		Node current=head;
		while(current.next != null){
			System.out.printf(current.data+" ");
			current=current.next;
		}
		System.out.printf(current.data+" ");
	}
	*/
	public void traversal() {
		Node current = head;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

	
	private void checkPositionForInsert(int index){
		if( index< 0 || index >size){
			throw new IndexOutOfBoundsException("Index: " +index+ ",size: "+ size);
		}
	}
	
	//02.
	public void insertFirst(int data){
		Node newNode=new Node(data);
		newNode.next=head;
		head=newNode;
		
		if(tail == null){
			tail=newNode;
		}
		size++;
	}
	
	//03.
	public void insertLast(int data){
		Node newNode=new Node(data);
		if(isEmpty()){
			head=tail=newNode;
		}else{
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}
	
	//04.
	public void insertAt(int index,int data){
		checkPositionForInsert(index);
		if(index == 0){
			insertFirst(data);
			return;
		}
		if(index == size){
			insertLast(data);
			return;
		}
		
		Node previous=getNode(index - 1);
		Node newNode = new Node(data);
		
		newNode.next=previous.next;
		previous.next=newNode;
		size++;	
	}
	
	private void ensureNotEmpty(){
		if(isEmpty()){
			throw new IllegalStateException("The Linked List is empty");
		}
	}
	
	//05.
	public int deleteFirst(){
		ensureNotEmpty();
		int deleteValue=head.data;
		head=head.next;
		size --;
		
		if(head==null){
			tail=null;
		}
		return deleteValue;
	}
	
	//06.
	public int deleteLast(){
		ensureNotEmpty();
		if(size == 1){
			return deleteFirst();
		}
		
		Node previous=getNode(size -2);
		int deleteValue=tail.data;
		tail=previous;
		tail.next=null;
		
		size --;
		return deleteValue;
	}
	
	private void checkElementIndex(int index){
		if(index<0 || index>=size){
			throw new IndexOutOfBoundsException("Index: "+ index +",size: "+ size);
		}
	}
	
	//07.
	public int deleteAt(int index){
		checkElementIndex(index);
		if(index == 0){
			deleteFirst();
		}
		
		if(index == size-1){
			deleteLast();
		}
		
		Node previous=getNode(index-1);
		Node deleteNode=previous.next;
		
		previous.next=previous.next.next;
		size--;
		return deleteNode.data;
	}
	
	//08.
	public boolean deleteValue(int value){
		if(isEmpty()){
			return false;
		}
		
		if(head.data == value){
			deleteFirst();
			return true;
		}
		
		Node current =head;
		while(current.next != null && current.next.data != value){
			current = current.next;
		}
		
		if(current.next == null){
			return false;
		}
		
		if(current.next == tail){
			tail = current;
		}
		
		current.next=current.next.next;
		size--;
		return true;
	}
	
	//09.
	public int deleteAll(int value){
		int deletedCount=0;
		
		while(head != null && head.data == value){
			deleteFirst();
			deletedCount++;
		}
		if(head == null){
			return deletedCount;
		}
		
		Node current=head;
		while(current.next!=null){
			if(current.next.data == value){
				if(current.next == tail){
					tail=current;
				}
				current.next=current.next.next;
				size--;
				deletedCount++;
			}else{
				current=current.next;
			}
		}
		return deletedCount;
	}
	
	public int getFirst(){
		ensureNotEmpty();
		return head.data;
	}
	
	public int getLast(){
		ensureNotEmpty();
		return tail.data;
	}
	
	public void set(int index,int newValue){
		checkElementIndex(index);
		getNode(index).data=newValue;
	}
	
	//10.
	public int indexOf(int value){
		Node current=head;
		int index=0;
		while(current!=null){
			if(current.data == value){
				return index;
			}
			current=current.next;
			index++;
		}
		return -1;
	}
	
	public boolean contains(int value){
		return indexOf(value) != -1;
	}
	
	//11.
	public int count(int value){
		int count=0;
		Node current=head;
		while(current!=null){
			if(current.data == value){
				count ++;	
			}
			current=current.next;
		}
		return count;
	}
	
	//12.
	public void reverse(){
		Node previous=null;
		Node current=head;
		tail=head;
			
		while(current!=null){
				Node nextNode=current.next;
				current.next=previous;
				previous=current;
				current=nextNode;
			}
			head=previous;
		}
		
		//13.
		public int findMiddle(){
			ensureNotEmpty();
			Node slow=head;
			Node fast=head;
			
			while(fast !=null && fast.next !=null){
				slow=slow.next;
				fast=fast.next.next;
			}
			return slow.data;
		}
		
		//14.
		public int getNthFromEnd(int n){
			if(n<=0 || n>size){
				throw new IndexOutOfBoundsException("n must be between 1 and " + size);
			}
			Node first=head;
			Node second=head;
			
			for(int i=0;i<n;i++){
				first=first.next;
			}
			while(first!=null){
				first=first.next;
				second=second.next;
			}
			return second.data;
		}
		
		//15.
		
		public void removeDuplicates(){
			Node current=head;
			
			while(current!=null){
				Node runner=current;
				while(runner.next!=null){
					if(runner.next.data==current.data){
						if(runner.next == tail){
							tail=runner;
						}
						runner.next=runner.next.next;
						size--;
					}else{
						runner=runner.next;
					}
				}
				current=current.next;
			}
		}
		
		
		//16.
		
		public void sort(){
			for(Node first=head;first!=null;first=first.next){
				for(Node second=first.next;second!=null;second=second.next){
					if(first.data>second.data){
						int temporary=first.data;
						first.data=second.data;
						second.data=temporary;
					}
				}
			}
		}
		
		//17.
		
		public void clear(){
			head=null;
			tail=null;
			size=0;
		}
		
		public void display(){
			System.out.println(this);
		}
		
		//17.
		
		public String toString(){
			StringBuilder result=new StringBuilder("[");
			Node current=head;
			
			while(current!=null){
				result.append(current.data);
				if(current.next != null){
					result.append(" -> ");
				}
				current=current.next;
			}
			return result.append("]").toString();
		}
		
		
		
		public static void main(String[] args) {
			SinglyLinkedList list = new SinglyLinkedList();

			list.insertLast(20);
			list.insertLast(30);
			list.insertFirst(10);
			list.insertAt(2, 25);

			System.out.print("List: ");
			list.traversal();
			System.out.println(" ");
			System.out.println("Size: " + list.size());
			System.out.println("First: " + list.getFirst());
			System.out.println("Last: " + list.getLast());
			System.out.println("Middle: " + list.findMiddle());
			System.out.println("Contains 25: " + list.contains(25));

			list.set(2, 24);
			System.out.print("After update: ");
			list.traversal();
			System.out.println(" ");
			
			list.deleteFirst();
			list.deleteLast();
			list.deleteValue(24);
			System.out.print("After deletion: ");
			list.traversal();
			System.out.println(" ");

			list.insertLast(40);
			list.insertLast(50);
			list.insertLast(60);
			list.reverse();
		

			System.out.print("Reversed: ");
			list.traversal();
			System.out.println(" ");
			
			 System.out.println("Second from end: " + list.getNthFromEnd(2));

			list.sort();
			System.out.print("Sorted: ");
			list.traversal();
			System.out.println("");
			
			System.out.println("");
			System.out.println(list);//automatically calls: list.toString());
			System.out.println("");
			
			list.clear();
			System.out.println("After clear: ");
			//list.traversal();
			System.out.println("");
		}
	}
	
			
	/* SinglyLinkedList
│
├── Fields
│   ├── head
│   ├── tail
│   └── size
│
├── Nested class
│   └── Node
│
├── Helper methods
│   ├── getNode()
│   ├── checkPositionForInsert()
│   ├── checkElementIndex()
│   └── ensureNotEmpty()
│
├── Public operations
│   ├── insertFirst()
│   ├── insertLast()
│   ├── insertAt()
│   ├── deleteFirst()
│   ├── reverse()
│   ├── sort()
│   └── ...
│
└── main() */
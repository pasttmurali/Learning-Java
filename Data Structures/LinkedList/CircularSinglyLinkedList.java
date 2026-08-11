class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data=data;
		this.next=null;
	}
}

class CircularLinkedListADT{
	Node head;
	
	public CircularLinkedListADT(){
		this.head=null;
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public void insertAtFront(int data){
		Node newNode =new Node(data);
		if(isEmpty()){
			newNode.next=newNode; // Circular reference to itself
			head=newNode;
		}else{
			Node current=head;
			while(current.next!=head){
				current=current.next;
			}
			current.next=newNode;
			newNode.next=head;
			head=newNode;
		}
	}
	
	public void insertAtEnd(int data){
		Node newNode=new Node(data);
		if(isEmpty()){
			newNode.next=newNode;  // Circular reference to itself
			head=newNode;
		}else{
			Node current=head;
			while(current.next != head){
				current=current.next;
			}
			current.next=newNode;
			newNode.next=head;
		}
	}
	
	public int getSize() {
		if (isEmpty()) {
			return 0;
		}

		int count = 0;
		Node current = head;

		do {
			count++;
			current = current.next;
		} while (current != head);

		return count;
	}
	
	public void insertAt(int index, int data) {
		int size = getSize();

		if (index < 0 || index > size) {
			System.out.println("Index out of bounds");
			return;
		}

		if (index == 0) {
			insertAtFront(data);
			return;
		}

		if (index == size) {
			insertAtEnd(data);
			return;
		}

		Node current = head;

		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}

		Node newNode = new Node(data);

		newNode.next = current.next;
		current.next = newNode;
	}
	
	public void deleteAtFront(){
		if(isEmpty()){
			System.out.println("Circular linked list is empty");
			return;
		}
		if(head.next == head){// Only one element in the list
			head=null;
		}else{
			Node current=head;
			while(current.next != head){
				current=current.next;
			}
			current.next=head.next;
			head=head.next; //head = current.next;
		}
	}

	public void deleteAtEnd() {
		if (isEmpty()) {
			System.out.println("Circular linked list is empty");
			return;
		}

		if (head.next == head) {
			head = null;
			return;
		}

		Node current = head;

		while (current.next.next != head) {
			current = current.next;
		}

		current.next = head;
	}
	
	public void deleteAt(int index) {
		if (isEmpty()) {
			System.out.println("Circular linked list is empty");
			return;
		}

		if (index < 0 || index >= getSize()) {
			System.out.println("Index out of bounds");
			return;
		}
		
		if (index == 0) {
			deleteAtFront();
			return;
		}
		
		if(index==getSize()-1){
			deleteAtEnd();
			return;
		}

		Node current = head;

		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}
		
		current.next = current.next.next;
	}

	public void display(){
		 if (isEmpty()) {
            System.out.println("Circular linked list is empty");
            return;
        }
		Node current=head;
		do{
			System.out.print(current.data+" ");
			current=current.next;
		}while(current != head);
		System.out.println();
	}
	
	public int get(int index) {
		int size = getSize();

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		Node current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current.data;
	}
	
	public void update(int index, int data) {
		int size = getSize();

		if (index < 0 || index >= size) {
			System.out.println("Index out of bounds");
			return;
		}

		Node current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		current.data = data;
	}
	
	public boolean search(int key) {
		if (isEmpty()) {
			return false;
		}

		Node current = head;

		do {
			if (current.data == key) {
				return true;
			}
			current = current.next;
		} while (current != head);

		return false;
	}
		
	public void reverse() {
		if (isEmpty() || head.next == head) {
			return;
		}

		Node previous = null;
		Node current = head;
		Node next;

		do {
			next = current.next;
			current.next = previous;

			previous = current;
			current = next;

		} while (current != head);

		// Old head becomes the last node
		head.next = previous;

		// Previous is the new head
		head = previous;
	}
	public void clear() {
		head = null;
	}
}

public class CircularSinglyLinkedList {
    public static void main(String[] args) {
        CircularLinkedListADT circularLinkedList = new CircularLinkedListADT();

        circularLinkedList.insertAtFront(3);
        circularLinkedList.insertAtFront(2);
        circularLinkedList.insertAtFront(1);

        circularLinkedList.display(); // Output: 1 2 3

        circularLinkedList.insertAtEnd(4);
        circularLinkedList.insertAtEnd(5); // // Output: 1 2 3 4 5
		
		circularLinkedList.insertAt(3,4);

        circularLinkedList.display(); // Output: 1 2 3 4 4 5

        circularLinkedList.deleteAtFront();
        circularLinkedList.display(); // Output: 2 3 4 4 5

        circularLinkedList.deleteAtEnd();
		circularLinkedList.display(); // Output: 2 3 4 4        
		
		circularLinkedList.deleteAt(1);
		
		circularLinkedList.display(); // Output: 2 4 4
		
		System.out.println("Search 4: " + circularLinkedList.search(4));
		// true

		System.out.println("Search 10: " + circularLinkedList.search(10));
		// false

		circularLinkedList.update(1, 100);

		circularLinkedList.display();
		// 2 100 4
		
		System.out.println("Before reverse:");
		circularLinkedList.display();

		circularLinkedList.reverse();

		System.out.println("After reverse:");
		circularLinkedList.display();
    }
}
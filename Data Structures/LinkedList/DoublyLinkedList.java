class Node{
	int data;
	Node previous;
	Node next;
	
	public Node(int data){
		this.data=data;
		this.previous=null;
		this.next=null;
	}
}

class DoublyLinkedListADT{
	Node head;
	
	public DoublyLinkedListADT(){
		this.head=null;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void insertAtFront(int data){
		Node newNode =new Node(data);
		if(isEmpty()){
			head=newNode;
		}else{
			newNode.next=head;
			head.previous=newNode;
			head=newNode;
		}
	}
	
	public void traversal(){
		if(isEmpty()){
			System.out.println("Linked list is Empty");
		}else{
			Node current=head;
			while(current!=null){
				System.out.print(current.data+" ");
				current=current.next;
			}
			System.out.println(" ");
		}
		System.out.println("");
	}
	
	public void insertAtEnd(int data){
		Node newNode =new Node(data);
		if(isEmpty()){
			head=newNode;
		}else{
			Node current=head;
			while(current.next!=null){
				current=current.next;
			}
			current.next=newNode;
			newNode.previous=current;
			newNode.next=null;
		}
	}
	
	public int getSize(){
		int count=0;
		Node current=head;
		while(current!=null){
			count++;
			current=current.next;
		}
		return count;
	}
	
	public Node getNode(int index){
		if(index<0 || index>=getSize()){
			System.out.println("Invalid index");
			return null;
		}
		
		Node current=head;
		
		for(int i=0;i<index;i++){
			current=current.next;
		}
		
		return current;
	}
	
	public void insertAtIndex(int data,int index){
		if(index<0 || index>getSize()){
			System.out.println("Invalid index");
			return;
		}
		
		if(index == 0){
			insertAtFront(data);
		}else{
			Node newNode =new Node(data);
			Node prev=getNode(index-1);
			
			newNode.next=prev.next;
			newNode.previous=prev;
			if(prev.next!=null){
				prev.next.previous=newNode;
			}
			prev.next=newNode;
		}
	}
	
	public void deleteAtFront(){
		if(isEmpty()){
			System.out.println("Linked List is empty");
		}else{
			head=head.next;
			head.previous=null;
		}
	}
	
	public void deleteAtEnd(){
		if(isEmpty()){
			System.out.println("Lonked List is Empty");
			return;
		}
		if(head.next == null){
			head=null;
			return;
		}
		Node current=head;
		while(current.next.next!=null){
				current=current.next;
		}
		current.next.previous=null;
		current.next=null;	
	}
	
	public void deleteAtIndex(int index){
		if(index<0 || index>=getSize()){
			System.out.println("Invalid index");
			return;
		}
		
		if(index == 0){
			deleteAtFront();
			return;
		}else{
			Node prev=getNode(index-1);
			
			prev.next=prev.next.next;
			
			if(prev.next !=null){
				prev.next.previous=prev;
			}
		}
	}
	
	public int searchElement(int key){
		Node current=head;
		int index=0;
		while(current!=null){
			if(current.data==key){
				//System.out.println("Element found at index: "+index);
				return index;
			}
			current=current.next;
			index++;
		}
		//System.out.println("Element not found.");
		
		return -1;
	}
}

public class DoublyLinkedList{
	public static void main(String args[]){
		DoublyLinkedListADT doublyLinkedList=new DoublyLinkedListADT();
		doublyLinkedList.insertAtFront(50);
		doublyLinkedList.insertAtFront(40);
		doublyLinkedList.insertAtFront(30);
		doublyLinkedList.insertAtFront(20);
		doublyLinkedList.traversal();
		
		
		doublyLinkedList.insertAtEnd(70);
		System.out.print("Insert After End: ");
		doublyLinkedList.traversal();
		//System.out.println("");
		
		doublyLinkedList.insertAtIndex(60,4);
		System.out.printf("Insert At Index\t: ");
		doublyLinkedList.traversal();
		//System.out.println("");
		
		doublyLinkedList.deleteAtFront();
		System.out.printf("Delete At Front\t: ");
		doublyLinkedList.traversal();
		//System.out.println("");
		
		doublyLinkedList.deleteAtEnd();
		System.out.printf("Delete At End\t: ");
		doublyLinkedList.traversal();
		//System.out.println("");
		
		doublyLinkedList.deleteAtIndex(2);
		System.out.printf("Delete At Index\t: ");
		doublyLinkedList.traversal();
		//System.out.println("");
		
		System.out.printf("Search element found at index:"+doublyLinkedList.searchElement(40));
		
		
	}
}
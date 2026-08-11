class Node<T>{
	T data;
	Node<T> next;
	
	public Node(T data){
		this.data=data;
		this.next=null;
	}
}

class LinkedListADT<T> {
    Node<T> head;

    public LinkedListADT() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

public void insertAtFront(T data) {
    Node<T> newNode = new Node<>(data);

    if(isEmpty()){
        head = newNode;
    } else {
        Node<T> current = head;

        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;
    }
}
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtIndex(T data, int index) {
        if (index < 1 || index > getSize()+1) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 1) {
            insertAtFront(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        int count = 1;

        while (count < index - 1) {
            current = current.next;
            count++;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtFront() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
        } else {
            head = head.next;
        }
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node<T> current = head;
            Node<T> previous = null;
            while (current.next != null) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 1 || index > getSize()) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 1) {
            deleteAtFront();
            return;
        }

        Node<T> current = head;
        int count = 1;

        while (count < index - 1) {
            current = current.next;
            count++;
        }

        current.next = current.next.next;
    }

    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty");
        } else {
            Node<T> current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class LinkedListDeletionGeneric<T> {
	public void deleteKey(LinkedListADT<T> linkedList, T key) {
			if (linkedList.isEmpty()) {
				System.out.println("Linked list is empty");
				return;
			}

			if (linkedList.head.data == key) {
				linkedList.deleteAtFront();
				return;
			}

			Node<T> current = linkedList.head;
			Node<T> previous = null;

			while (current != null) {
				if (current.data == key) {
					previous.next = current.next;
					return;
				}
				previous = current;
				current = current.next;
			}

			System.out.println("Key not found in the linked list");
		}
		
    public static void main(String[] args) {
		LinkedListDeletionGeneric<Object> del= new LinkedListDeletionGeneric<>();
		LinkedListADT<Object> linkedList =new LinkedListADT<>();
		
		linkedList.insertAtEnd("Yes");
        linkedList.insertAtEnd('O');
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4.5);
        linkedList.insertAtEnd('n');
		
		System.out.println("Original linked list:");
        linkedList.display(); // Output: Yes O 3 4.5 n

        char key = 'O';
        del.deleteKey(linkedList, key);

        System.out.println("Linked list after deleting key " + key + ":");
        linkedList.display(); // Output: Yes 3 4.5 n
    }


}

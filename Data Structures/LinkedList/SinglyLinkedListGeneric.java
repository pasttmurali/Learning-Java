class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListADT<T> {

    private Node<T> head;

    public LinkedListADT() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
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

    public void insertAtFront(T data) {
        Node<T> newNode = new Node<>(data);

        newNode.next = head;
        head = newNode;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void insertAtIndex(T data, int index) {

        if (index < 1 || index > getSize() + 1) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 1) {
            insertAtFront(data);
            return;
        }

        Node<T> current = head;

        for (int i = 1; i < index - 1; i++) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(data);

        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtFront() {

        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        head = head.next;
    }

    public void deleteAtEnd() {

        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node<T> current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
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

        for (int i = 1; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
    }

    public void deleteKey(T key) {

        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        if (head.data.equals(key)) {
            deleteAtFront();
            return;
        }

        Node<T> current = head;

        while (current.next != null) {

            if (current.next.data.equals(key)) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

        System.out.println("Key not found");
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

    public T get(int index) {

        if (index < 1 || index > getSize()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> current = head;

        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void update(int index, T data) {

        if (index < 1 || index > getSize()) {
            System.out.println("Invalid index");
            return;
        }

        Node<T> current = head;

        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        current.data = data;
    }

    public void reverse() {

        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next;

        while (current != null) {

            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        head = previous;
    }

    public void clear() {
        head = null;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Linked list is empty");
            return;
        }

        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}

public class SinglyLinkedListGeneric {

    public static void main(String[] args) {

        LinkedListADT<Integer> linkedList =
                new LinkedListADT<>();

        linkedList.insertAtEnd(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);

        System.out.println("Original list:");
        linkedList.display();

        linkedList.deleteKey(2);

        System.out.println("After deleting 2:");
        linkedList.display();

        System.out.println("Search 4: " +
                linkedList.search(4));

        linkedList.update(2, 100);

        System.out.println("After update:");
        linkedList.display();

        linkedList.reverse();

        System.out.println("After reverse:");
        linkedList.display();
    }
}
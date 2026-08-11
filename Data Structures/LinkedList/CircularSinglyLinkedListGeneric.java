class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedListADT<T> {

    Node<T> head;

    public CircularLinkedListADT() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtFront(T data) {

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {

            newNode.next = newNode;
            head = newNode;

        } else {

            Node<T> current = head;

            while (current.next != head) {
                current = current.next;
            }

            current.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAtEnd(T data) {

        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {

            newNode.next = newNode;
            head = newNode;

        } else {

            Node<T> current = head;

            while (current.next != head) {
                current = current.next;
            }

            current.next = newNode;
            newNode.next = head;
        }
    }

    public int getSize() {

        if (isEmpty()) {
            return 0;
        }

        int count = 0;

        Node<T> current = head;

        do {
            count++;
            current = current.next;

        } while (current != head);

        return count;
    }

    public void insertAt(int index, T data) {

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

        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(data);

        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtFront() {

        if (isEmpty()) {
            System.out.println("Circular linked list is empty");
            return;
        }

        if (head.next == head) {

            head = null;

        } else {

            Node<T> current = head;

            while (current.next != head) {
                current = current.next;
            }

            current.next = head.next;
            head = head.next;
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

        Node<T> current = head;

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

        int size = getSize();

        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }

        if (index == 0) {
            deleteAtFront();
            return;
        }

        if (index == size - 1) {
            deleteAtEnd();
            return;
        }

        Node<T> current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
    }

    public T get(int index) {

        int size = getSize();

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void update(int index, T data) {

        int size = getSize();

        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return;
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = data;
    }

    public boolean search(T key) {

        if (isEmpty()) {
            return false;
        }

        Node<T> current = head;

        do {

            if (current.data.equals(key)) {
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

        Node<T> previous = null;
        Node<T> current = head;
        Node<T> next;

        do {

            next = current.next;

            current.next = previous;

            previous = current;
            current = next;

        } while (current != head);

        head.next = previous;

        head = previous;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Circular linked list is empty");
            return;
        }

        Node<T> current = head;

        do {

            System.out.print(current.data + " ");

            current = current.next;

        } while (current != head);

        System.out.println();
    }

    public void clear() {
        head = null;
    }
}

public class CircularSinglyLinkedListGeneric{

    public static void main(String[] args) {

        CircularLinkedListADT<Integer> circularLinkedList =
                new CircularLinkedListADT<>();

        circularLinkedList.insertAtFront(3);
        circularLinkedList.insertAtFront(2);
        circularLinkedList.insertAtFront(1);

        circularLinkedList.display();
        // 1 2 3

        circularLinkedList.insertAtEnd(4);
        circularLinkedList.insertAtEnd(5);

        circularLinkedList.display();
        // 1 2 3 4 5

        circularLinkedList.insertAt(3, 10);

        circularLinkedList.display();
        // 1 2 3 10 4 5

        circularLinkedList.deleteAtFront();

        circularLinkedList.display();
        // 2 3 10 4 5

        circularLinkedList.deleteAtEnd();

        circularLinkedList.display();
        // 2 3 10 4

        System.out.println(circularLinkedList.search(10));
        // true

        circularLinkedList.update(1, 100);

        circularLinkedList.display();
        // 2 100 10 4

        circularLinkedList.reverse();

        circularLinkedList.display();
        // 4 10 100 2
    }
}
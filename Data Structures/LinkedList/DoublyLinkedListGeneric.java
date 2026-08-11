class Node<T> {
    T data;
    Node<T> next;
    Node<T> previous;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

class DoublyLinkedListADT<T> {

    private Node<T> head;

    public DoublyLinkedListADT() {
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

        if (isEmpty()) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.previous = newNode;
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
        newNode.previous = current;
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

        if (index == getSize() + 1) {
            insertAtEnd(data);
            return;
        }

        Node<T> current = head;

        for (int i = 1; i < index - 1; i++) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(data);

        newNode.next = current.next;
        newNode.previous = current;

        current.next.previous = newNode;
        current.next = newNode;
    }

    public void deleteAtFront() {

        if (isEmpty()) {
            System.out.println("Doubly linked list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        head = head.next;
        head.previous = null;
    }

    public void deleteAtEnd() {

        if (isEmpty()) {
            System.out.println("Doubly linked list is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.previous.next = null;
    }

    public void deleteAtIndex(int index) {

        int size = getSize();

        if (index < 1 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 1) {
            deleteAtFront();
            return;
        }

        if (index == size) {
            deleteAtEnd();
            return;
        }

        Node<T> current = head;

        for (int i = 1; i < index; i++) {
            current = current.next;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    public void deleteKey(T key) {

        if (isEmpty()) {
            System.out.println("Doubly linked list is empty");
            return;
        }

        Node<T> current = head;

        while (current != null) {

            if (current.data.equals(key)) {

                if (current == head) {
                    deleteAtFront();
                    return;
                }

                if (current.next == null) {
                    deleteAtEnd();
                    return;
                }

                current.previous.next = current.next;
                current.next.previous = current.previous;

                return;
            }

            current = current.next;
        }

        System.out.println("Key not found");
    }

    public boolean search(T key) {

        Node<T> current = head;

        while (current != null) {

            if (current.data.equals(key)) {
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

        Node<T> current = head;
        Node<T> temp = null;

        while (current != null) {

            temp = current.previous;

            current.previous = current.next;
            current.next = temp;

            current = current.previous;
        }

        if (temp != null) {
            head = temp.previous;
        }
    }

    public void clear() {
        head = null;
    }

    public void displayForward() {

        if (isEmpty()) {
            System.out.println("Doubly linked list is empty");
            return;
        }

        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void displayBackward() {

        if (isEmpty()) {
            System.out.println("Doubly linked list is empty");
            return;
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }

        System.out.println();
    }
}

public class DoublyLinkedListGeneric {

    public static void main(String[] args) {

        DoublyLinkedListADT<Integer> list =
                new DoublyLinkedListADT<>();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);

        System.out.println("Original list:");
        list.displayForward();
        // 1 2 3 4 5

        System.out.println("Backward:");
        list.displayBackward();
        // 5 4 3 2 1

        list.insertAtFront(0);

        System.out.println("After insert front:");
        list.displayForward();
        // 0 1 2 3 4 5

        list.insertAtIndex(100, 4);

        System.out.println("After insert at index 4:");
        list.displayForward();
        // 0 1 2 100 3 4 5

        list.deleteAtFront();

        System.out.println("After delete front:");
        list.displayForward();

        list.deleteAtEnd();

        System.out.println("After delete end:");
        list.displayForward();

        list.deleteAtIndex(2);

        System.out.println("After delete index 2:");
        list.displayForward();

        list.deleteKey(100);

        System.out.println("After deleting 100:");
        list.displayForward();

        System.out.println("Search 4: " + list.search(4));

        list.update(2, 50);

        System.out.println("After update:");
        list.displayForward();

        list.reverse();

        System.out.println("After reverse:");
        list.displayForward();
    }
}
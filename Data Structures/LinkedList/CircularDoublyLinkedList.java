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

class CircularDoublyLinkedListADT<T> {

    private Node<T> head;

    public CircularDoublyLinkedListADT() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
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

    public void insertAtFront(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            newNode.next = newNode;
            newNode.previous = newNode;
            head = newNode;
            return;
        }

        Node<T> last = head.previous;

        newNode.next = head;
        newNode.previous = last;

        last.next = newNode;
        head.previous = newNode;

        head = newNode;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            newNode.next = newNode;
            newNode.previous = newNode;
            head = newNode;
            return;
        }

        Node<T> last = head.previous;

        newNode.next = head;
        newNode.previous = last;

        last.next = newNode;
        head.previous = newNode;
    }

    public void insertAtIndex(int index, T data) {
        int size = getSize();

        if (index < 0 || index > size) {
            System.out.println("Invalid index");
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

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(data);

        newNode.next = current;
        newNode.previous = current.previous;

        current.previous.next = newNode;
        current.previous = newNode;
    }

    public void deleteAtFront() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node<T> last = head.previous;

        head = head.next;

        head.previous = last;
        last.next = head;
    }

    public void deleteAtEnd() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == head) {
            head = null;
            return;
        }

        Node<T> last = head.previous;
        Node<T> newLast = last.previous;

        newLast.next = head;
        head.previous = newLast;
    }

    public void deleteAtIndex(int index) {
        int size = getSize();

        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
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

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    public void deleteKey(T key) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node<T> current = head;

        do {
            if (current.data.equals(key)) {

                if (current == head) {
                    deleteAtFront();
                    return;
                }

                current.previous.next = current.next;
                current.next.previous = current.previous;

                return;
            }

            current = current.next;

        } while (current != head);

        System.out.println("Key not found");
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
            System.out.println("Invalid index");
            return;
        }

        Node<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.data = data;
    }

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node<T> current = head;

        do {
            System.out.print(current.data + " ");
            current = current.next;

        } while (current != head);

        System.out.println();
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node<T> current = head.previous;

        do {
            System.out.print(current.data + " ");
            current = current.previous;

        } while (current != head.previous);

        System.out.println();
    }

    public void reverse() {
        if (isEmpty() || head.next == head) {
            return;
        }

        Node<T> current = head;

        do {
            Node<T> temp = current.next;

            current.next = current.previous;
            current.previous = temp;

            current = temp;

        } while (current != head);

        head = head.next;
    }

    public void clear() {
        head = null;
    }
}

public class CircularDoublyLinkedList {

    public static void main(String[] args) {

        CircularDoublyLinkedListADT<Integer> list =
                new CircularDoublyLinkedListADT<>();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);

        list.displayForward();
        // 1 2 3 4

        list.displayBackward();
        // 4 3 2 1

        list.insertAtFront(0);

        list.displayForward();
        // 0 1 2 3 4

        list.deleteAtEnd();

        list.displayForward();
        // 0 1 2 3

        list.deleteKey(2);

        list.displayForward();
        // 0 1 3

        System.out.println(list.search(3));
        // true

        list.update(1, 100);

        list.displayForward();
        // 0 100 3

        list.reverse();

        list.displayForward();
        // 3 100 0
    }
}
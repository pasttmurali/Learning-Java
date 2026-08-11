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

    // 1. Check whether list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // 2. Get size
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

    // 3. Insert at front
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

    // 4. Insert at end
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

    // 5. Insert at index
    // Using 0-based index
    public void insertAtIndex(int index, T data) {

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

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node<T> newNode = new Node<>(data);

        Node<T> previousNode = current.previous;

        newNode.next = current;
        newNode.previous = previousNode;

        previousNode.next = newNode;
        current.previous = newNode;
    }

    // 6. Delete front
    public void deleteAtFront() {

        if (isEmpty()) {
            System.out.println("Circular doubly linked list is empty");
            return;
        }

        // Only one node
        if (head.next == head) {
            head = null;
            return;
        }

        Node<T> last = head.previous;
        Node<T> newHead = head.next;

        last.next = newHead;
        newHead.previous = last;

        head = newHead;
    }

    // 7. Delete end
    public void deleteAtEnd() {

        if (isEmpty()) {
            System.out.println("Circular doubly linked list is empty");
            return;
        }

        // Only one node
        if (head.next == head) {
            head = null;
            return;
        }

        Node<T> last = head.previous;
        Node<T> newLast = last.previous;

        newLast.next = head;
        head.previous = newLast;
    }

    // 8. Delete at index
    public void deleteAtIndex(int index) {

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

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.previous.next = current.next;
        current.next.previous = current.previous;
    }

    // 9. Delete by key
    public void deleteKey(T key) {

        if (isEmpty()) {
            System.out.println("Circular doubly linked list is empty");
            return;
        }

        Node<T> current = head;

        do {

            if (current.data.equals(key)) {

                // Delete head
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

    // 10. Search
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

    // 11. Get data at index
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

    // 12. Update data
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

    // 13. Display forward
    public void displayForward() {

        if (isEmpty()) {
            System.out.println("Circular doubly linked list is empty");
            return;
        }

        Node<T> current = head;

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }

    // 14. Display backward
    public void displayBackward() {

        if (isEmpty()) {
            System.out.println("Circular doubly linked list is empty");
            return;
        }

        Node<T> current = head.previous;

        do {
            System.out.print(current.data + " ");
            current = current.previous;
        } while (current != head.previous);

        System.out.println();
    }

    // 15. Reverse
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

        // Old last becomes new head
        head = head.next;
    }

    // 16. Clear
    public void clear() {
        head = null;
    }
}


public class CircularDoublyLinkedListGeneric {

    public static void main(String[] args) {

        CircularDoublyLinkedListADT<Integer> list =
                new CircularDoublyLinkedListADT<>();


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

        System.out.println("After insert at front:");
        list.displayForward();
        // 0 1 2 3 4 5


        list.insertAtIndex(3, 100);

        System.out.println("After insert at index 3:");
        list.displayForward();
        // 0 1 2 100 3 4 5


        list.deleteAtFront();

        System.out.println("After delete front:");
        list.displayForward();
        // 1 2 100 3 4 5


        list.deleteAtEnd();

        System.out.println("After delete end:");
        list.displayForward();
        // 1 2 100 3 4


        list.deleteAtIndex(1);

        System.out.println("After delete index 1:");
        list.displayForward();
        // 1 100 3 4


        list.deleteKey(100);

        System.out.println("After deleting 100:");
        list.displayForward();
        // 1 3 4


        System.out.println("Search 3: " + list.search(3));
        // true


        list.update(1, 50);

        System.out.println("After update:");
        list.displayForward();
        // 1 50 4


        System.out.println("Before reverse:");
        list.displayForward();
        // 1 50 4

        list.reverse();

        System.out.println("After reverse:");
        list.displayForward();
        // 4 50 1


        System.out.println("Backward after reverse:");
        list.displayBackward();
        // 1 50 4
    }
}
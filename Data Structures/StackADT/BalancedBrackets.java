import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {

    Node top;

    LinkedListStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (isEmpty()) {
            return '\0';
        }

        char value = top.data;
        top = top.next;
        return value;
    }

    public char peek() {
        if (isEmpty()) {
            return '\0';
        }

        return top.data;
    }
}

public class BalancedBrackets {

    public static boolean isBalanced(String expression) {

        LinkedListStack stack = new LinkedListStack();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Closing brackets
            else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                if (ch == ')' && open != '(') {
                    return false;
                }

                if (ch == '}' && open != '{') {
                    return false;
                }

                if (ch == ']' && open != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String expression = input.nextLine();

        if (isBalanced(expression)) {
            System.out.println("Expression is balanced");
        } else {
            System.out.println("Expression is not balanced");
        }
    }
}
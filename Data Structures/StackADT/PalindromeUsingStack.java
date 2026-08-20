import java.util.Scanner;


class Node{

    char data;
    Node next;


    Node(char data){

        this.data = data;
        this.next = null;
    }
}


class LinkedListStackADT{

    Node top;


    LinkedListStackADT(){

        top = null;
    }


    public boolean isEmpty(){

        return top == null;
    }


    public void push(char data){

        Node newNode = new Node(data);

        newNode.next = top;

        top = newNode;
    }


    public char pop(){

        if(isEmpty()){

            System.out.println("Stack is Empty");

            return '\0';
        }


        char item = top.data;

        top = top.next;

        return item;
    }


    public char peek(){

        if(isEmpty()){

            return '\0';
        }

        return top.data;
    }
}


public class PalindromeUsingStack{

    public static boolean isPalindrome(String text){

        LinkedListStackADT stack =
                new LinkedListStackADT();


        String cleaned = "";


        // Remove non-alphanumeric characters
        // and convert uppercase to lowercase

        for(int i = 0; i < text.length(); i++){

            char ch = text.charAt(i);


            if(Character.isLetterOrDigit(ch)){

                ch = Character.toLowerCase(ch);

                cleaned = cleaned + ch;

                stack.push(ch);
            }
        }


        // Compare original cleaned string
        // with characters popped from stack

        for(int i = 0; i < cleaned.length(); i++){

            if(cleaned.charAt(i) != stack.pop()){

                return false;
            }
        }


        return true;
    }


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);


        System.out.print("Enter a string: ");

        String text = input.nextLine();


        if(isPalindrome(text)){

            System.out.println("Valid Palindrome");

        }else{

            System.out.println("Not a Palindrome");
        }
    }
}
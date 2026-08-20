class Node<T>{
    T data;
    Node<T> next;

    Node(T data){
        this.data = data;
        this.next = null;
    }
}


class GenericStack<T>{

    Node<T> top;

    GenericStack(){
        top = null;
    }


    public boolean isEmpty(){
        return top == null;
    }


    public void push(T data){

        Node<T> newNode = new Node<T>(data);

        newNode.next = top;
        top = newNode;
    }


    public T pop(){

        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }

        T item = top.data;

        top = top.next;

        return item;
    }


    public T peek(){

        if(isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }

        return top.data;
    }


    public void display(){

        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }

        Node<T> current = top;

        while(current != null){

            System.out.println(current.data);

            current = current.next;
        }
    }
}


public class GenericLinkedListStack{

    public static void main(String[] args){

        GenericStack<Integer> stack1 =
                new GenericStack<Integer>();

        stack1.push(10);
        stack1.push(20);
        stack1.push(30);

        System.out.println("Integer Stack:");

        stack1.display();

        System.out.println("Pop: " + stack1.pop());

        System.out.println("Peek: " + stack1.peek());


        GenericStack<String> stack2 =
                new GenericStack<String>();

        stack2.push("Apple");
        stack2.push("Banana");
        stack2.push("Mango");

        System.out.println("\nString Stack:");

        stack2.display();
    }
}
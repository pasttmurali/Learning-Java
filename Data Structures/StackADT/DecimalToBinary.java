import java.util.Scanner;


class ArrayStackADT{

    private int[] stack;
    private int top;
    private int max;


    ArrayStackADT(int size){

        max = size;
        stack = new int[max];
        top = -1;
    }


    public boolean isEmpty(){

        return top == -1;
    }


    public boolean isFull(){

        return top == max - 1;
    }


    public void push(int item){

        if(isFull()){

            System.out.println("Stack Overflow");
            return;
        }

        stack[++top] = item;
    }


    public int pop(){

        if(isEmpty()){

            System.out.println("Stack Underflow");
            return -1;
        }

        int item = stack[top];

        top--;

        return item;
    }
}


public class DecimalToBinary{

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter decimal number: ");

        int decimal = input.nextInt();

        ArrayStackADT stack = new ArrayStackADT(32);


        if(decimal == 0){

            System.out.println("Binary: 0");
            return;
        }


        int number = decimal;


        while(number > 0){

            int remainder = number % 2;

            stack.push(remainder);

            number = number / 2;
        }


        System.out.print("Binary: ");


        while(!stack.isEmpty()){

            System.out.print(stack.pop());
        }

        System.out.println();
    }
}
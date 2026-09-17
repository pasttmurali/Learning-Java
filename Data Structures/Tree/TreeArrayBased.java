class TreeArrayBasedADT {

    char[] bTree;
    int capacity;

    TreeArrayBasedADT(int capacity) {
        this.capacity = capacity;
        bTree = new char[capacity];

        for (int i = 0; i < capacity; i++) {
            bTree[i] = '-';
        }
    }


    public void setValue(int index, char value) {
        if (index >= 0 && index < capacity) {
            bTree[index] = value;
        }
    }


    public int findIndex(char value) {
        for (int i = 0; i < capacity; i++) {
            if (bTree[i] == value) {
                return i;
            }
        }
        return -1;
    }


    public char leftChild(char value) {

        int index = findIndex(value);

        if (index == -1)
            return '-';

        int left = 2 * index + 1;

        if (left < capacity)
            return bTree[left];

        return '-';
    }


    public char rightChild(char value) {

        int index = findIndex(value);

        if (index == -1)
            return '-';

        int right = 2 * index + 2;

        if (right < capacity)
            return bTree[right];

        return '-';
    }


    public char parent(char value) {

        int index = findIndex(value);

        if (index <= 0)
            return '-';

        int parentIndex = (index - 1) / 2;

        return bTree[parentIndex];
    }


    public void setRightChild(char parent, char value) {

        int index = findIndex(parent);

        if (index == -1)
            return;

        int right = 2 * index + 2;

        if (right < capacity) {
            bTree[right] = value;
        }
    }


    public void setParent(char child, char newParent) {

        int index = findIndex(child);

        if (index <= 0)
            return;

        int parentIndex = (index - 1) / 2;

        bTree[parentIndex] = newParent;
    }

    
    public int height(int index) {

        if (index >= capacity || bTree[index] == '-') {
            return 0;
        }

        int leftHeight = height(2 * index + 1);
        int rightHeight = height(2 * index + 2);

        return 1 + Math.max(leftHeight, rightHeight);
    }

   
    public int size() {

        int count = 0;

        for (int i = 0; i < capacity; i++) {
            if (bTree[i] != '-') {
                count++;
            }
        }

        return count;
    }

    
    public void display() {

        System.out.print("Tree : ");

        for (int i = 0; i < capacity; i++) {
            System.out.print(bTree[i] + " ");
        }

        System.out.println();
    }
}


public class TreeArrayBased {

    public static void main(String[] args) {

        TreeArrayBasedADT bt = new TreeArrayBasedADT(11);

        // Create tree given in the question

        bt.setValue(0, 'b');
        bt.setValue(1, 'i');
        bt.setValue(2, 'n');

        bt.setValue(4, 'a');
        bt.setValue(5, 'r');

        bt.setValue(10, 'y');

        bt.display();


        // 1. Get children of y

        System.out.println("\n1. Children of y");

        System.out.println(
            "Left child of y : " + bt.leftChild('y')
        );

        System.out.println(
            "Right child of y : " + bt.rightChild('y')
        );


        // 2. Get parent of r

        System.out.println(
            "\n2. Parent of r : " + bt.parent('r')
        );


        // 3. Set right child of n as o

        bt.setRightChild('n', 'o');

        System.out.println(
            "\n3. Right child of n after setting o : "
            + bt.rightChild('n')
        );


        // 4. Set parent of y as g

        bt.setParent('y', 'g');

        System.out.println(
            "\n4. Parent of y after setting g : "
            + bt.parent('y')
        );


        // 5. Height

        System.out.println(
            "\n5. Height of Tree : "
            + bt.height(0)
        );


        // 6. Size

        System.out.println(
            "\n6. Size of Tree : "
            + bt.size()
        );


        System.out.println("\nFinal Tree:");
        bt.display();
    }
}
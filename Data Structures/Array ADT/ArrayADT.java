import java.util.Scanner;
public class ArrayADT{
	private int[] arr;
	private int size;
	
	
	public ArrayADT(int capacity){
		arr=new int[capacity];
		size=0;
	}
	

	public void insert(int value){
		if(size == arr.length){
			throw new IllegalStateException("Array is Full");
		}
		
		arr[size]=value;
		size++;
	}
	
	 public void traverse() {
        if (size == 0) {
            throw new IllegalStateException("Array is Empty");
        } 
        else {
            System.out.print("Array elements: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
	//q1
	public void setElement(int index,int element){
		if(index<0 || index>=size){
			throw new IndexOutOfBoundsException("Index is out of range");
		}
		arr[index]=element;
		
	}
	
	//q2
	public int getSize(){
		return size;
	}
	
	//q3
	public boolean isFull(){
		return size == arr.length;
	}
	
	//q4
	public boolean isEmpty(){
		return size == 0;
	}
	
	//q5
	public void insertElement(int index,int element){
		if(index<0 || index >size)
		{
			throw new IndexOutOfBoundsException("Index is out of range");
		}else if(size==arr.length){
			System.out.println("Array is full");
		}else{
			for(int i =size-1;i>=index;i--){
				arr[i+1]=arr[i];
			}
			arr[index]=element;
			size++;
		}
	}
	
	//q6
	
	public boolean searchElement(int element){
		for(int i=0;i<size;i++){
			if(arr[i]==element){
				return true;
			}	
		}
		return false;
	}
	
	//q7
	public void delete(int index){
		if(index<0 || index >=size){
			throw new IndexOutOfBoundsException("Index is out of range");
		}else if(size == 0){
			throw new IllegalStateException("Array is Empty");
		}else{
			for(int i=index;i<size-1;i++){
				arr[i]=arr[i+1];
			}
			arr[size-1]=0;
			size--;
		}
		
	}
	
	//q8
	public int getElement(int index){
		if(index<0 || index >=size){
			throw new IllegalArgumentException("Index not found");
		}
		return arr[index];
		
	}
	
	//q9:Write a program that finds the minimum value in an integer array.
	public int findMin(){
		int min=arr[0];
		for(int i=1;i<size;i++){
			if(arr[i]<min){
				min=arr[i];
			}
		}
		return min;
	}
	
	//q10:Write a program that reverses the order of elements in an integer array.
	public int[] reverse(int a,int n){
		if(a>=n){
			return arr;
		}
		
		int temp=arr[a];
		arr[a]=arr[n];
		arr[n]=temp;
		
		return reverse(a+1,n-1);
	}
	
	
	public ArrayADT reverse(){
		reverse(0,size-1);
		return this;
	}
	
	//q11:Write a program that counts the frequency of each element in an integer array and prints the results.
	
	public void count(){
		for(int i=0;i<size;i++){
			boolean counted=false;
			for(int j=0;j<i;j++){
				if(arr[i]==arr[j]){
					counted=true;
					break;
				}
			} 
			if(counted){
				continue;
			}
			
			int count=0;
			for(int k=i;k<size;k++){
				if(arr[i]==arr[k]){
					count++;
				}
			}
			System.out.println("element "+arr[i]+" count is : "+count);
		}
	}
	
	//q12:Write a program that sorts the elements in an integer array in ascending order using bubble sorting algorithm.
	public ArrayADT bubbleSort(){
		if (size == 0) {
				throw new IllegalStateException("Array is Empty");
		}
		
		ArrayADT sorted=new ArrayADT(this.size);
		
		for(int i=0;i<size;i++){
			sorted.arr[i]=this.arr[i];
			sorted.size++;
		}
			
		for(int i=0;i<sorted.size;i++){
			boolean isSorted=true;
			for(int j=0;j<sorted.size-1-i;j++){
				if(sorted.arr[j]>sorted.arr[j+1]){
					int temp=sorted.arr[j];
					sorted.arr[j]=sorted.arr[j+1];
					sorted.arr[j+1]=temp;
				
					isSorted=false;
				}
				
			}
			if(isSorted){
				break;
			}
		}
		return sorted;
	}
	
	
	//q13:Write a program that merges two sorted integer arrays into a single sorted array
	public ArrayADT mergeArray(ArrayADT other){
		 if (other == null) {
				throw new IllegalArgumentException("Other array cannot be null values");
			}

		if (this.size == 0 && other.size == 0) {
				throw new IllegalStateException("Both arrays are empty");
			}

		ArrayADT merged=new ArrayADT(this.size+other.size);
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<this.size && j<other.size){
			if(this.arr[i]<=other.arr[j]){
				merged.arr[k]=this.arr[i];
				i++;
			}else{
				merged.arr[k]=other.arr[j];
				j++;
			}
			k++;
			merged.size++;
		}
		
		while(i<this.size){
			merged.arr[k]=this.arr[i];
			i++;
			k++;
			merged.size++;
		}
		
		while(i<other.size){
			merged.arr[k]=other.arr[j];
			j++;
			k++;
			merged.size++;
		}
		return merged;
	
	}
	
	//q14:Write a program that sorts the elements in an integer array in ascending order using selection sorting algorithm.
	public ArrayADT selectionSorting(){
		ArrayADT sorted=new ArrayADT(this.size);
		if (size == 0) {
				throw new IllegalStateException("Array is Empty");
		}
			
		for(int i=0;i<size;i++){
			sorted.arr[i]=this.arr[i];
			sorted.size++;
		}
		
		for(int i=0;i<sorted.size-1;i++){
			int minIndex=i;
			for(int j=i+1;j<size;j++){
				if(sorted.arr[minIndex]>sorted.arr[j]){
					minIndex=j;
				}
			}
			int temp=sorted.arr[i];
			sorted.arr[i]=sorted.arr[minIndex];
			sorted.arr[minIndex]=temp;
		}
		return sorted;
	}
	
	//q15:Write a program to find the second largest element in an array.
	public int findSecondMax(){
		
		if(size<2){
			throw new IllegalStateException("At least two elements are required.");
		}
			int max1;
			int max2;

			if (arr[0] > arr[1]) {
				max1 = arr[0];
				max2 = arr[1];
			} else if (arr[1] > arr[0]) {
				max1 = arr[1];
				max2 = arr[0];
			} else {
				max1 = arr[0];
				max2 = arr[0];
			}

			for (int i = 2; i < size; i++) {

				if (arr[i] > max1) {
					max2 = max1;
					max1 = arr[i];

				} else if (arr[i] > max2 && arr[i] < max1) {
					max2 = arr[i];
				}
			}
		if(max2 == max1){
			throw new IllegalStateException("The Array must contain at least two distinct values.");
		}
		return max2;
		
	}
	/*public int findSecondMax(){
		
		if(size<2){
			throw new IllegalStateException("At least two elements are required.");
		}
		int max1=Integer.MIN_VALUE;
		int max2=Integer.MIN_VALUE;
		
		for(int i=0;i<size;i++){
			if(arr[i]>max1){
				max2=max1;
				max1=arr[i];
			}else if(max2< arr[i] && max1>arr[i]){
				max2=arr[i];
			}
		}
		
		if(max2 == Integer.MIN_VALUE){
			throw new IllegalStateException("The Array must contain at least two distinct values.");
		}
		
		return max2;
		
	}*/
	
	
	//q16:Write a program to count the number of occurrences of a given element in an array.
	public int countElement(int num){
		if(size==0){
			throw new IllegalStateException("No elements in the Array.");
		}
		int count=0;
		for(int i =0;i<size;i++){
			if(arr[i]== num){
				count++;
			}
		}
		return count;
	}
	
	//q17:Write a program to remove duplicate elements from an array.
	public ArrayADT uniqueArray(){
		ArrayADT unique =new ArrayADT(this.size);
		for(int i=0;i<size;i++){
			boolean counted=false;
			for(int j=0;j<i;j++){
				if(arr[i]==arr[j]){
					counted=true;
					break;
				}
			} 
			if(counted){
				continue;
			}
			
			unique.insert(arr[i]);
		}
		return unique;
	}
	
	//q18:Write a program that sorts the elements in an integer array in ascending order using insertion sorting algorithm.
	public ArrayADT insertSorting(){
		if (size == 0) {
			throw new IllegalStateException("Array is Empty");
		}
		
		ArrayADT insertsort=new ArrayADT(this.size);
		
		
		for(int i=0;i<size;i++){
			insertsort.arr[i]=this.arr[i];
			insertsort.size++;
		}
		
		
		for(int i=1;i<insertsort.size;i++){
			int key=insertsort.arr[i];
			int j;
			
			for(j=i-1;j>=0 && insertsort.arr[j]>key;j--){
					insertsort.arr[j+1]=insertsort.arr[j];
				}
		
			insertsort.arr[j+1]=key;
			
		}
		return insertsort;
		
	}
	
	//q19:Write a program to check if two arrays are equal (having the same elements in the same order.
	public boolean isEqual(ArrayADT otherArray){
		if(this.size != otherArray.size){
			return false;
		}
		
		for(int i=0;i<this.size;i++){
			if(this.arr[i] != otherArray.arr[i]){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a number for Array Size: ");
		int n=sc.nextInt();
		ArrayADT arr1= new ArrayADT(n);
		arr1.insert(10);
		arr1.insert(20);
		arr1.insert(30);
		arr1.delete(1);
		
		System.out.print("\nAfter deleting one Element,");
		arr1.traverse();
		
		arr1.insert(10);	
		System.out.print("\nAfter inserting,");
		arr1.traverse();
	//q09	
		System.out.println("\nFind Min value in Arrray: "+arr1.findMin());
	//q10	
		System.out.print("\nAfter reverse, ");
		arr1.reverse().traverse();

	//q11	
		System.out.println("\nArray element count details \n---------------------");
		arr1.count();
	//q12	
		System.out.print("\nAfter Bubble sorting, ");
		arr1.bubbleSort().traverse();
				
		ArrayADT arr2 = new ArrayADT(5);
		arr2.insert(5);
		arr2.insert(15);
		arr2.insert(25);
	//q13	
		System.out.print("Merged sorted array: ");
		arr1.mergeArray(arr2).traverse();
	//q14	
		System.out.print("\nAfter selection sorting, ");
		arr1.selectionSorting().traverse();
		
		System.out.print("\nOriginal array: ");
		arr1.traverse();
		
	//q15	
		System.out.print("\nSecond largest element in an array: "+arr1.findSecondMax());
	//q16
		System.out.print("\nCount the number of occurrences of 10 is: "+arr1.countElement(10));
	
	//q17	
		System.out.print("\nAfter removing duplicate elements, ");
		arr1.uniqueArray().traverse();
		
	//q18
		System.out.print("\nAfter insertion Sorting Array elements, ");
		arr1.insertSorting().traverse();
		
		
	
	//q19:Write a program to check if two arrays are equal (having the same elements in the same order
	
		ArrayADT array1 =new ArrayADT(5);
		array1.insert(10);
		array1.insert(20);
		array1.insert(30);
		
		
		ArrayADT array2 =new ArrayADT(5);
		array2.insert(10);
		array2.insert(20);
		array2.insert(30);
		
		ArrayADT array3 =new ArrayADT(5);
		array3.insert(10);
		array3.insert(40);
		array3.insert(30);
		
		ArrayADT array4 =new ArrayADT(5);
		array4.insert(10);
		array4.insert(20);
		
		
		
		
		if(array1.isEqual(array2)){
			System.out.println("The two arrays are equal.");
		}else{
			System.out.println("The two arrays are not equal.");
		}
		
		if(array1.isEqual(array3)){
			System.out.println("The two arrays are equal.");
		}else{
			System.out.println("The two arrays are not equal.");
		}
		
		if(array1.isEqual(array4)){
			System.out.println("The two arrays are equal.");
		}else{
			System.out.println("The two arrays are not equal.");
		}
		
		sc.close();
	}
}
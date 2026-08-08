import java.util.Scanner;
import java.util.ArrayList;
public class FindKthLargestElement{
	
	public static int findkthLargestElement(ArrayList<Integer> list,int k){
		if(k>list.size() || list.isEmpty() || k<=0){
			return -1;
		}
		
		ArrayList<Integer> tempList=new ArrayList<>(list);
		int largest=-1;
		
		for(int count=1;count<=k;count++){
			largest=tempList.get(0);
			int largestIndex=0;
			
			for(int i=1;i<tempList.size();i++){
				if(tempList.get(i)>largest){
					largest=tempList.get(i);
					largestIndex=i;
				}
			}
			
			tempList.remove(largestIndex);
		}
		
		return largest;
	}
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter value for k");
		int k=sc.nextInt();
		
		ArrayList<Integer> list= new ArrayList<>();
		System.out.print("Enter the list size:");
		int n=sc.nextInt();
		System.out.println("Enter the list elements:");
		
		for(int i=0;i<n;i++){
			list.add(sc.nextInt());
		}
		System.out.println(list);
		int result=findkthLargestElement(list,k);


        System.out.println("Result: " + result);

        sc.close();
	}
}
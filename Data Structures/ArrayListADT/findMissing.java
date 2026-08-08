import java.util.Scanner;
import java.util.ArrayList;

public class findMissing{	

	public static ArrayList<Integer> findMissingElements(ArrayList<Integer> arrayList){
		ArrayList<Integer> missedNumbers = new ArrayList<>();
		int max = arrayList.get(0);
		
		for(int i =0; i < arrayList.size(); i++){
			if(arrayList.get(i)>max){
				max=arrayList.get(i);
			}
		}
		for(int i = 1; i < max; i++){
			if(!arrayList.contains(i)){
				missedNumbers.add(i);
			}
			
		}
		return missedNumbers;
	}
	
	public static void main(String [] args){
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements:");
		for(int i = 0; i < n; i++){
			arrayList.add(sc.nextInt());
		}
	
		System.out.println("ArrayList: "+arrayList);
		
		System.out.println("missedNumbers: "+findMissingElements(arrayList));
		
	}
}
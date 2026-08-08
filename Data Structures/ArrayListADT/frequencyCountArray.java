import java.util.Scanner;
import java.util.ArrayList;

public class frequencyCountArray{	

	public static void frequencyCount(String [] str){
		int [] frequencies = new int[str.length];  
		boolean [] counted = new boolean[str.length];
		
		for(int i =0; i < str.length; i++){
			String text = str[i];
			int frequency=1;
			
			if(!counted[i]){
				for(int j = i+1; j < str.length; j++){
					if(str[j].equals(text)){
						frequency++;
						counted[j]=true;
					}
				}
				frequencies[i] = frequency;
			}
			
		}
		
		for(int i = 0; i < str.length; i++){
			if(frequencies[i] !=0){
				System.out.println(str[i]+ ": "+frequencies[i]);
			}
			
		}
		
	}
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int n = sc.nextInt();
		String [] str = new String[n];
		
		sc.nextLine();
		
		System.out.println("Enter the text:");
		for(int i = 0; i < n; i++){
			str[i]=sc.nextLine();
		}
	
		/*for(String item : str){
			System.out.print(item+" ");
		}
		System.out.println();*/
		
		frequencyCount(str);
	}
}
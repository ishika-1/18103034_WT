import java.util.*;

public class A2 {
	public static void main (String arg[]) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter number of test cases.");
		int t = s.nextInt();

		while (t-- != 0) {
			System.out.println("Enter size of array.");
			int n = s.nextInt();

			int [] arr = new int[n];
			System.out.println("Enter array elements (between 0 and 20). ");
			int [] freq = new int[21];

			for(int i=0; i<n; i++){
	            arr[i] = s.nextInt();

	            if(arr[i]<0 || arr[i]>20)
	                freq[0]++;
	            else
	                freq[arr[i]]++;
	        }

	        int j=0;
	        for(int i=0; i<21; i++){

	            for(int k=0; k<freq[i]; k++){
	                arr[j] = i;
	                j++;
	            }
	        }

	        System.out.println("Sorted array is ");
	        for(int i=0; i<n; i++){
	            System.out.print(arr[i]+" ");
	        }

	        System.out.println("");
		}
	}
}

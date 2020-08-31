import java.util.*;

public class A3 {

	public static void sortCharArray(char [] arr, int n) {

		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n-i-1; j++) {
				if (arr[j] > arr[j+1]) {
                    char temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
			}
		}
	}

	public static void main (String arg[]) {
		
		Scanner s = new Scanner(System.in);

		System.out.println("Enter number of test cases.");
		int t = s.nextInt();

		while (t-- != 0) {
			System.out.println ("Enter string.");
			String str = s.next();

			char[] arr = str.toCharArray();
			int n = arr.length;

			sortCharArray(arr, n);

			str = new String(arr);
			System.out.println("Sorted string is " + str);
		}
	}
}

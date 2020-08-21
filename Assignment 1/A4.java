import java.util.Scanner;

public class A4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First String ");
        String s1 = sc.nextLine();

        System.out.println("Enter Second String ");
        String s2 = sc.nextLine();

        int arr[] = new int[257];

        for (int i=0; i<arr.length; i++) {
            arr[i] = 0;
        }

        for (int i=0; i<s1.length(); i++) {
            int x = s1.charAt(i);
            arr[x]++;
        }
        
        for (int i=0; i<s2.length(); i++) {
            int x = s2.charAt(i);
            if (arr[x]>0) {
                arr[x]--;
            }
        }
        
        int ans=0;
        for (int i=0; i<257; i++) {
            if (arr[i]>0) {
                ans = 1;
            }
        }
        
        if (ans == 1) {
            System.out.println("Not Anagrams");
        }
        else {
            System.out.println("Anagrams");
        }
    }
}

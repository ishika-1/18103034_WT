import java.util.Scanner;

public class A1{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String ");
        String s = sc.nextLine();

        System.out.println("Enter Pattern ");
        String p = sc.nextLine();

        int n = s.length();
        int m = p.length();

        int arr[] = new int[26];
        for(int i=0; i<26; i++) {
            arr[i] = 0;
        }
        for(int i=0; i<m; i++) {
            int x = p.charAt(i);
            x = x-97;
            arr[x] = arr[x]+1;
        }
        int count = 0;
        for(int i=0; i<=n-m; i++) {
            int b[] = new int[26];
            for(int k=0; k<26; k++) {
                b[k] = 0;
            }
            for(int j=i; j<i+m; j++) {
                int x = s.charAt(j);
                x = x-97;
                b[x] = b[x]+1;
            }
            int f = 0;
            for(int k=0; k<26; k++) {
                if(arr[k] != b[k]) {
                    f=1;
                }
            }
            if(f == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}

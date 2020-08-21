import java.util.Scanner;
import java.util.HashMap;

public class A2 {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String ");
        String s = sc.nextLine();

        System.out.println("Enter Number of Words ");

        int n;
        n = sc.nextInt();
        String arr[] = new String[n+1];
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        System.out.println("Enter Words ");
        
        for(int i=0; i<arr.length; i++) {
            arr[i]=sc.nextLine();
            map.put(arr[i],1);
        }

        int start = 0, end = 0;
        char ans[] = new char[s.length()+1];

        for(int i=0; i<s.length(); i++) {
            ans[i]=s.charAt(i);
        }

        while(end<s.length()) {
            if(s.charAt(end) == ' ') {
                if(map.get(s.substring(start,end)) != null) {
                    for(int j = start+1; j<end; j++) {
                        ans[j] = '*';
                    }
                }
                start = end+1;
            }
            end++;
        }

        for(int z=0; z<ans.length; z++) {
            System.out.print(ans[z]);
        }
    }
}

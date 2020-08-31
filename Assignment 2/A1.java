import java.util.*;

public class A1 {

    public static int compare (String s1, String s2) {
        
        for (int i=0; i<s1.length() && i<s2.length(); i++) {
        
            if ((int)s1.charAt(i) ==  (int)s2.charAt(i))
                continue; 
            else
                return (int)s1.charAt(i) - (int)s2.charAt(i); 
        }

        if (s1.length() < s2.length())
            return (s1.length()-s2.length()); 

        else if (s1.length() > s2.length())
            return (s1.length() - s2.length()); 
        
        else
            return 0;
    }

    public static void main (String arg[]) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.println ("Enter number of test cases.");
        int t = s.nextInt();
        
        while (t-- != 0) {
            System.out.println ("Enter first string.");
            String s1 = s.next();
        
            System.out.println ("Enter second string.");
            String s2 = s.next();
        
            int cmp = compare(s1, s2);
        
            if (cmp == 0) 
                System.out.println("Both strings are equal.");
            else if (cmp > 0) 
                System.out.println(s1 + " is lexicographically greater by " + cmp);
            else 
                System.out.println(s2 + " is lexicographically greater by " + (-1*cmp));
        }
    }
}

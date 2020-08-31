import java.util.*;

public class A4 {

	public static void main(String arg[]){

        int n = 1;
        int sum = 1;

        while(n < Integer.MAX_VALUE){

            if(sum == n*n)
                System.out.println("A possible value of i is " + n);
            n += 1;
            sum += n;
        }
    }
}

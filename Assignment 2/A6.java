import java.util.*;

public class A6{

    public static void main (String arg[]){

        Scanner s = new Scanner(System.in);

        System.out.println("Enter number of testcases.");
        int t = s.nextInt();

        while (t-- != 0) {
            System.out.println("Enter a number ");
            int n = s.nextInt();

            System.out.println("Hailstone sequence of " + n + " is: ");
            int c = 0;

            while(n!=1 && c<Integer.MAX_VALUE && n<Integer.MAX_VALUE && n>0){

                if(n%2!=0){
                    n*=3;
                    n++;
                }
                else{
                    n/=2;
                }

                System.out.print(n + " ");
                c++;
            }
            System.out.println();

            if (n==1)
                System.out.println("No of steps required "+c);

            else if (n==Integer.MAX_VALUE || n<0)
                System.out.println("Integer overflow reached");
            
            else
                System.out.println("No of steps maxed out.");
        }
    }
}

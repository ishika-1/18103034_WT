import java.util.*;

public class A5{

    public static void main(String arg[]){

        Scanner s = new Scanner(System.in);
        System.out.println("Enter maximum limit for universe");
        int maxEle = s.nextInt();

        System.out.println("Enter no. of elements in set a");
        int a = s.nextInt();
        System.out.println("Enter no. of elements in set b");
        int b = s.nextInt();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        ArrayList<Integer> a2 = new ArrayList<Integer>();

        System.out.println("Universe is ");
        ArrayList<Integer> universe = new ArrayList<Integer>();
        
        for(int i=0; i<=maxEle; i++){
            System.out.print(i + " ");
            universe.add(i);
        }
        System.out.println();
        
        int temp;
        boolean present;

        System.out.println("\nEnter elements of set a");
        
        for(int i=0; i<a; i++){

            temp = s.nextInt();
            if(temp<0 || temp>maxEle){
                temp = 0;
            }
            present = false;

            for(int j=0; j<a1.size(); j++){
                if(a1.get(j) == temp){
                    present = true;
                }
            }
            if(!present) {
                a1.add(temp);
            }
        }

        System.out.println("\nEnter elements of set b");

        for(int i=0; i<b; i++){

            temp = s.nextInt();
            if(temp<0 || temp>maxEle){
                temp = 0;
            }
            present = false;

            for(int j=0; j<a2.size(); j++){
                if(a2.get(j)==temp){
                    present = true;
                }
            }
            if(!present){
                a2.add(temp);
            }
        }

        // Using Arrays
        System.out.println("\nUSING ARRAYS");

        // Union
        long startTime = System.nanoTime();
        ArrayList<Integer> union = new ArrayList<Integer>();

        for(int i=0; i<a1.size(); i++){
            present = false;
            for(int j=0; j<union.size(); j++){
                if(a1.get(i) == union.get(j)){
                    present = true;
                    break;
                }
            }
            if(!present){
                union.add(a1.get(i));
            }
        }

        for(int i=0; i<a2.size(); i++){
            present = false;
            for(int j=0; j<union.size(); j++){
                if(a2.get(i) == union.get(j)){
                    present = true;
                    break;
                }
            }
            if(!present){
                union.add(a2.get(i));
            }
        }

        System.out.println("Union of a and b is:");
        System.out.print("[");
        for(int i=0; i<union.size(); i++){
            if (i != union.size()-1)
                System.out.print(union.get(i) + ", ");
            else 
                System.out.print(union.get(i));
        }
        System.out.println("]");

        long duration = System.nanoTime() - startTime;
        System.out.println("Time for union with arrays is " + duration + "ns");

        // Intersection
        startTime = System.nanoTime();
        ArrayList<Integer> intersection = new ArrayList<Integer>();
        for(int i=0; i<a1.size(); i++){
            present = false;
            for(int j=0; j<a2.size(); j++){
                if(a1.get(i) == a2.get(j)){
                    present = true;
                    break;
                }
            }
            if(present){
                intersection.add(a1.get(i));
            }
        }

        System.out.print("\nIntersection of a and b is: \n[");
        for(int i=0; i<intersection.size(); i++){
            if (i != intersection.size()-1)
                System.out.print(intersection.get(i) + ", ");
            else 
                System.out.print(intersection.get(i));
        }
        System.out.println("]");

        duration = System.nanoTime() - startTime;
        System.out.println("Time for intersection with arrays is " + duration + "ns");

        // Set Difference
        startTime = System.nanoTime();
        ArrayList<Integer> diff1 = new ArrayList<Integer>();

        for(int i=0; i<universe.size(); i++){
            present = false;
            for(int j=0; j<a1.size(); j++){
                if(a1.get(j) == universe.get(i)){
                    present = true;
                    break;
                }
            }
            if(!present){
                diff1.add(universe.get(i));
            }
        }

        System.out.print("\nSet difference of a and b is: \n[");
        for(int i=0; i<diff1.size(); i++){
            if (i != diff1.size()-1)
                System.out.print(diff1.get(i) + ", ");
            else 
                System.out.print(diff1.get(i));
        }
        System.out.println("]");

        ArrayList<Integer> diff2 = new ArrayList<Integer>();
        for(int i=0; i<universe.size(); i++){
            present = false;
            for(int j=0; j<a2.size(); j++){
                if(a2.get(j) == universe.get(i)){
                    present = true;
                    break;
                }
            }
            if(!present){
                diff2.add(universe.get(i));
            }
        }

        System.out.print("Set difference of b and a is \n[");
        for(int i=0;i<diff2.size();i++){
            if (i != diff2.size()-1)
                System.out.print(diff2.get(i)+", ");
            else 
                System.out.print(diff2.get(i));
        }
        System.out.println("]");

        duration = System.nanoTime() - startTime;
        System.out.println("Time for difference with arrays is " + duration + "ns");


        // Using sets
        System.out.println("\n\nUSING SETS");
        Set<Integer> universe_s = new HashSet<Integer>(), s1 = new HashSet<Integer>(), s2 = new HashSet<Integer>();
        universe_s.addAll(universe);
        s1.addAll(a1);
        s2.addAll(a2);

        // Union
        startTime = System.nanoTime();
        Set<Integer> union_s = new HashSet<Integer>(a);
        union_s.addAll(s2);
        System.out.println("\nUnion of a and b is: ");
        System.out.println(union);
        duration = System.nanoTime() - startTime;
        System.out.println("Time for union with sets is " + duration + "ns");

        // Intersection
        startTime = System.nanoTime();
        Set<Integer> intersection_s = new HashSet<Integer>(a);
        union_s.retainAll(s2);
        System.out.println("\nIntersection of a and b is: ");
        System.out.println(intersection);
        duration = System.nanoTime() - startTime;
        System.out.println("Time for intersection with sets is " + duration + "ns");

        // Set Difference
        startTime = System.nanoTime();
        Set<Integer> diff1_s = new HashSet<Integer>(universe_s), diff2_s = new HashSet<Integer>(universe_s);
        diff1_s.removeAll(s1);
        System.out.println("\nSet difference of a and b is: ");
        System.out.println(diff1_s);

        diff2_s.removeAll(s2);
        System.out.println("Set difference of b and a is: ");
        System.out.println(diff2_s);
        duration = System.nanoTime() - startTime;
        System.out.println("Time for set difference with sets is " + duration + "ns");

        System.out.println("\n\nTime Complexity of sets < arrays");
    }
}

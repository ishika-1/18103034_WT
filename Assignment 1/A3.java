import java.util.ArrayList; 
import java.util.LinkedList;
import java.util.Scanner; 

public class A3 {
    public static void main(String args[]) { 
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Vertices ");
        int v = sc.nextInt(); 
 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v); 

        for (int i = 0; i < v; i++) { 
            adj.add(new ArrayList<Integer>()); 
        } 

        System.out.println("Enter Number of Edges "); 
        int e = sc.nextInt();
        
        System.out.println("Enter Edges "); 
        
        for(int i=0;i<e;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);     
        } 

        System.out.println("Enter Source "); 
        int source = sc.nextInt();

        System.out.println("Enter Destination "); 
        int destination = sc.nextInt(); 
        
        path(adj, source, destination, v); 
    }

    private static void path( ArrayList<ArrayList<Integer>> adj, int s, int dest, int v) { 

        int pred[] = new int[v]; 
        int dist[] = new int[v]; 

        if (BFS(adj, s, dest, v, pred, dist) == false) { 
            System.out.println("Negative Cycles Exist "); 
            return; 
        } 

        LinkedList<Integer> path = new LinkedList<Integer>(); 
        int crawl = dest; 
        path.add(crawl); 
        
        while (pred[crawl] != -1) { 
            path.add(pred[crawl]); 
            crawl = pred[crawl]; 
        } 

        System.out.println("Path is "); 
        
        for (int i = path.size() - 1; i >= 0; i--) { 
            System.out.print(path.get(i) + " "); 
        } 
    } 

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]) {

        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        boolean visited[] = new boolean[v]; 

        for (int i = 0; i < v; i++) { 
            visited[i] = false; 
            dist[i] = Integer.MAX_VALUE; 
            pred[i] = -1; 
        }

        visited[src] = true; 
        dist[src] = 0; 
        queue.add(src); 
        
        while (!queue.isEmpty()) { 
        
            int u = queue.remove(); 
            for (int i = 0; i < adj.get(u).size(); i++) { 
                
                if (visited[adj.get(u).get(i)] == false) { 
                
                    visited[adj.get(u).get(i)] = true; 
                    dist[adj.get(u).get(i)] = dist[u] + 1; 
                    pred[adj.get(u).get(i)] = u; 
                    queue.add(adj.get(u).get(i)); 
                
                    if (adj.get(u).get(i) == dest) 
                        return true; 
                } 
            } 
        } 
        return false;
    }
}

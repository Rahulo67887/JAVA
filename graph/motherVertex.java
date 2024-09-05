import java.util.*;

public class motherVertex {

    public static void DFSutil(ArrayList<Integer> graph[], int i, boolean vis[]){
        vis[i]=true;

        for(int x : graph[i]){
            if(!vis[x]){
                DFSutil(graph, x, vis);
            }
        }
    }

    public static int motherVertex(ArrayList<Integer> graph[], int V){
        boolean vis[]=new boolean[V];
        int v=-1;

        for(int i=0; i<V; i++){
            if(!vis[i]){
                DFSutil(graph, i,vis);
                v=i;
            }
        }

        Arrays.fill(vis, false);

        DFSutil(graph, v, vis);
        for(boolean check : vis){
            if(check==false){
                return -1;
            }
        }

        return v;
    }
    
    public static void main(String[] args) {
        int V = 7;
        int E = 8;
 
        ArrayList<Integer> graph[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i]=(new ArrayList<Integer>());
        }
        graph[0].add(1);
        graph[0].add(2);
        graph[1].add(3);
        graph[4].add(1);
        graph[6].add(4);
        graph[5].add(6);
        graph[5].add(2);
        graph[6].add(0);
        
          // Function call
        System.out.println("A mother vertex is "+ motherVertex(graph, V));
    }

}

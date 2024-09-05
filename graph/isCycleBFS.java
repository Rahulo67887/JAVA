import java.util.*;

public class isCycleBFS {
        public static class Edge{
            int src;
            int dest;
    
            Edge(int src, int dest){
                this.src = src;
                this.dest = dest;
            }
        }
    
        public static void createGraph(ArrayList<Edge> graph[]){
            for(int i=0; i<graph.length; i++){
                graph[i]=new ArrayList<>();
            }
    
            graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        }

        public static boolean iscycle(ArrayList<Edge>[] graph){
            boolean vis[] = new boolean[graph.length];
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            int par[]=new int[graph.length];
            vis[0]=true;

            while(!q.isEmpty()){
                int curr=q.remove();
                    for(int i=0; i<graph[curr].size(); i++){
                        Edge e=graph[curr].get(i);
                        if(!vis[e.dest]){
                            vis[e.dest]=true;
                            par[e.dest]=curr;
                            q.add(e.dest);
                        }
                        else if(par[curr]!=e.dest){
                            return true;
                        }
                    }
                
            }

            return false;
        }

        public static void main(String[] args) {
            int V=5;
            ArrayList<Edge> graph[]=new ArrayList[V];
            createGraph(graph);
    
            System.out.println(iscycle(graph));
        }
}

import java.util.*;

class rough{

    public static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }

    static int n=3;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    public static int find(int x){
        if(x==par[x]){
            return x;
        }

        return par[x]=find(par[x]);
    }

    public static void union(int a, int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]){
            par[parB]=parA;
        }
        else{
            par[parA]=parB;
        }
    }

    public static void init(){
        for(int i=0; i<n; i++){
            par[i]=i;
        }
    }

    public static boolean isCycle(ArrayList<Edge> graph, int V){
        init();
        for(int i=0; i<V; i++){
            Edge e=graph.get(i);
            int x=find(e.src);
            int y=find(e.dest);

            if(x==y){
                return true;
            }

            union(x, y);
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
    ArrayList<Edge> graph=new ArrayList<>();
    graph.add(new Edge(0,1));
    graph.add(new Edge(1,2));
    graph.add(new Edge(0,2));

if (isCycle(graph, V) == true)
System.out.println("Graph contains cycle");
else
System.out.println(
"Graph doesn't contain cycle");
    }


}
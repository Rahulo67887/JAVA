import java.util.*;

public class cheapflightKstops {

    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int src, int d, int w){
            this.src=src;
            this.dest=d;
            this.wt=w;
        }
    }

    public static class Info{
        int v;
        int cost;
        int stops;

        Info(int v, int c, int s){
            this.v=v;
            this.cost=c;
            this.stops=s;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++){
            Edge e=new Edge(flights[i][0], flights[i][1], flights[i][2]);
            graph[flights[i][0]].add(e);
        }
    }

    public static int cheapestFlight(int n, int k, int flights[][], int src, int dest){
        ArrayList<Edge> graph[]=new ArrayList[n];
        createGraph(flights, graph);

        int dist[]=new int[n];
        for(int i=0; i<n; i++){
            if(i!=src){
                dist[i]= Integer.MAX_VALUE;
            }
        }

        Queue<Info> q=new LinkedList<>();
        q.add(new Info(src,0,0));

        while(!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }

            for(int i=0; i<graph[curr.v].size(); i++){
                Edge e=graph[curr.v].get(i);
                if(dist[e.src]!=Integer.MAX_VALUE && curr.cost+e.wt<dist[e.dest] && curr.stops<=k){
                    dist[e.dest]=curr.cost+e.wt;
                    q.add(new Info(e.dest, dist[e.dest], curr.stops+1));
                }
            }
        }

        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dest];
        }
    }
    
    public static void main(String args[]){
        int n=4;
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dst=3;
        int k=1;
        System.out.println(cheapestFlight(n, k, flights, src, dst));
    }


}

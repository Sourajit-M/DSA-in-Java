import java.util.*;
public class GraphsB_5 {

    static class Edge{
        int src;
        int dest;
        int w;
        public Edge(int src, int dest, int w){
            this.src = src;
            this.dest = dest;
            this.w = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 100));
    
        graph[1].add(new Edge(1, 2, 100));
        graph[1].add(new Edge(1, 3, 600));

        graph[2].add(new Edge(2, 0, 100));
        graph[2].add(new Edge(2, 3, 200));

    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<Edge>[] graph){
        boolean vis[]= new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.w));
                }
            }
        }

        System.out.println("Min Cost of MST = "+finalCost);
    }

    static class Info implements Comparable<Info>{
        int v;
        int cost;
        int stop;

        public Info(int v, int cost, int stop){
            this.v = v; 
            this.cost = cost;
            this.stop = stop;
        }

        @Override
        public int compareTo(Info o2){
            return this.stop - o2.stop;
        }
    }

    public static void cheapestKStop(ArrayList<Edge>[] graph, int src, int dst, int k){
        int dist[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        Queue<Info> q = new LinkedList<>();

        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;

                for(int i=0; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    if(dist[e.src]!=Integer.MAX_VALUE && curr.cost+e.w<dist[e.dest] && curr.stop<=k){
                        dist[e.dest] = curr.cost + e.w;
                        q.add(new Info(e.dest, e.w, curr.stop+1));
                    }
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println("Cheapest flights K stops = "+dist[dst]);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        cheapestKStop(graph, 0, 3, 1);
    }
}

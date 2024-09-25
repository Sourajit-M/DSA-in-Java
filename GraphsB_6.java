import java.util.*;
public class GraphsB_6 {

    static class Edges implements Comparable<Edges>{
        int dest;
        int cost;
        public Edges(int d, int c){
            this.dest = d;
            this.cost = c;
        }
        @Override
        public int compareTo(Edges e2){
            return this.cost - e2.cost;
        }
    }

    public static int connectingCities(int cities[][]){
        PriorityQueue<Edges> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edges(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()){
            Edges curr = pq.remove();
            if(!vis[curr.dest]){
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for(int i=0; i<cities[curr.dest].length; i++){
                    if(cities[curr.dest][i] != 0){
                        pq.add(new Edges(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalCost;
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    
    public static void init(){
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]); //path compression
    }

    public static void union(int a, int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        }else if(rank[parA] < rank[parB]){
            par[parA] = parB;
        }else{
            par[parB] = parA;
        }
    }

    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void kruskalsMST(ArrayList<Edge> edges, int V){
        init();
        Collections.sort(edges);
        int ans = 0;
        int count = 0;

        for(int i=0; count<V-1; i++){
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);
            
            if(parA != parB){
                union(e.src, e.dest);
                ans += e.wt;
                count++;
            }
        }
        System.out.println("MST cost = "+ans);
    }

    public void helper(int image[][], int sr, int sc, int color,boolean vis[][], int OrgCol){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc] != OrgCol || vis[sr][sc]){
            return;
        }
        if(sr>=0 && sc>=0 && sr<image.length && sc<image[0].length && image[sr][sc]==OrgCol && !vis[sr][sc]){
            vis[sr][sc] = true;
            image[sr][sc] = color;
        }
        //left
        helper(image, sr, sc-1, color, vis, OrgCol);
        //right
        helper(image, sr, sc+1, color, vis, OrgCol);
        //up
        helper(image, sr-1, sc, color, vis, OrgCol);
        //down
        helper(image, sr+1, sc, color, vis, OrgCol);
    }

    public  int[][] floodFill(int image[][], int sr, int sc, int color){
        boolean vis[][] = new boolean[image.length][image[0].length];
        if(image[sr][sc] == color){
            return image;
        }

        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int image[][] = {{1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}};
        
        GraphsB_6 obj = new GraphsB_6();
        obj.floodFill(image, 1, 1, 2);
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                System.out.print(image[i][j]+" ");
            }
        }
    }
}

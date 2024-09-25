import java.util.*;
public class HeapsB_2 {

    public static int connectNRopes(int ropes[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;
        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }

        while(pq.size() != 1){
            int x = pq.remove();
            int y = pq.remove();
            cost += x + y;
            pq.add(x+y);
        }
        return cost;
    }
    
    static class Row implements Comparable<Row>{
        int soldiers;
        int idx;
        public Row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(Row obj2){
            if(this.soldiers == obj2.soldiers){
                return this.idx - obj2.idx;
            }
            else{
                return this.soldiers - obj2.soldiers;
            }
        }
    }

    public static void weakestSoldier(int army[][], int k){
        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i=0; i<army.length; i++){
            int cSol = 0;
            for(int j=0; j<army[0].length; j++){
                cSol += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(cSol, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("ROW"+pq.remove().idx);
        }
    }

    static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.val - this.val;
        }
    }

    public static void slidingWindowMax(int arr[], int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int res[] = new int[arr.length-k+1];

        for(int i=0; i<k; i++){
            pq.add(new Pair(arr[i], i));
        }

        res[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++){
            while(pq.size()>0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        slidingWindowMax(arr, 3);
    }
}

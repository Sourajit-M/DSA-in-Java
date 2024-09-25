import java.util.*;
public class HeapsB {

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
        //add at last
        arr.add(data);
        int x = arr.size()-1; //idx of child
        int par = (x-1)/2; //idx of parent

        while(arr.get(x) < arr.get(par)){
            //swap
            int temp = arr.get(x);
            arr.set(x, arr.get(par));
            arr.set(par, temp);


            x = par;
            par = (x-1)/2;
        }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }

        }

        public int remove(){

            int data = arr.get(0);

            //step 1
            int swap = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, swap);

            //step 2
            arr.remove(arr.size()-1);

            //step 3
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void heapify(int arr[], int i, int size){
        
        int left = 2*i + 1;
            int right = 2*i + 2;
            int maxIdx = i;

            if(left < size && arr[i] < arr[left]){
                maxIdx = left;
            }
            if(right < size && arr[i] < arr[right]){
                maxIdx = right;
            }
            if(maxIdx != i){
                int temp = arr[0];
                arr[0] = arr[maxIdx];
                arr[maxIdx] = temp;;

                heapify(arr, maxIdx, size);
            }
    }

    public static void heapSort(int arr[]){
        //step 1 : create maxHeap
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        //step 2:
        for(int i=n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int DistSq;
        int idx;
        public Point(int x, int y, int DistSq, int idx){
            this.x = x;
            this.y = y;
            this.DistSq = DistSq;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.DistSq - p2.DistSq;
        }
    }

    public static void nearByKCars(int pts[][], int k){
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i=0; i<pts.length; i++){
            int DistSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], DistSq, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("C"+pq.remove().idx);
        }
    }

    public static void main(String[] args) {
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        nearByKCars(pts, 2);
       
    }
}

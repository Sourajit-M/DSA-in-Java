import java.util.*;
public class GreedyAlgo {
    
    public static void ActivitySel(int start[], int end[]){
        
        int activity[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++){
           activity[i][0] = i;
           activity[i][1] = start[i];
           activity[i][2] = end[i];
        }
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        int maxAct = 1;
        list.add(activity[0][0]);
        int lastEnd = activity[0][2]; 

        for(int i=1; i<end.length; i++){
            if(activity[i][1] >= lastEnd){
                maxAct += 1;
                lastEnd = activity[i][2];
                list.add(activity[i][0]);
            }
        }
        System.out.println("Max Activity = "+maxAct);
        for(int i=0; i<list.size(); i++){
            System.out.print("A"+list.get(i)+" ");
        }
        System.out.println();
    }
    
    public static void fracKnapsack(int val[], int weight[], int W){
        double ratio[][] = new double[val.length][2];

        for(int i=0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W; int finalValue=0;

        for(int i=val.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                capacity = capacity - weight[idx];
                finalValue = finalValue + val[idx];
            }
            else{
                finalValue = finalValue + (int)(ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Maximum value = "+finalValue);
    }

    public static void maxChainPairlength(int ar[][]){
        Arrays.sort(ar, Comparator.comparingDouble(o -> o[1]));

        int maxChainLength = 1;
        int LastpairEnd = ar[0][1];

        for(int i=1; i<ar.length; i++){
            if(ar[i][0] > LastpairEnd){ //pair->start > last selected chain
                maxChainLength++;
                LastpairEnd = ar[i][1];
            }
        }
        System.out.println("Max Chain Length of pairs = "+maxChainLength);
    }
    
    public static void IndianCoins(Integer coins[], int V){

        Arrays.sort(coins, Comparator.reverseOrder());

        int den[][] = new int[coins.length][2];
        for(int i=0; i<coins.length; i++){
            den[i][0] = i;
            den[i][1] = coins[i];
        }
        ArrayList<Integer> list = new ArrayList<>();

        int amt = V; int countOfCoins=0;

        for(int i=0; i<coins.length; i++){
            int idx = den[i][0];
            while(amt >= coins[idx] && amt!=0){
                countOfCoins++;
                list.add(den[idx][1]);
                amt -= coins[idx];
            }
        }
        System.out.println("Min coins used = "+countOfCoins);
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int i, int d, int p){
           id = i;
           deadline = d;
           profit = p;
        }
    }

    public static void ChocolaProbleme(Integer costVer[], Integer costHor[]){
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0, v=0;
        int hp=1, vp=1;
        int cost = 0;
        
        while(h<costHor.length && v<costVer.length){
            if(costVer[v] < costHor[h]){ //horizontal cut
            cost += (vp*costHor[h]);
            hp++;
            h++;
            }
            else{
                cost += (hp*costVer[v]); //vertical cut
                vp++;
                v++;
            }
        }

        while(h<costHor.length){
            cost += (vp*costHor[h]);
            hp++;
            h++;
        }

        while(v<costVer.length){
            cost += (hp*costVer[v]);
            vp++;
            v++;
        }

        System.out.println("Minimum Cost of breaking into single squares = "+cost);
    }

    public static void main(String[] args) {
    /** 
    int Jobsinfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};

    ArrayList<Job> jobs = new ArrayList<>();

    for(int i=0; i<Jobsinfo.length; i++){
        jobs.add(new Job(i, Jobsinfo[i][0], Jobsinfo[i][1]));
    }

    Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit); //descending order

    ArrayList<Integer> seq = new ArrayList<>();
    int time=0;

    for(int i=0; i<jobs.size(); i++){
        Job curr = jobs.get(i);
        if(time < curr.deadline){
            time++;
            seq.add(curr.id);
        }
    }
    System.out.println("Max Jobs = "+seq.size());
    for(int i=0; i<seq.size(); i++){
        System.out.print(seq.get(i)+" ");
    }
    System.out.println();
    */

    Integer costVer[] = {2, 1, 3, 1, 4};
    Integer costHor[] = {4, 1, 2};

    ChocolaProbleme(costVer, costHor);
    }
}

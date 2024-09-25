// import java.util.*;
public class DynaProg_1 {
  public static int fibo(int n, int dp[]){//Memoization
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
        return dp[n]; 
    }

    public static int fibTabulation(int n, int dp[]){//Tabulation
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public static int climbingStair(int n, int dp[]){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = climbingStair(n-1, dp) + climbingStair(n-2, dp);
        return dp[n];
    }

    public static int climbStairTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }

    public static int knapsack01(int wt[], int val[], int W, int n, int dp[][]){ //0(nW)
        if(n==0 || W==0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){
            //include
            int ans1 = val[n-1] + knapsack01(wt, val, W-wt[n-1], n-1, dp);
            //exclude
            int ans2 = knapsack01(wt, val, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }else{
            dp[n][W] = knapsack01(wt, val, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int knapsackTab(int wt[], int val[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0; //0th col
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0; //0th row
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    //case 1: include
                    int ans1 = v + dp[i-1][j-w];
                    //case 2: exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{
                    dp[i][j] = dp[i-1][j]; //exclude
                }
            }
        }
        return dp[n][W];
    }

    public static void printDp(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static boolean targetSum(int num[], int targetSum){
        int n = num.length;
        boolean dp[][] = new boolean[num.length+1][targetSum+1];
        for(int i=0; i<dp.length; i++){//0th col
            dp[i][0] = true;
        }
        // for items=0 for any sum it is false

        for(int i=1; i<n+1; i++){
            for(int j=1; j<targetSum+1; j++){
                int v = num[i-1];
                if(v <= j && dp[i-1][j-v]==true){//include
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true){//exclude
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][targetSum];
    }

    public static int unboundedKnapsack(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0; //0th col
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0; //0th row
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){
                    //case 1: include
                    int ans1 = v + dp[i][j-w];
                    //case 2: exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{
                    dp[i][j] = dp[i-1][j]; //exclude
                }
            }
        }
        return dp[n][W];
    }

    /*
     i means ith items
     and j means size of knapsack is j

     so we find the max of ith item + i-1 th item
     */


    public static int rodCutting(int length[], int price[], int rodLength){//0(n * rodLength)
        int n = price.length;
        int dp[][] = new int[n+1][rodLength+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0; //0th col
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0; //0th row
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = price[i-1];
                int w = length[i-1];
                if(w <= j){
                    //case 1: include
                    int ans1 = v + dp[i-1][j-w];
                    //case 2: exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }else{
                    dp[i][j] = dp[i-1][j]; //exclude
                }
            }
        }
        printDp(dp);
        return dp[n][rodLength];
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 8;
        System.out.println(rodCutting(length, price, rodLength));
    }
}

import java.util.Arrays;

public class DynaProg_3 {

    public static boolean isMatching(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n+1][m+1];

        dp[0][0] = true;
        for(int i=1; i<n+1; i++){
            dp[i][0] = false;
        }

        for(int j=1; j<m+1; j++){
            if(pattern.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }

        return dp[n][m];
    }

    public static int catalanNumber(int n, int dp[]){
        if(n==0 || n==1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ans=0;

        for(int i=0; i<n; i++){
            ans += catalanNumber(i, dp)*catalanNumber(n-1-i, dp);
        }

        return dp[n]=ans;
        
    }

    public static int catalanNumberTab(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;


        for(int i=2; i<n+1; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }

        return dp[n];
    }

    public static int countingBST(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<i; j++){
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
        }

        return dp[n];
    }

    public static int mountainRanges(int n){
        int dp[] = new int[n+1];

        dp[0] = 1;
        dp[1]= 1;

        for(int i=2; i<n+1; i++){
            for(int j=0; j<i; j++){
                int m = dp[j];
                int v = dp[i-j-1];

                dp[i] += m*v;
            }
        }

        return dp[n];
    }


    public static int matrixChainMultiplication(int arr[], int i, int j){

        if(i == j){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        for(int k=i; k<=j-1; k++){
            int cost1 = matrixChainMultiplication(arr, i, k);
            int cost2 = matrixChainMultiplication(arr, k+1, j);

            int cost3 = arr[i-1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans, finalCost);
        }

        return ans;
    }


    public static int mcmMem(int arr[], int i, int j, int dp[][]){ //0(n^2)
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++){
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k] * arr[j];

            ans = Math.min(ans, cost1+cost2+cost3);
        }

        return dp[i][j] = ans;
    }


    public static int mcmTab(int arr[]){
        int n = arr.length;

        int dp[][] = new int[n][n];

        //initialization
        // for(int i=0; i<n; i++){
        //     dp[i][i] = 0;
        // }

        for(int len=2; len<n; len++){
            for(int i=1; i<=n-len; i++){
                int j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<=j-1; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }

        print(dp);
        return dp[1][n-1];
    }

    public static void print(int dp[][]){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        

        System.out.println(mcmTab(arr));
    }
}

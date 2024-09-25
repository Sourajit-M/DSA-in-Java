import java.util.HashSet;
import java.util.Arrays;
public class DynaProg_2 {

    public static int lcs(String str1, String str2, int n, int m){ //Longest Common Subseqeunce
        if(n==0 || m==0){
            return 0;
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return lcs(str1, str2, n-1, m-1)+1;
        }
        int ans1 = lcs(str1, str2, n-1, m);
        int ans2 = lcs(str1, str2, n, m-1);
        return Math.max(ans1, ans2);
    }

    public static int editDistance(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j<m+1; j++){
                if(i == 0){
                    dp[i][j] = j;
                }
                if(j == 0){
                    dp[i][j] = i;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int rep = dp[i-1][j-1] + 1;

                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }

        return dp[n][m];
    }

    public static int tabLCS(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];


        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static int longestCommonSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        int ans = 0;

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans;
    }

    public static int lis(int arr1[]){
        int n = arr1.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()];
        int i=0;
        for (int num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);

        
        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];


        for(int k=1; k<n+1; k++){
            for(int j=1; j<m+1; j++){
                if(arr1[k-1] == arr2[j-1]){
                    dp[k][j] = dp[k-1][j-1]+1;
                }else{
                    int ans1 = dp[k-1][j];
                    int ans2 = dp[k][j-1];
                    dp[k][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];        

    }

    public static int lcsMemoization(String str1, String str2, int dp[][], int n, int m){//fill dp with -1 first
         if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            return dp[n][m] = lcs(str1, str2, n-1, m-1)+1;
        }
        int ans1 = lcsMemoization(str1, str2, dp, n-1, m);
        int ans2 = lcsMemoization(str1, str2, dp, n, m-1);
        return dp[n][m] = Math.max(ans1, ans2);
    }

    public static int stringConversion(String str1, String str2){
        
        int lcs = tabLCS(str1, str2);

        int delete = str1.length() - lcs;

        int add = str2.length() - lcs;
        
        return delete + add;
    }

    public static boolean wildcardMatching(String text, String pattern){
        int n = text.length();
        int m = pattern.length();
        boolean dp[][] = new boolean[n+1][m+1];


        return dp[n][m];
    }

    public static void main(String[] args) {
        // String str1 = "ABCDGH", str2 = "ACDGHR";
        // System.out.println(longestCommonSubstring(str1, str2));
        // int arr[] = {50, 3, 10, 7, 40, 80};
        // System.out.println(lis(arr));

        System.out.println(stringConversion("abcdef", "aceg"));
    }
}
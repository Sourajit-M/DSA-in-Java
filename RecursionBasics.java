public class RecursionBasics {

    public static void fibo(int n, int a, int b){
        int c = a+b;
        // 0 is considered to be 1st term 
        if(n == 0){
        System.out.print(c+ " ");
        return;    
        }
        if(a==0 && b ==1){
        System.out.print(a+ " ");
        System.out.print(b+ " "); 
        n = n - 2;  // first 2 terms are printed 
       }
        System.out.print(c+ " ");
        a = b;
        b = c;
        fibo(n-1, a, b);
    }
     
    public static int OptimizedPower(int a, int n){
        if(n == 0){
            return 1;
        }
        int halfSquare = OptimizedPower(a, n/2);
        int square = halfSquare * halfSquare;
        if(n % 2 != 0){
        square = square * a;
        }
        return square;
    }
   
   
    public static int tilingProblem(int n){ //floar size 2*1
        if(n == 0 || n == 1){
            return 1;
        }
        //vertical choice
        int fnm1 = tilingProblem(n-1);
        // horizontal choice
        int fnm2 = tilingProblem(n-2);
        return fnm1 + fnm2;
    }

    public static int FriendPairing(int n){
        if(n == 1 || n == 2){
        return n;
        }
        return FriendPairing(n-1) + (n-1)*FriendPairing(n-2);
    }
    
    public static void printBinStrings(int n, int lastplace, String str){
       if(n == 0){
        System.out.println(str);
        return;
       }

        //for non consecutive 1's
      
        printBinStrings(n-1, 0, str+"0");
       if(lastplace == 0){
        printBinStrings(n-1, 1, str+"1");
       } 
      
       /* 
       
       for non consecutive 0's
       
       printBinStrings(n-1, 1, str+"1");
       if(lastplace == 1){
        printBinStrings(n-1, 0, str+"0");
       }
       */
    }

    public static void main(String args[])
    {
    printBinStrings(3, 0, "");   
   //System.out.println(FriendPairing(3));
    }
}

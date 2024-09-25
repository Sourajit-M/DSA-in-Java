public class fibonacciWR {
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
    public static void main(String args[])
    {
        fibo(5, 0, 1);
    }
}

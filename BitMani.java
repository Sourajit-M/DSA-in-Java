 public class BitMani {
    public static int getithBit(int n, int i){
        int Bitmask = 1<<i;
        return n & Bitmask;
    }
    public static int setithBit(int n, int i){
        int Bitmask = 1<<i;
        return n | Bitmask;
    }
    public static int clearithBit(int n, int i){
        int Bitmask = ~(1<<i);
        return  n & Bitmask;
    }
    public static int updateithBit(int n, int i, int newBit){
        n = clearithBit(n, i);
        int Bitmask = newBit<<i;
        return n | Bitmask;
    }
    public static int clearIBits(int n, int i){
        int Bitmask = (~0)<<i;
        return n & Bitmask;
    }
    public static int clearIbitsinrange(int n, int i, int j){
        int a = (~0)<<j+1;
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask;
    }
    public static int CountSetBit(int n){
        int count = 0;
        while(n > 0){
         if((n&1) != 0){
           count++; 
         }
         n =n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n){
        int ans = 1;
        while(n>0){
            if((n&1) !=0){
                ans = ans * a;
            }
            a = a*a;
            n = n >> 1;
        }
        return ans;
    }
    public static int modExpo(int a, int b, int m){
        int ans = 1;
        while(b>0){
            if((b&1) !=0){
                ans = ans * a;
            }
            a = a*a;
            b = b >> 1;
        }
        return ans%m;
     
    }
    public static void main(String args[]){
         System.out.println(modExpo(23,3,30));
    }
}

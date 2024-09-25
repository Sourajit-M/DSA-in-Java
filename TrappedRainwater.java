public class TrappedRainwater {
    
    public static int trappedwater(int height[]){
        int len = height.length;
        //auxilary array to find max boundary
        int LeftMax[] = new int [len];
        int rightMax[] = new int [len];

        LeftMax[0] = height[0];
        rightMax[len-1] = height[len-1];

        for(int i=1; i<len; i++){
            //Left max boundary of each bar 
            LeftMax[i] = Math.max(height[i], LeftMax[i-1]);
        }
        
        for(int i=len-2; i>=0; i--){
            //right max boundary of each bar
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappdwater = 0;
        int waterlevel = 0;
        for(int i=0; i<len; i++){
          waterlevel = Math.min(LeftMax[i], rightMax[i]);
          // trapped water level
          trappdwater += (waterlevel - height[i]);
        }
          return trappdwater;
    }

    public static boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int)Math.sqrt(c);

        while(start <= end){
            long sum = start^2 + end^2;
            if(sum == c){
                return true;
            }else if(sum > c){
                end--;
            }else{
                start++;
            }
        }

        return false;
    }

    public static void main(String args[]){
    //    int height[] = {4, 2, 0, 6, 3, 2, 5};
    //     System.out.println(trappedwater(height));

    System.out.println(judgeSquareSum(5));
    }
}

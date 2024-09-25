import java.util.ArrayList;
public class ArrayL{

    public static void SWAP(ArrayList<Integer> list, int idx1, int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    public static int MaxWater(ArrayList<Integer> height){ //0(n^2)
        int maxW = 0;
        int h,w,water;
        for(int i=0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                h = Math.min(height.get(i), height.get(j));
                w = j-i;
                water = h*w;
                if(maxW < water){
                    maxW = water;
                }
            }
        }
        return maxW;
    }

    public static int storedWater(ArrayList<Integer> height){ //0(n)
        int Left_pt=0, Right_pt=height.size()-1;
        int maxWater=0;
        while(Left_pt != Right_pt){
            int h = Math.min(height.get(Left_pt), height.get(Right_pt));
            int w = Right_pt-Left_pt;
            int currW = h*w;
            maxWater = Math.max(maxWater, currW);
            if(height.get(Left_pt)<height.get(Right_pt)){ //As smaller bar controls the area of water
                Left_pt++;
            }
            else{
                Right_pt--;
            }
        }
        return maxWater;
    }
   
    //only works on sorted ArrayList 0(n) else brute force 0(n^2)
    public static boolean pair_Sum(ArrayList<Integer> list, int target){
        int Lt=0, Rt=list.size()-1;
        while(Lt<Rt){
            if(list.get(Lt)+list.get(Rt) == target){
                return true;
            }

            else if(list.get(Lt)+list.get(Rt) < target){
                Rt--;
            }
            else{
                Lt++;
            }
        }
        return false;
    }
    
    //sorted and rotated arrayList
    public static boolean pair_sum2(ArrayList<Integer> list, int target){
        //finding breaking point
        int i=0;
        while(list.get(i)<list.get(i+1)){
            i++; //breaking sorted point 
        }
        int n = list.size();

        int Rt=i, Lt=i+1;
        while(Lt!=Rt){
            if(list.get(Lt)+list.get(Rt) == target){
                return true;
            }
            else if(list.get(Lt)+list.get(Rt) > target){
                Rt = (n+Rt-1)%n;
            }
            else{
                Lt = (Lt+1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11); list.add(15);list.add(6);list.add(8);list.add(9);list.add(10);

        //Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        System.out.println(pair_sum2(list, 16));
        
    }
}
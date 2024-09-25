import java.util.*;
public class ArrayLQ{

    public static boolean isMonotonic(ArrayList<Integer> al){
        boolean k = al.get(0) < al.get(1) ? true : false;
            for(int i=1; i<al.size()-1; i++){
                if(k){//increasing
                    if(al.get(i) > al.get(i+1)){
                        return false;
                    }
                }
                else{//decreasing
                    if(al.get(i) < al.get(i+1)){
                        return false;
                    }
                }
            }
            return true;
    }

    public static ArrayList<Integer> isLonely(ArrayList<Integer> al){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<al.size(); i++){
            int curr = al.get(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

       for(int i=0; i<al.size(); i++){
        int c = al.get(i);
        if(map.get(c)!=1 || map.containsKey(c-1) || map.containsKey(c+1)){
            continue;
        }
        else{
            list.add(c);
        }
       }
        return list;
    }

    public static void mostFreqfollowingKey(ArrayList<Integer> nums, int key){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.size()-1; i++){
            if(i == key){
                map.put(nums.get(i+1), map.getOrDefault(nums.get(i+1), 0)+1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1); al.add(3); al.add(5); al.add(3);
        System.out.println(isLonely(al));
    }
}
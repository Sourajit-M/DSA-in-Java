import java.util.*;
public class HashMapCode_2 {

    public static void majorityElm(int nums[], HashMap<Integer, Integer> map){
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if(map.get(key) > nums.length/3){
                System.out.println(key);
            }
        }
    }

    public static boolean validAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if(map.get(ch) != null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) - 1);
                }
            }else{
                return false;
            }
        }

       return map.isEmpty();
    } 

    public static int countDistinctElem(int[] nums){
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }

        return hs.size();
    }

    public static void unionAndIntersection(int[] arr1, int[] arr2){
        TreeSet<Integer> un = new TreeSet<>();
        TreeSet<Integer> inter = new TreeSet<>();

        for(int i=0; i<arr1.length; i++){
            un.add(arr1[i]);
            inter.add(arr1[i]);
        }

        int count=0;
        for(int i=0; i<arr2.length; i++){
            un.add(arr2[i]);
            if(inter.contains(arr2[i])){
                count++;
                inter.remove(arr2[i]);
            }
        }

        System.out.println("Union = "+un.size());
        System.out.println("Intersection = "+count);
    }

    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for (String key : tickets.keySet()) {
            if(!revMap.containsKey(key))
            return key;
        }
        return null;
    }

    public static void itrTickets(HashMap<String, String> tickets){
        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print(" -> "+tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }

    public static int largestSum0(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int len= 0;
        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            }else{
                map.put(sum, j);
            }
        }
        return len;
    }

    public static void subArrayEqToK(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println("Number of SubArrays Equal To K = "+ans);
    }

    public static void main(String[] args) {
      int arr[] = {10, 2, -2, -20, 10};
      subArrayEqToK(arr, -10);
    }
}

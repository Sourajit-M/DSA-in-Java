public class Kadane {

    public static int NegKadane(int arr[]){
        int max_so_far      = Integer.MIN_VALUE;
        int max_ending_here = 0;
        int max_element     = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++){
       max_ending_here = Math.max(max_ending_here + arr[i], 0);
       max_so_far      = Math.max(max_ending_here, max_so_far);
       max_element     = Math.max(max_element, arr[i]);
    }

    if (max_so_far == 0){
      max_so_far = max_element;
    }

    return max_so_far;
}


    public static int kadane(int arr[]){
        int current_max = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            current_max += arr[i];
            if(current_max < 0){
                current_max = 0;
            }
            max_sum = Math.max(current_max, max_sum);
        }
        return max_sum;
    }

    public static void main(String args[]){
       int arr[] = {2, 4, 6, 8, 10};
       System.out.println(kadane(arr));
    }
}

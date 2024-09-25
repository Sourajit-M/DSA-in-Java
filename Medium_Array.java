public class Medium_Array {
    public static void rotate(int[] nums, int k) {
       
        int n = nums.length;
        k = k%n;
        int list[] = new int[k];
        for(int i=n-k; i<n; i++){
            list[i-(n-k)] = nums[i];
        }


        int a=k;
        for(int i=n-1; i>=k; i--){
            nums[i] = nums[a];
            a--;
        }
        
        for(int i=0; i<k; i++){
            nums[i] = list[i];
        }


    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};

        rotate(arr, 3);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

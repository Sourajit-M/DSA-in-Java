public class Easy_Array {

    public static int second_Largest_Elem(int arr[]){
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                secMax = max;
                max = arr[i];
            }else if(arr[i]>secMax && arr[i]!=max){
                secMax = arr[i];
            }
        }

        return secMax;
    }
    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 5, 7, 9, 1, 3};
        System.out.println("Second Largest Element of the array is : "+second_Largest_Elem(arr));
    }
}

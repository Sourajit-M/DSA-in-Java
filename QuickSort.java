public class QuickSort {
    public static int partition(int arr[], int low, int high){
        int i=low;
        int j=high;

        int pivot = low;

        while(i<j){
            while(arr[i]<=arr[pivot] && i<high){
                i++;
            }

            while(arr[j]>arr[pivot] && j>low){
                j--;
            }

            if(i<j){
                swap(arr, i, j);
            }
        }

        swap(arr, pivot, j);

        return j;

    }


    public static void quickSort(int arr[], int low, int high){
        if(low < high){
            int pIndex = partition(arr, low, high);
            quickSort(arr,  low, pIndex-1);
            quickSort(arr, pIndex+1, high);
        }
    }

    public static void swap(int arr[], int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    public static void main(String[] args) {
        int arr[] = {4, 6, 2, 5, 7, 9, 1, 3};
        // int arr[] = {1, 0, 2};

        quickSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

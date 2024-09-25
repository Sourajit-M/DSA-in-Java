public class DivideAndC{
    
       public static void print_arr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si; //iterator for left part
        int j = mid+1; //iterator for right part
        int k = 0; //iterator for temp array

        while( i <= mid && j <= ei){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        // remaining left part
        while(i<=mid){
            temp[k++] = arr[i++];
        }
       // remaining right part
        while(j<=ei){
            temp[k++] = arr[j++];
        }

        //copy temp array to original array
        for(k=0,i=si; k<temp.length; k++,i++){
            arr[i] = temp[k];
        }
    }

    public static void quickSort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int pIdx = partiton(arr, si, ei);
        quickSort(arr, 0, pIdx-1);//left part
        quickSort(arr, pIdx+1, ei);//right part
    }

    public static int partiton(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
        for(int j=si; j<arr.length; j++){
            if(arr[j]<pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }
    

    public static int searchTarget(int arr[], int target, int si, int ei){
        if(si > ei){
            return -1;
        }
        
        int mid = si + (ei-si)/2;
        if(arr[mid] == target){
            return mid;
        }

        //mid on Line 1
        if(arr[si] <= arr[mid]){
            //case 1 : left
        if(arr[si] <= target && target <= arr[mid]){
            return searchTarget(arr, target, si, mid-1);
        }
        // case 2: right
        else{
        return searchTarget(arr, target, mid+1, ei);

        }
    }
    // mid on line 2
    else{
        // case 3: right
        if(arr[mid] <= target && target <= arr[ei]){
            return searchTarget(arr, target, mid+1, ei);
        }
        //case 4: left
        else{
            return searchTarget(arr, target, si, mid-1);
        }
    }

    }
    public static void main(String args[]){
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int Tidx = searchTarget(arr, 0, 0, arr.length-1);
        System.out.println(Tidx);
    }
}
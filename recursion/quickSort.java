public class quickSort {

    public static void quicksort(int arr[], int si, int ei){
        if(si>=ei){
            return;
        }
        int pidx=partition(arr, si, ei);
        quicksort(arr, si, pidx-1);
        quicksort(arr, pidx+1, ei);
    }

    public static int partition(int arr[], int si, int ei){
        int i=si-1;
        int pivot=arr[ei];
        int temp=0;
        for(int j=si; j<arr.length; j++){
            if(arr[j]<pivot){
                i++;
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;

        return i;
    }
    public static void main(String[] args) {
        int arr[]={12,4,333,111,69,2};
        quicksort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++){

            System.out.print(arr[i] + " ");
        }
    }
}

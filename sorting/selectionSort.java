public class selectionSort{
    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minpos=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[minpos]>arr[j]){
                    minpos=j;
                }
            }
            int temp=arr[minpos];
            arr[minpos]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String args[]){
        int []arr={1,22,33,24,15};
        selectionSort(arr);
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
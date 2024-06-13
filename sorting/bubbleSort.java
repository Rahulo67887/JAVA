public class bubbleSort{
    public static void bubbleSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            boolean swapped=false;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void main(String args[]){
        int []arr={1,2,3,4,5};
        bubbleSort(arr);
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
public class cycleSort{
    public static void cycleSort(int arr[]){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }
            else{
                i++;
            }
        }
    }

    public static void main(String args[]){
        int []arr={3,4,2,6,1,5};
        cycleSort(arr);
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
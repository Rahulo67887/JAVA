

public class occurences {
    public static void occurence(int []arr, int key, int i){
        if(i==arr.length){
            return;
        }else{
            if(arr[i]==key){
                System.out.print(i + " ");
                occurence(arr, key, i+1);
            }else{
                occurence(arr, key, i+1);
            }
        }
    }

    public static void main(String args[]){
        int arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key=2;
        occurence(arr, key, 0);
    }
}

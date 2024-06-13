import java.util.*;

public class occurReference{
    public static void occur(int arr[], int key, int i){
        if(i==arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i + " ");
        }
        occur(arr, key, i+1);
    }

    public static void main(String args[]){
        int arr[]={1,43,3,5,2,66,3,6,3,8,3};
        occur(arr,3,0);
    }
}
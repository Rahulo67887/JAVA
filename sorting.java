import java.util.*;

public class sorting {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            System.out.print(arr[i] + "  ");
        }
    }

    public static void countingSort(int arr[]){
        int largest= Integer.MIN_VALUE; 
        for(int i=0; i<arr.length; i++){
            largest=Math.max(arr[i], largest);
        }
        int count[]=new int[largest+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
        printArray(arr);
    }

    public static void bubbleSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        printArray(arr);
    }

    public static void selectionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int minPos=i;
            for(int j=i+1; j<arr.length-1; j++){
                if(arr[minPos]>arr[j]){
                    minPos=j;
                }
            }
            if(minPos!=i){
                int temp=arr[i];
                arr[i]=arr[minPos];
                arr[minPos]=temp;
            }
        }
        printArray(arr);
    }

    public static void insertionSort(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            int curr=arr[i];
            int prev=i-1;
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
        printArray(arr);
    }

    public static void main(String args[]){
        int arr[]={5,4,67,3,2,89,9};
        System.out.println("Press:\n" + "1 for bubble sort\n" + 
        "2 for selection sort\n" +
        "3 for insertion sort\n" +
        "4 for counting sort");
        
        Scanner sc= new Scanner(System.in);
        int choice=sc.nextInt();

        switch(choice){
            case 1:
                bubbleSort(arr);
                break;
            case 2:
                selectionSort(arr);
                break;
            case 3:
                insertionSort(arr);
                break;
            case 4:
                countingSort(arr);
                break;
            default:
                System.out.print("Enter a valid input!");
        }
    }
}

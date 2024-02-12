import java.util.*;

    
public class getLarestSmallest {
    public static void printArray(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            System.out.print(arr[i] + "  ");
        }
    }
    public static void getLargest(int arr[]){
        int largest= Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        System.out.println("The largest element is " + largest);
    }

    public static void getSmallest(int arr[]){
        int smallest= Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<smallest){
                smallest=arr[i];
            }
        }
        System.out.println("The smallest element is " + smallest);
    }

    public static void reverse(int arr[]){
        int left=0, right=arr.length-1, temp;
        while(left<right){
            temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
        printArray(arr);
    }

    public static void pairs(int arr[]){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                System.out.print("("+arr[i]+","+arr[j]+") ,  ");
            }
            System.out.println();
        }
    }

    public static void maxSubarrayPrefix(int arr[]){
        int currsum=0, maxSum=Integer.MIN_VALUE;
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                currsum = i==0 ? prefix[j] : prefix[j]-prefix[i-1];
                if(currsum>maxSum){
                    maxSum=currsum;
                }
            }
        }
        System.out.println("The maximum sum is " + maxSum);
    }

    public static void maxSubarrayKadane(int arr[]){
        int currsum=0, maxSum=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            currsum+=arr[i];
            if(currsum<0){
                currsum=0;
            }
            if(currsum>maxSum){
                maxSum=currsum;
            }
        }
        System.out.println("The maximum sum is " + maxSum);
    }

    public static void main(String args[]){
        int arr[]={1,2,3,4,33,4,5};
        System.out.print("Press:\n" + "1 to get largest element in the array\n" + 
        "2 to get smallest element in the array\n" +
        "3 to get reverse of the array\n" +
        "4 to get pairs of the element of array\n" +
        "6 to get sum of sub array by prefix method\n" +
        "7 to get sum of sub array by kadane method\n");

        Scanner sc= new Scanner(System.in);
        int choice=sc.nextInt();

        switch(choice){
            case 1:
                getLargest(arr);
                break;
            case 2:
                getSmallest(arr);
                break;
            case 3:
                reverse(arr);
                break;
            case 4:
                pairs(arr);
                break;
            case 5:
                maxSubarrayPrefix(arr);
                break;
            case 6:
                maxSubarrayKadane(arr);
                break;
            default:
                System.out.print("Enter a valid input!");
        }
    }
}




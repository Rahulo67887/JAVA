public class target {
    public static int minSearch(int num[]){
        int left=0, right=num.length-1;
        while(left<right){
            int mid= left + (right-left)/2;
            if(mid>0 && num[mid-1]>num[mid]){
                return mid;
            }else if(num[mid]>=num[left] && num[mid]>num[right]){
               left=mid+1;
            }else{
               right=mid-1;
            }
        }
        return left;
    }

    public static int search(int num[], int target){
        int min=minSearch(num);

        if(num[min]<=target && num[num.length-1]>=target){
            return search(num, min, num.length-1, target);
        }else{
            return search(num, 0, min, target);
        }
    }

    public static int search(int num[], int left, int right, int target){
        int l=left;
        int r=right;
        while(l<=r){
            int mid=left + (r-l)/2;
            if(target==num[mid]){
                return mid;
            }else if(num[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int num[]={4,5,6,7,8,1,2,3};
        int found=search(num, 6);
        if(found==-1){
            System.out.println("Element not present");
        }else{
            System.out.println("Element found at index " + found);
        }
    }
}

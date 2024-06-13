public class rough{

    public static int mergesort(int arr[], int si, int ei){
        int inv=0;

        if(si<ei){
            int mid=si+(ei-si)/2;
            inv=mergesort(arr, si, mid);
            inv+=mergesort(arr, mid+1, ei);
            inv+=merge(arr, si, mid, ei);
        }

        return inv;
    }

    public static int merge(int arr[], int si, int mid, int ei){
        int inv=0;
        int temp[]=new int[ei-si+1];
        int k=0;
        int i=si;
        int j=mid+1;

        while(i<=mid && j<=ei){
            if(arr[i]>arr[j]){
                temp[k++]=arr[i++];
            }else{
                inv+=(mid-i);
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i]=temp[k];
        }

        return inv;
    }

    public static int getInversions(int arr[]) {
        return mergesort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int arr[]={2,4,1,3,5};
        
        System.out.println(getInversions(arr));
    }
}
public class stringMergeSort {

    public static void mergeSort(String []str, int si, int ei){
        if(si>=ei){
            return;
        }

        int mid=si+(ei-si)/2;
        mergeSort(str, si, mid);
        mergeSort(str, mid+1, ei);
        merge(str, si, mid, ei);
    }

    public static void merge(String []str, int si, int mid, int ei){
        String []temp=new String[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(checkString(str[i], str[j])){
                temp[k++]=str[i++];
            }else{
                temp[k++]=str[j++];
            }
        }

        while(i<=mid){
            temp[k++]=str[i++];
        }

        while(j<=ei){
            temp[k++]=str[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++){
            str[i]=temp[k];
        }
    }

    public static boolean checkString(String str1, String str2){
        if(str1.compareTo(str2)<0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String []arr = { "sun", "earth", "mars", "mercury" };
        mergeSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; i++){

            System.out.print(arr[i] + " ");
        }
    }
}

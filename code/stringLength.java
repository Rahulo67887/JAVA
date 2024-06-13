public class stringLength {
    static int count=0;

    public static int countLength(String str, int i){
        if(i==str.length()){
            return count;
        }
        count++;
        count=countLength(str, i+1);
        return count;
    }
    
    public static void main(String args[]){
        String str="abcde ghih";
        System.out.print(countLength(str, 0));
    }
}

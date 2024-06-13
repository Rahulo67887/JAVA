public class bits {
    public static boolean ODDorEVEN(int n){
        if((n&1)==0){
            return true;
        }else{
            return false;
        }
    }

    public static int getITH(int n, int i){
        if((n&(1<<i))==0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int setITH(int n, int i){
        return n|(1<<i);
    }

    public static int clear(int n, int i){
       return n&(~(1<<i));
    }

    public static void main(String args[]){
        // if(ODDorEVEN(13)){
        //     System.out.println("It is a even number");
        // }else{
        //     System.out.println("It is a odd number");
        // }

        System.out.println(clear(10,1));
    }
    
}
public class uppercase {

    public static String uppercase(String str){
        StringBuilder sb=new StringBuilder(" ");

        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length(); i++){
            if(i<str.length()-1 && str.charAt(i)==' '){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String args[]){
        String str="Hi i am rahul";
        System.out.print(uppercase(str));

    }
    
}

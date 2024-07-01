public class subsets {

    public static void subsets(String str, StringBuilder ans, int i){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        subsets(str, ans.append(str.charAt(i)), i+1);
        ans.deleteCharAt(ans.length()-1);
        subsets(str, ans, i+1);

    }
    public static void main(String[] args) {
        subsets("ab", new StringBuilder(""), 0);
    }
}

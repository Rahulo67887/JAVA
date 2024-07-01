public class peermutations {

    public static void findpermutations(String str, StringBuilder ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i<str.length(); i++){
            findpermutations(str.substring(0, i)+str.substring(i+1), ans.append(str.charAt(i)));
            ans.deleteCharAt(ans.length()-1);
        }
        
    }
    public static void main(String[] args) {
        findpermutations("abc", new StringBuilder(""));
    }
}

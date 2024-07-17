import java.util.*;

public class Coins {
    public static void main(String[] args) {
        Integer coins[]={1,2,5,10,15,20,50,500,2000};

        Arrays.sort(coins, Comparator.reverseOrder());
        int amount=500;
        ArrayList<Integer> ans=new ArrayList<>();
        int countOFcoins=0;

        int i=0;
        while(amount>0 && i<coins.length){
            while(coins[i]<=amount){
                amount-=coins[i];
                countOFcoins++;
                ans.add(coins[i]);
            }
            i++;
        }

        System.out.println("Total coins used : " + countOFcoins);
        for(int j=0; j<ans.size(); j++){
            System.out.print(ans.get(j) + " ");
        }
    }
}

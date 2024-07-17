public class buysellStock {

    public static int profit(int prices[]){
        int buy=prices[0];
        int profit=0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]<buy){
                buy=prices[i];
            }
            else if(prices[i]-buy>profit){
                profit=prices[i]-buy;
            }
        }
        return profit;
    }
    
    public static void main(String[] args) {
        int price[]={7,1,5,3,6,4};
        System.out.println(profit(price));
    }

}

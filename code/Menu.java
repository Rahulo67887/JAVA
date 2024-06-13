public class Menu {
    
    public static int findDish(String menu[], String dish){
        for(int i=0; i<menu.length; i++){
            if(menu[i]==dish){
                return 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        String menu[]={"Samosa", "Puri", "Chole Bhature", "Rice", "Pizza", "Burger"};
        String food="Chole Bhature";
        if(findDish(menu, food)==1){
            System.out.print(food + " available");
        }else{
            System.out.print(food + " not available");
        }
    }
}

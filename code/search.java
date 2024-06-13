public class search {
    public static boolean search(int mat[][], int key){
        int row=mat.length-1,col=0;
        while(row>0 && col<mat[0].length-1){
            if(key==mat[row][col]){
                System.out.print("Element found at index (" + row +"," + col + ")");
                return true;
            }
            else if(key>mat[row][col]){
                col++;
            }
            else{
                row--;
            }
        }
        System.out.print("Element don't exit in the matrix");
        return false;
    }

    public static void main(String args[]){
        int mat[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        search(mat, 11);
    }
}

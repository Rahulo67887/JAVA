public class Nqueens {

    public static boolean isSafe(char chess[][], int row, int col){
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1, j=col+1; i>=0 && j>chess.length; i--, j++){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1; i>=0 ; i--){
            if(chess[i][col]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void queenSol(char chess[][], int row){
        if(row==chess.length){
            print(chess);
            return;
        }

        for(int i=0; i<chess.length; i++){
            if(isSafe(chess, row, i)){
                chess[row][i]='Q';
                queenSol(chess, row+1);
                chess[row][i]='X';
            }
        }
    }

    public static void print(char chess[][]){
        System.out.println("--------------Chess board--------------");
        for(int i=0; i<chess.length; i++){
            for(int j=0; j<chess.length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int n=4;
        char chess[][]=new char[n][n];
        for(int i=0; i<chess.length; i++){
            for(int j=0; j<chess.length; j++){
                chess[i][j]='X';
            }
        }
        queenSol(chess, 0);
    }
}

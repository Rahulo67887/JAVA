class nKnights{

    public static void solveKT(int [][]chess, int row, int col){
        chess[0][0]=1;
        if(!nknights(chess, row, col, 2)){
            System.out.println("Solution does not exist");
        }else{
            print(chess);
        }
    }

    public static boolean nknights(int[][] chess, int row, int col, int knights){
        int[] rowMoves = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

        if (knights == chess.length * chess.length + 1) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nextRow = row + rowMoves[i];
            int nextCol = col + colMoves[i];
            if (isValid(chess, nextRow, nextCol) && chess[nextRow][nextCol] == 0) {
                chess[nextRow][nextCol] = knights;
                if (nknights(chess, nextRow, nextCol, knights + 1)) {
                    return true;
                } else {
                    chess[nextRow][nextCol] = 0; // Backtrack
                }
            }
        }

        return false;
    }

    static boolean isValid(int[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }

    public static void print(int chess[][]){
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
        int n=6;
        int chess[][]=new int[n][n];
        for(int i=0; i<chess.length; i++){
            for(int j=0; j<chess.length; j++){
                chess[i][j]=0;
            }
        }
        solveKT(chess, 0, 0);
    }
}
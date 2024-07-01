public class ratpath {

    public static boolean paths(int maze[][], int path[][], int row, int col, int n){
        if(row==n-1 && col==n-1 && maze[row][col]==1){
            path[row][col]=1;
            return true;
        }

        if(row>=0 && row<n && col>=0 && col<n && maze[row][col]==1 && path[row][col]==0){
            path[row][col]=1;

            if(paths(maze, path, row+1, col, n)){
                return true;
            }
         
            if(paths(maze, path, row, col+1, n)){
                return true;
            }
           
            if(paths(maze, path, row-1, col, n)){
                return true;
            }
             
            if(paths(maze, path, row, col-1, n)){
                return true;
            }

            path[row][col]=0;
        }
        return false;
    }

    public static void main(String[] args) {
        int n=5;
        int maze[][]={
            {1,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,0,1},
            {0,0,0,0,1},
            {1,1,1,0,1},
        };
        int ans[][]={
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };
        if(paths(maze, ans, 0, 0, n)){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(ans[i][j]+ " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Solution does not exit");
        }
    }
}

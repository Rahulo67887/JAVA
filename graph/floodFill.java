public class floodFill {
    public static void floodfill(int image[][], int sc, int sr, int color){
        boolean vis[][]=new boolean[image.length][image[0].length];
        helper(image, sc, sr, color, vis, image[sr][sc]);
        print(image);;
    }

    public static void helper(int image[][], int sc, int sr, int color, boolean vis[][],int orgcolor){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=orgcolor){
            return;
        }
        
        image[sr][sc]=color;
        vis[sr][sc]=true;

        helper(image, sc, sr-1, color, vis, orgcolor);
        helper(image, sc, sr+1, color, vis, orgcolor);
        helper(image, sc-1, sr, color, vis, orgcolor);
        helper(image, sc+1, sr, color, vis, orgcolor);
    }

    
    public static void print(int image[][]){
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[i].length; j++){
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int image[][]={{1,1,1},
                        {1,1,0},
                        {1,0,1}};

        floodfill(image, 1, 1, 2);
    }
}

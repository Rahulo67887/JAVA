public class spiralMatrix {
    public static void printSpiral(int arr[][]){
        int startCol=0;
        int startRow=0;
        int endCol=arr[0].length-1;
        int endRow=arr.length-1;

        while(startRow<=endRow && startCol<=endCol){
            for(int i=startCol; i<=endCol; i++){
                System.out.print(arr[startRow][i] + "  ");
            }
            for(int j=startRow+1; j<=endRow; j++){
                System.out.print(arr[j][endCol] + "  ");
            }
            for(int j=endCol-1; j>=startCol; j--){
                if(startRow==endRow){
                    break;
                }
                System.out.print(arr[endRow][j] + "  ");
            }
            for(int i=endRow-1; i>=startRow+1; i--){
                if(startCol==endCol){
                    break;
                }
                System.out.print(arr[i][startCol] + "  ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static void printArray(int arr[]){
        for(int i=0; i<arr.length-1; i++){
            System.out.print(arr[i] + "  ");
        }
    }

    public static void main(String args[]){
        int arr[][]={{1,2,3,4},
        {5,6,7,8},
        {9,10,11,12}

        };
        printSpiral(arr);
    }
}

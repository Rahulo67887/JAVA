public class grids {
    static int count=0;

    public static void ways(int i, int j, int n, int m){
        if(i==n-1 && j==m-1){
            count++;
            return;
        }
        if(i==n || j==m){
            return;
        }

        ways(i+1, j, n, m);
        ways(i, j+1, n, m);
    }

    public static void main(String[] args) {
        ways(0, 0, 3, 3);
        System.out.println(count + " ways");
    }
}

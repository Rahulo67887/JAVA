import java.util.*;

public class rottingOranges {

    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int R=3;
    static int C=5;

    public static boolean isValid(int i, int j){
        return (i>=0 && i<R && j>=0 && j<C);
    }

    public static boolean delim(Node temp){
        return temp.x==-1 && temp.y==-1;
    }

    public static boolean checkAll(int arr[][]){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j]==1)
                    return true;
            }
        }
        return false;
    }

    public static int rotOranges(int arr[][]){
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j]==2){
                    q.add(new Node(i,j));
                }
            }
        }
        q.add(new Node(-1, -1));

        Node temp;
        int ans=0;

        while(!q.isEmpty()){
            boolean flag = false;

            while(!delim(q.peek())){
                temp=q.remove();
                
                if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y]==1){
                    if(!flag){
                        ans++;
                        flag=true;
                    }
                    arr[temp.x+1][temp.y]=2;
                    q.add(new Node(temp.x+1, temp.y));
                }

                if(isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y]==1){
                    if(!flag){
                        ans++;
                        flag=true;
                    }
                    arr[temp.x-1][temp.y]=2;
                    q.add(new Node(temp.x-1, temp.y));
                }

                if(isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1]==1){
                    if(!flag){
                        ans++;
                        flag=true;
                    }
                    arr[temp.x][temp.y+1]=2;
                    q.add(new Node(temp.x, temp.y+1));
                }
                
                if(isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1]==1){
                    if(!flag){
                        ans++;
                        flag=true;
                    }
                    arr[temp.x][temp.y-1]=2;
                    q.add(new Node(temp.x, temp.y-1));
                }
            }

            q.remove();
            if(!q.isEmpty()){
                q.add(new Node(-1, -1));
            }
        }

        return (checkAll(arr) ? -1 : ans);
        
    }
    
    public static void main(String[] args)
    {
        int arr[][] = { { 2, 1, 0, 2, 1 },
                        { 1, 0, 1, 2, 1 },
                        { 1, 0, 0, 2, 1 } 
                    };

        int ans = rotOranges(arr);
        if (ans == -1){
            System.out.println("All oranges cannot rot");
        }
        else{
            System.out.println("Time required for all oranges to rot => "+ ans);
        } 
    }
}



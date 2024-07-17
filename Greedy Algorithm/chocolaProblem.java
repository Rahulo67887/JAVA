import java.util.*;

public class chocolaProblem {
    
    public static void main(String[] args) {
        int m=6, n=4;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0, v=0;
        int hp=1, vp=1;
        int cost=0;

        while(h<costHor.length && v<costVer.length){
            if(costVer[v]<=costHor[h]){
                cost+=(vp*costHor[h]);
                h++;
                hp++;
            }
            else{
                cost+=(hp*costVer[v]);
                v++;
                vp++;
            }
        }

        while(v<costVer.length){
            cost+=(hp*costVer[v]);
            v++;
            vp++;
        }

        while(h<costHor.length){
            cost+=(vp*costHor[h]);
            h++;
            hp++;
        }

        System.out.println(cost);
    }

}

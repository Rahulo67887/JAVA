import java.util.*;

public class Implementation{

    static class HashMap<K, V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> bucket[];

        @SuppressWarnings("unchecked")
    
        public HashMap(){
            this.N = 4;
            this.bucket=new LinkedList[4];
            for(int i=0; i<4; i++){
                this.bucket[i] = new LinkedList<>();
            }
        }

        public int hashFunction(K key){
            int hc=key.hashCode();
            return Math.abs(hc)%N;
        }

        public int SearchinLL(K key, int bi){
            LinkedList<Node> ll=bucket[bi];
            int di=0;

            for(int i=0; i<ll.size(); i++){
                Node node=ll.get(i);
                if(node.key==key){
                    return i;
                }
                di++;
            }

            return -1;
        }

        public void put(K key, V value){
            int bi=hashFunction(key);
            int di=SearchinLL(key, bi);

            if(di!=-1){
                Node node=bucket[bi].get(di);
                node.value=value;
            }
            else{
                bucket[bi].add(new Node (key, value));
                n++;
            }

            double lambda=(double)n/N;
            if(lambda>2.0){
                rehash();
            }
        }

        @SuppressWarnings("unchecked")
        public void rehash(){
            LinkedList<Node> oldbucket[]=bucket;
            bucket=new LinkedList[N*2];
            N=N*2;

            for(int i=0; i<bucket.length; i++){
                this.bucket[i] = new LinkedList<>();
            }

            for(int i=0; i<oldbucket.length; i++){
                LinkedList<Node> ll=oldbucket[i];

                for(int j=0; j<ll.size(); j++){
                    Node node=ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public boolean containkey(K key){
            int bi=hashFunction(key);
            int di=SearchinLL(key, bi);

            if(di!=-1){
                return true;
            }
            else{
                return false;
            }
        }

        public V get(K key){
            int bi=hashFunction(key);
            int di=SearchinLL(key, bi);

            if(di!=-1){
                Node node=bucket[bi].get(di);
                return node.value;
            }
            else{
                return null;
            }
        }

        public V remove(K key){
            int bi=hashFunction(key);
            int di=SearchinLL(key, bi);

            if(di!=-1){
                Node node=bucket[bi].remove(di);
                n--;
                return node.value;
            }
            else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys=new ArrayList<>();

            for(int i=0; i<bucket.length; i++){
                LinkedList<Node> ll=bucket[i];

                for(Node node : ll){
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map=new HashMap<>();

        map.put("India", 100);
        map.put("America", 30);
        map.put("dubai", 86);

        System.out.print(map.get("India"));
        System.out.print(map.remove("India"));
        System.out.print(map.get("India"));
        ArrayList<String> keys=map.keySet();
        for(String key : keys){
            System.out.print(key + " ");
        }
    }

}
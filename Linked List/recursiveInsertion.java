public class recursiveInsertion extends linkedlist{

    public static void recInsertion(int idx, int val){
        head=recInsertion(idx, val, head);
    }

    public static Node recInsertion(int idx, int val, Node node){
        if(idx==0){
            Node temp=new Node(val);
            temp.next=node;
            return temp;
        }

        node.next=recInsertion(--idx, val, node.next);
        return node;
    }
    

    public static void main(String[] args) {
        linkedlist ll=new linkedlist();
        ll.addfirst(12);
        ll.addfirst(2);
        ll.addfirst(11);
        ll.addfirst(120);
        ll.addfirst(122);

        ll.print(head);
        recInsertion(2, 33);
        ll.print(head);
    }
}

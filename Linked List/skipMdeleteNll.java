public class skipMdeleteNll extends linkedlist{
    public static void skipMdeleteN(int m, int n){
        Node temp=head;
        int i=1;
        while(temp!=null){
            if(i==m){
                Node t=temp;
                for(int j=0; j<n; j++){
                    if(t==null){
                        return;
                    }
                    t=t.next;
                }
                temp.next=t.next;
                i=0;
            }
            temp=temp.next;
            i++;
        }
    }

    public static void main(String[] args) {
        linkedlist ll=new linkedlist();
        skipMdeleteNll LL=new skipMdeleteNll();

        ll.addfirst(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(4);
        ll.addlast(5);
        ll.addlast(6);
        ll.addlast(7);
        ll.addlast(8);
        ll.addlast(9);
        ll.addlast(10);

        ll.print(head);
        skipMdeleteN(3, 2);
        ll.print(head);
    }
}

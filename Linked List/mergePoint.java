public class mergePoint extends linkedlist {

    public static Node getMergepoint(Node head1, Node head2){
        while(head2!=null){
            Node temp=head1;
            while(temp!=null){
                if(temp==head2){
                    return head2;
                }
                temp=temp.next;
            }
            head2=head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        linkedlist ll=new linkedlist();
        mergePoint LL= new mergePoint();

        Node head1=new Node(1);
        head1.next=new Node(2);
        head1.next.next=new Node(3);
        head1.next.next.next=new Node(6);
        head1.next.next.next.next=new Node(7);
        head1.next.next.next.next.next=new Node(8);

        Node head2=new Node(4);
        head2.next=new Node(5);
        //head2.next.next=head1.next.next.next;

        ll.print(head2);
        Node mergingPoint=getMergepoint(head1, head2);
        if(mergingPoint==null){
            System.out.println("Lists don't merge with each other");
        }
        else{
            System.out.println("Merging POint : " + mergingPoint.data);
        }
    }
}

public class zigzagLL extends linkedlist{

    public static void zigzag(){
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node mid=slow;
        Node curr=mid.next;
        mid.next=null;

        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
    

        Node left=head;
        Node right=prev;
        Node nextL, nextR;

        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }
    
    public static void main(String[] args) {
        zigzagLL LL=new zigzagLL();
        linkedlist ll=new linkedlist();
        ll.addfirst(5);
        ll.addfirst(4);
        ll.addfirst(3);
        ll.addfirst(2);
        ll.addfirst(1);
        ll.print(head);
        LL.zigzag();
        ll.print(head);
    }
}

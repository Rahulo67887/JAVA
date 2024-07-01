import java.util.LinkedList;

public class mergesortLL extends linkedlist {

    public static Node getmid(Node head){
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node head1, Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;

        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }

        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }

        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return mergedLL.next;
    }
    
    public static Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=getmid(head);
        Node lefth=head;
        Node righth=mid.next;
        mid.next=null;

        Node newleft=mergeSort(head);
        Node newright=mergeSort(righth);

        return merge(newleft, newright);
    }

    public static void main(String[] args) {
        mergesortLL ll= new mergesortLL();
        linkedlist LL=new linkedlist();
        LL.addlast(5);
        LL.addlast(4);
        LL.addlast(3);
        LL.addlast(2);
        LL.addlast(1);
        LL.print(head);
        LL.head=mergeSort(head);
       LL.print(head);
    }

}

public class CycleinLL extends linkedlist {

    public boolean isCycle(){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }

    public void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean cycle=false;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(fast==slow){
                cycle=true;
                break;
            }
        }

            if(cycle==false){
                System.out.println("Cycle does not exist");
                return;
            }

            slow=head;
            Node prev=null;
            while(slow!=fast){
                prev=fast;
                slow=slow.next;
                fast=fast.next;
            }

            prev.next=null;
            System.out.println("Cycle is removed");

    }

    public static void main(String[] args) {
        CycleinLL ll =new CycleinLL();
        linkedlist LL=new linkedlist();
        head = tail = new Node(45);
        Node temp=new Node(32);
        head.next=temp;
        head.next.next=new Node(33);
        head.next.next.next=temp;
        ll.removeCycle();
        LL.print(head);
    }
    
}

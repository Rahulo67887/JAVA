public class linkedlist {

    public static int size=0;
    
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
            size++;
            // if(head==null){
            //     head=tail=super();
            // }
        }

    }

    public static Node head;
    public static Node tail;

    public void addfirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head=newnode;
    }

    public void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public void addlast(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }

    public void addAt(int idx, int data){
        if(idx==0){
            addfirst(data);
            return;
        }
        int i=0;
        Node temp=head;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        Node newnode=new Node(data);
        newnode.next=temp.next;
        temp.next=newnode;
    }

    public void removefirst(){
        if(size==0){
            System.out.println("Linked List is empty");
        }
        else if(size==1){
            head=tail=null;
            size=0;
        }
        else{
            head=head.next;
            size--;
        }
    }

    public void removelast(){
        if(size==0){
            System.out.println("Linked List is empty");
        }
        else if(size==1){
            head=tail=null;
            size=0;
        }
        else{
            Node prev=head;
            for(int i=0;i<size-2; i++){
                prev=prev.next;
            }
            prev.next=null;
            tail=prev;
            size--;
        }
    }

    public int iterativeSearch(int data){
        Node temp=head;
        int i=0;

        while(temp!=null){
            if(temp.data==data){
                return i;
            }
            temp=temp.next;
            i++;
        }

        return -1;
    }

    public int recursiveSearch(Node h, int key){
        if(head==null){
            return -1;
        }

        if(h.data==key){
            return 0;
        }

        int idx=recursiveSearch(h.next, key);

        if(idx==-1){
            return -1;
        }

        return idx+1;
    }

    public static void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        head=prev;
    }

    public Node mid(Node head){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public boolean ifpallindrome(){
        if(head==null){
            System.out.println("String is Empty");
            return true;
        }
        else if(head.next==null){
            return true;
        }

        Node mid=mid(head);
        Node prev=null;
        Node curr=mid;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node right=prev;
        Node left=head;
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return true;
    }

    public static void main(String args[]){
        linkedlist ll=new linkedlist();
        ll.addfirst(1);
        ll.addlast(2);
        ll.addlast(3);
        ll.addlast(1);
        System.out.println(ll.ifpallindrome());
    }



}

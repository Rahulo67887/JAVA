public class DoubleLL {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            next=null;
            prev=null;
            size++;
        }
    }

        public static Node head =null;
        public static Node tail =null;
        public static int size =0;

        public void addfirst(int data){
            Node newnode= new Node(data);

            if(head==null){
                head=tail=newnode;
                return;
            }

            head.prev=newnode;
            newnode.next=head;
            head=newnode;
        }

        public void addlast(int data){
            Node newnode=new Node(data);
            
            if(head==null){
                head=tail=newnode;
                return;
            }

            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }

        public void removefirst(){
            if(head==null){
                System.out.println("List is empty");
                return;
            }

            if(size==1){
                head=tail=null;
                size--;
                return;
            }

            head.next.prev=null;
            head=head.next;
            size--;
        }

        public void removelast(){
            if(head==null){
                System.out.println("List is empty");
                return;
            }
            if(size==1){
                head=tail=null;
                return;
            }
            tail=tail.prev;
            tail.next=null;
        }

        public static void print(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data + "<->");
                temp=temp.next;
            }
            System.out.println("null");
        }

        public static void main(String[] args) {
            DoubleLL dll =new DoubleLL();
            dll.addfirst(34);
            dll.addfirst(3);
            dll.addfirst(1);
            print();
            dll.removefirst();
            dll.print();
            dll.addlast(45);
            dll.print();
            dll.removelast();
            dll.print();
            
        }
    


}

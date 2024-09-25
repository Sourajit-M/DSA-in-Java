public class Linkedlist_2 {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        
        newNode.next = head;
        head = newNode;
        
    }

    public static void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private static Node getMid(Node head){
    Node slow = head;
    Node fast = head.next;
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
    }

    private static Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
          }
            while(head1!=null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            while(head2!=null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return mergedLL.next;
        }
   
   public static Node mergeSort(Node head){
    //base case
    if(head==null || head.next==null){
        return head;
    }
    //find mid Node
    Node mid = getMid(head);
    Node righthead = mid.next;
    mid.next =null;
    Node newleft = mergeSort(head);
    Node newright = mergeSort(righthead);
    

    return merge(newleft, newright);
   }

   public void zigzag(){
    //find mid node
    Node mid = getMid(head);
   //reverse 2nd half
   Node prev = null;
   Node curr = mid.next;
   mid.next = null;
   Node next;
    while(curr != null){
     next = curr.next;
     curr.next = prev;
     prev = curr;
     curr = next;
   }
   //alternate merging
   Node LH = head;
   Node RH = prev;
   Node nextL, nextR;
   while(LH!=null && RH!=null){
    nextL = LH.next;
    LH.next = RH;
    nextR = RH.next;
    RH.next = nextL;

    RH = nextR;
    LH = nextL;
   }
}

public static void main(String[] args) {
    Linkedlist_2 ll = new Linkedlist_2();
    ll.addFirst(6); ll.addFirst(5); ll.addFirst(4); ll.addFirst(3); ll.addFirst(2); ll.addFirst(1);
    print();
    ll.zigzag();
    print();
}
}

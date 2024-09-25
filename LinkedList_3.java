import java.util.*;

public class LinkedList_3 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    
    public static Node removeNthFromEnd(Node head, int n) {
        if(head == null){
            return null;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        for(int i=0; i<n+1; i++){
            fast = fast.next;
        }
        display(fast);

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        display(slow);

        slow.next = slow.next.next;
        display(dummy.next);
        return dummy.next;
    }

    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        removeNthFromEnd(head, 2);
        display(head);
    }


}

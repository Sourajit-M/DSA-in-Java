public class DoublyLL {
   
    public static class Node{
        int data;
        Node prev;
        Node next;
     
        public Node(int data){
            this.data = data;
            this.prev = null;
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
        head.prev = newNode;
        head = newNode;
        
    }

    public void addlast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public int removeFirst(){
        if(head == null){
            System.out.println("Linklist is empty");
            return -999;
        }
        if(size == 1){
            int val = head.data;
            size--;
            head = tail = null;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast(){
        if(head == null){
            System.out.println("LinkList is empty");
            return -999;
        }
        if(size == 1){
            int val = head.data;
            size--;
            head = tail = null;
            return val;
        }
        Node previous = tail.prev;
        int val = tail.data;
        previous.next = null;
        tail = previous;
        size--;
        return val;
    }
   
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
     DoublyLL dll = new DoublyLL();
     dll.addlast(1); dll.addlast(2); dll.addlast(3);
     dll.print();  
     dll.reverse();
     dll.print();
    }
}

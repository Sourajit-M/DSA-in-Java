public class Linkedlist {

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

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data){
        if(idx == 0){
         addFirst(data);
         return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;

        while(i<idx-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Empty Linkedlist");
            return -999;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("Linkedlist is empty");
            return -999;
        }
        else if(size == 1){
            int val = tail.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //previous node of null (size-2)
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        // now prev is pointing at size-2
        int val = tail.data;
        prev.next = null;  //set previous to null
        tail = prev;//changing tail 
        size--;
        return val;
    }

    public int SearchIt(int key){
        Node temp = head;
        int i = 0;
        while(temp.next != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;   
        }
        return -1;
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        else if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int SearchRec(int key){
        return helper(head, key);
    }
    
    public void reverse(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthfromEnd(int n){
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){ //first element of the LinkList  
            head = head.next;
            return;
        }

        int i=1;
        int iToN = sz-n;
        Node prev = head;
        while(i < iToN){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    //Slow Fast Approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; //slow is mid Node
    }
    
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step 1 find mid node
        Node midNode = findMid(head);

        //step 2 reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //step 3 check if left side = right side
        Node left = head;
        Node right = prev;
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean flag=false;
        //detect cycle
        while(fast.next!=null && fast!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        if(flag == false){
            return;
        }
       //finding last node
        slow = head;
        Node prev = null;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
            prev = fast;
        }
        //last_node.next = null;
        prev.next = null;
    }

    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addLast(1); ll.addLast(2); ll.addLast(2); ll.addLast(1);
        ll.print();
        System.out.println(ll.checkPalindrome());
        
    }
}

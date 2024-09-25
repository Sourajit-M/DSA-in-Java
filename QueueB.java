import java.util.*;
public class QueueB {
    public static void printNonRepeatingCharacter(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void interLeave(Queue<Integer> q){
      Queue<Integer> firstHalf = new LinkedList<>();

      int size = q.size();

      for(int i=0; i<size/2; i++){
        firstHalf.add(q.remove());
      }

      while(!firstHalf.isEmpty()){
        q.add(firstHalf.remove());
        q.add(q.remove());
      }
    } 

    public static void reverse(Queue<Integer> q){
    Stack<Integer> s = new Stack<>();

    while(!q.isEmpty()){
        s.push(q.remove());
    }

    while(!s.isEmpty()){
        q.add(s.pop());
    }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<5; i++){
            q.add(i+1);
        }
        reverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}

public class TriesB {

    static class Node{
        Node children[] = new Node[26];
        boolean endOfWorld = false;
        int freq;
        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            freq = 1;
        }
    }

    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWorld = true;

    }

    public static boolean search(String key){
        Node curr = root;
        for(int level=0; level<key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.endOfWorld;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }

        for(int i=1; i<=key.length(); i++){
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    public static void prefixInsert(String word){
        Node curr = root;
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.freq += curr.freq++;
        }
        curr.endOfWorld = true;
    }

    public static void main(String[] args) {
        String words[] = {"zebra", "dog", "duck", "dove"};

        for(int i=0; i<words.length; i++){
            prefixInsert(words[i]);
        }
    }
}

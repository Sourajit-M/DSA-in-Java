import java.util.*;
public class BST_2 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node createBST(ArrayList<Integer> list, int s, int e){
        if(s > e){
            return null;
        }
        int mid = (s + e)/2;
        Node root = new Node(list.get(mid));
        root.left = createBST(list, s, mid-1);
        root.right = createBST(list, mid+1, e);
        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getInorder(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    public static Node balancedBST(Node root){
        //inorder seq
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list);

        //create Balanced BST
        root = createBST(list, 0, list.size()-1);
        return root;
    }

    static class Info{
        boolean isBST;
        int size;
        int min; 
        int max;
        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        } 
    }

    static int maxBST = 0;
    
    public static Info largestBST(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data<=leftInfo.max || root.data>=rightInfo.min){
            return new Info(false, size, min, max);
        }
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);
    }

    public static Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //merge
        int i=0, j=0;
        ArrayList<Integer> finalArr = new ArrayList<>();

        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) < arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        //sorted list --> BST

        Node root = createBST(finalArr, 0, finalArr.size()-1);
        return root;
    }

    public static void main(String[] args) {
    //BST 1
      Node root1 = new Node(2);
      root1.left = new Node(1);
      root1.right = new Node(4);
    //BST 2
      Node root2 = new Node(9);
      root2.left = new Node(3);
      root2.right = new Node(12);

      Node root = mergeBST(root1, root2);
      preorder(root);
      System.out.println();
    }
}

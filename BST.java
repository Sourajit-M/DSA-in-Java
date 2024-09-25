import java.util.*;
public class BST {
 
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

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static boolean bstSearch(Node root, int key){
        if(root == null){
            return false;
        }   
        if(root.data == key){
            return true;
        }
        else if(root.data > key){
            return bstSearch(root.left, key);
        }else{
            return bstSearch(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else{
            //case 1:leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2: single child
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3: two children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(IS, root.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
   
    public static void printInRange(Node root, int start, int end){
        if(root == null){
            return;
        }
        printInRange(root.left, start, end);
        if(root.data>=start && root.data<end){
            System.out.print(root.data+" ");
        }
        printInRange(root.right, start, end);
    }
    
    public static void rootToLeafPath(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        if(root.left==null && root.right==null){ //leaf Node
            for(int i=0; i<path.size(); i++){
                if(i == path.size()-1){
                    System.out.print(path.get(i));
                }
                else{
                System.out.print(path.get(i)+"->");
                }
            }
            System.out.println();
        }

        rootToLeafPath(root.left, path);
        rootToLeafPath(root.right, path);

        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        else if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidBST(root.left, null, root) && isValidBST(root.right, root, null);
    }

    public static Node mirror(Node root){
        if(root == null){
            return null;
        }

        Node LeftS = mirror(root.left);
        Node RightS = mirror(root.right);

        root.left = RightS;
        root.right = LeftS;

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

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        
        preorder(root);
        System.out.println();

        mirror(root);
        preorder(root);
        System.out.println();
       
    }
}

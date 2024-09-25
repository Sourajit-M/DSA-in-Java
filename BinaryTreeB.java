import java.util.*;
public class BinaryTreeB {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public  Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root == null){
                return;
            }

            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }

        public static void postorder(Node root){
            if(root == null){
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) +1;
    }

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int left_count = countOfNodes(root.left);
        int right_count = countOfNodes(root.right);

        return left_count + right_count + 1;
    }

    public static int sumOfNodes(Node root){ // O(n2)
        if(root == null){
            return 0;
        }

        int left_sum = sumOfNodes(root.left);
        int right_sum = sumOfNodes(root.right);

        return root.data + left_sum + right_sum;
    }

    public static int diameterOfTree_1(Node root){
        if(root == null){
            return 0;
        }

        int left_diam = diameterOfTree_1(root.left);
        int right_diam = diameterOfTree_1(root.right);
        int left_height = height(root.left);
        int right_height = height(root.right);
        
        int self_diam = left_height + right_height + 1;

        return Math.max(self_diam, Math.max(left_diam, right_diam));
    }
    
    static class Info{
        int diam;
        int ht;
        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root){
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);

        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot){
        
        if(node==null && subRoot==null){
            return true;
        }
        else if(node==null || subRoot==null || node.data != subRoot.data){
            return false;
        }
        
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot){
        if(root == null){
            return false;
        }

        if(root.data == subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    static class Information{
        Node node;
        int hd;

        public Information(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
  
    public static void topView(Node root){
        //Level order
        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min=0, max=0;

        q.add(new Information(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Information curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{

                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
    
                if(curr.node.left != null){
                    q.add(new Information(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Information(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
            
        }

        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
      
      /** 
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(6);


        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        topView(root);
    }
}

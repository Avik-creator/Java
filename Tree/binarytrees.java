import java.util.*;
public class binarytrees{
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
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
/* 

    These have time complexity of O(n)
    These are DFS 

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null){
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
*/

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node curNode = q.remove();
            if(curNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curNode.data + " ");
                if(curNode.left != null){
                    q.add(curNode.left);
                }
                if(curNode.right != null){
                    q.add(curNode.right);
                }
            }
        }
    }

   

    public static int countofNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countofNodes(root.left);
        int rightNodes = countofNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumofNodes(Node root){
        if(root == null){
            return 0;
        }

        int leftNodessum = sumofNodes(root.left);
        int rightNodessum = sumofNodes(root.right);

        return leftNodessum + rightNodessum + root.data;
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myheight = Math.max(rightHeight, leftHeight) + 1;
        return myheight;
    }

    public static int diameter1(Node root){
    // O(n^2) is the time complexity
        if(root == null){
            return 0;
        }

        int dia1 = diameter1(root.left);
        int dia2 = diameter1(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        return Math.max(dia3, Math.max(dia1, dia2));
    }

    static class Treeinfo{
        int ht;
        int dia;

        Treeinfo(int ht, int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }

    public static Treeinfo diameter2(Node root){

        if(root == null){
            return new Treeinfo(0, 0);
        }

        Treeinfo left = diameter2(root.left);
        Treeinfo right = diameter2(root.right);

        int myheight = Math.max(left.ht, right.ht) + 1;

        int dia1 = left.dia;
        int dia2 = right.dia;

        int dia3 = left.ht + right.ht + 1;

        int mydia = Math.max(Math.max(dia1, dia2), dia3);


        Treeinfo myinfo = new Treeinfo(myheight, mydia);

        return myinfo;
    }

    



    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1};
        BinaryTree tree = new BinaryTree();
       
        Node root = tree.buildTree(nodes);
        System.out.print(root.data);   
    }








}
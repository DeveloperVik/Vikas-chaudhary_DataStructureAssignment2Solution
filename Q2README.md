//Create Helper Class Node
class Node {
    int val;
    Node left, right;

    //initialize variables using default constructor
    Node(int item) {
        val = item;
        left = right = null;
    }
}

//Driver Class
public class Main {

    public static Node node;
    static Node prev = null;
    static Node head = null;

    // Step 5
    // Function to convert the BST to skewed tree in ascending order
    // Parameters : Node root
    static void binaryTreeToSkewed(Node root) {

        //Step 6
        // if root is null return
        if (root == null) {
            return;
        }

        //Step 7
        //call function recursively with updated node as parameter
        binaryTreeToSkewed(root.left);

        Node rightNode = root.right;

        //Step 8
        // Checking for root Node of the skewed tree
        if (head == null) {
            //assign root to head node
            head = root;
            //make left node null
            root.left = null;
            //make previous node root node
            prev = root;
        } else {
            //assign root node to previous node's right node
            prev.right = root;
            //make left of root null
            root.left = null;
            //make previous node root node
            prev = root;
        }

        //Step 9
        //Similarly, call function to recurse subtree
        binaryTreeToSkewed(rightNode);
    }

    //Step 11
    // Function to print skewed tree using recursion in ascending order
    static void printSkewedTree(Node root) {
        
        //Step 12
        //if root node is null retun
        if (root == null) {
            return;
        }

        //Step 13 
        //print value of root node to print ascending order tree
        System.out.print(root.val + " ");

        //Step 14
        //traverse again in ascending order using right node
        printSkewedTree(root.right);
    }

    //Step 1
    // Driver Code : This is where code execution begins
    public static void main(String[] args) {

        //Step 2
        //Create an object of Main class called tree
        Main tree = new Main();

        //Step 3
        //Create BST using Node constructor
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        //Step 4
        //Call function that converts binary tree to skewed tree
        binaryTreeToSkewed(node);

        //Step 10
        //Call function that prints skewed tree
        printSkewedTree(head);

    }
}

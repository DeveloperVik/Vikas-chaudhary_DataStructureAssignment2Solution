//Driver Class
public class Main {

	public static Node node;
    static Node prev = null;
    static Node head = null;

    // Function to convert the BST to skewed tree in ascending order
    // Parameters : Node root
    static void binaryTreeToSkewed(Node root) {

        // if root is null return
        if (root == null) {
            return;
        }

        //call function recursively with updated node as parameter
        binaryTreeToSkewed(root.left);

        Node rightNode = root.right;

        // Checking for root Node of the skewed tree
        if (head == null) {
            head = root;
            root.left = null;
            prev = root;
        } else {
            prev.right = root;
            root.left = null;
            prev = root;
        }

        //Similarly, call function to recurse subtree
        binaryTreeToSkewed(rightNode);
    }

    // Function to print skewed tree using recursion in ascending order
    static void printSkewedTree(Node root) {
        if (root == null) {
            return;
        }

        //print value
        System.out.print(root.val + " ");

        //traverse again in ascending order using right node
        printSkewedTree(root.right);
    }

    // Driver Code
    public static void main(String[] args) {

        Main tree = new Main();

        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);

        binaryTreeToSkewed(node);
        printSkewedTree(head);

    }
}

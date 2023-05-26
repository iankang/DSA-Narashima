package trees;

public class BinaryTreeAction {
    public static void main(String[] args) {

        BinaryTree binaryTree= new BinaryTree(5);
        binaryTree.insert(3);
        binaryTree.insert(6);
        binaryTree.insert(345);
        binaryTree.insert(3345);
        binaryTree.insert(3362);
        binaryTree.insert(326);
        binaryTree.insert(27);
        binaryTree.insert(35);

        System.out.println("Binary Tree in-order traversal");
        binaryTree.displayInOrder();

        System.out.println("Binary Tree post-order traversal");
        binaryTree.displayPostOrder();

        System.out.println("Binary Tree Preorder traversal");
        binaryTree.displayPreOrder();
    }
}

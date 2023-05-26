package trees;

public class BinaryTree {

    BinaryTreeNode rootNode;

    public BinaryTree(Integer data) {
        rootNode = new BinaryTreeNode(data);
    }

    public void insert(int num){
        rootNode = insertNode(rootNode,num);
    }
    public BinaryTreeNode insertNode(BinaryTreeNode node, Integer num){

        if(node == null){
            System.out.println("node is null");
            return new BinaryTreeNode(num);
        } else {
            if(num <= node.getData()){
                System.out.println("number is less than the current node");
                 node.setLeft(insertNode(node.getLeft(), num));
            } else {
                System.out.println("number is more than the current node");
                node.setRight(insertNode(node.getRight(),num));
            }
            return node;
        }
    }

    public void displayInOrder(){
        displayInOrder(rootNode);
    }

    public void displayInOrder(BinaryTreeNode currentNode){

        if(currentNode != null){
            displayInOrder(currentNode.getLeft());
            System.out.println(currentNode.getData()+ " ");
            displayInOrder(currentNode.getRight());
        }
    }

    public void displayPostOrder(){
        displayPostOrder(rootNode);
    }

    public void displayPostOrder(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode != null){
            displayPostOrder(binaryTreeNode.getLeft());
            displayPostOrder(binaryTreeNode.getRight());
            System.out.println(binaryTreeNode.getData()+ " ");
        }
    }

    public void displayPreOrder(){
        displayPreOrder(rootNode);
    }

    public void displayPreOrder(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode != null){
            displayPreOrder(binaryTreeNode.getLeft());
            displayPreOrder(binaryTreeNode.getRight());
            System.out.println(binaryTreeNode.getData() + " ");
        }
    }
}

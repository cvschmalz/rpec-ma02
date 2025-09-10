
public class Main {

    public class Node {
        int value;
        Node left_child;
        Node right_child;

        public Node(int value){
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }

        public void setLeft_child(Node left_child) {
            this.left_child = left_child;
        }
        public Node getLeft_child() {
            return left_child;
        }

        public void setRight_child(Node right_child) {
            this.right_child = right_child;
        }
        public Node getRight_child() {
            return right_child;
        }
    }

    public class BinaryTree {
        Node Root;

        public BinaryTree(){
            this.Root = null;
        }
        public BinaryTree(Node root){
            this.Root = root;
        }

        public Node insertNode(Node root, int value){
            if (root == null){
                root = new Node(value);
                return root;
            }

            if (value < root.getValue()){
                root.setLeft_child(insertNode(root.getLeft_child(), value));
            } else {
                if (value > root.getValue()) {
                    root.setRight_child(insertNode(root.getRight_child(), value));
                } else {
                    return root;
                }
            }

            return root;
        }

        public void inOrder(Node root){
            if (root != null){
                inOrder(root.getLeft_child());
                System.out.println(root.getValue());
                inOrder(root.getRight_child());
            }
        }

        public void preOrder(Node root){
            if (root != null){
                System.out.println(root.getValue());
                preOrder(root.getLeft_child());
                preOrder(root.getRight_child());
            }
        }

        public void postOrder(Node root){
            if (root != null){
                postOrder(root.getLeft_child());
                postOrder(root.getRight_child());
                System.out.println(root.getValue());
            }
        }

        public Node removeMin(Node root){
            if (root == null) {
                System.out.println("Tree is empty");
                return null;
            }
            if (root.getLeft_child() == null) {
                return root.getRight_child();
            }
            root.setLeft_child(removeMin(root.getLeft_child()));
            return root;
        }

        public Node removeMax(Node root){
            if (root == null) {
                System.out.println("Tree is empty");
                return null;
            }
            if (root.getRight_child() == null) {
                return root.getLeft_child();
            }
            root.setRight_child(removeMax(root.getRight_child()));
            return root;
        }

        public Node removeValue(Node root, int value){
            if (root == null) {
                return null;
            }
            if (value < root.getValue()) {
                root.setLeft_child(removeValue(root.getLeft_child(), value));
            } else if (value > root.getValue()) {
                root.setRight_child(removeValue(root.getRight_child(), value));
            } else {
                if (root.getLeft_child() == null) return root.getRight_child();
                if (root.getRight_child() == null) return root.getLeft_child();

                Node minRight = findMin(root.getRight_child());
                root.setValue(minRight.getValue());
                root.setRight_child(removeMin(root.getRight_child()));
            }
            return root;
        }

        private Node findMin(Node root){
            while (root.getLeft_child() != null) {
                root = root.getLeft_child();
            }
            return root;
        }
    }

    public static void main(String[] args) {

        }
    }

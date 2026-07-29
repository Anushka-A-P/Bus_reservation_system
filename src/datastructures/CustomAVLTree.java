package datastructures;

class AVLNode {
    int busId;
    String busNumber;
    int capacity;
    int height;
    AVLNode left, right;

    public AVLNode(int busId, String busNumber, int capacity) {
        this.busId = busId;
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.height = 1;
    }
}

public class CustomAVLTree {
    private AVLNode root;

    private int height(AVLNode N) {
        return (N == null) ? 0 : N.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private int getBalance(AVLNode N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    private AVLNode insertRec(AVLNode node, int busId, String busNumber, int capacity) {
        if (node == null)
            return new AVLNode(busId, busNumber, capacity);

        if (busId < node.busId)
            node.left = insertRec(node.left, busId, busNumber, capacity);
        else if (busId > node.busId)
            node.right = insertRec(node.right, busId, busNumber, capacity);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && busId < node.left.busId)
            return rightRotate(node);
        if (balance < -1 && busId > node.right.busId)
            return leftRotate(node);
        if (balance > 1 && busId > node.left.busId) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && busId < node.right.busId) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void insert(int busId, String busNumber, int capacity) {
        root = insertRec(root, busId, busNumber, capacity);
    }

    private void inOrderRec(AVLNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println("Bus ID: " + node.busId + ", Number: " + node.busNumber + ", Capacity: " + node.capacity);
            inOrderRec(node.right);
        }
    }

    public void display() {
        inOrderRec(root);
    }
}
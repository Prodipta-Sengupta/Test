import java.util.ArrayList;

public class BinarySearchTree {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }


    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }


    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }


    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }


    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    // WRITE THE DELETENODE METHOD HERE //
    //                                  //
    //                                  //
    //                                  //
    //                                  //

    /// ///////////////////////////////////

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    public Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;
        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null) {
                return currentNode.right;
            } else if (currentNode.right == null) {
                return currentNode.left;
            }
            currentNode.value = minValue(currentNode.right);
            currentNode.right = deleteNode(currentNode.right, currentNode.value);
        }
        return currentNode;
    }

    public ArrayList<Integer> BFS() {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0) {
            Node temp = queue.remove(0);
            result.add(temp.value);
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
        return result;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public void dfs(Node currentNode, ArrayList<Integer> result) {
        if (currentNode == null) return;
        result.add(currentNode.value);
        dfs(currentNode.left, result);
        dfs(currentNode.right, result);
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        dfsPostOrder(root, result);
        return result;
    }

    public void dfsPostOrder(Node currentNode, ArrayList<Integer> result) {
        if (currentNode == null) return;
        dfsPostOrder(currentNode.left, result);
        dfsPostOrder(currentNode.right, result);
        result.add(currentNode.value);
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        dfsInOrder(root, result);
        return result;
    }

    public void dfsInOrder(Node currentNode, ArrayList<Integer> result) {
        if (currentNode == null) return;
        dfsInOrder(currentNode.left, result);
        result.add(currentNode.value);
        dfsInOrder(currentNode.right, result);
    }

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree.create(node, left, right);
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        br.close();
    }
}

class Node {
    String data;
    Node left, right;

    Node(String data) {
        this.data = data;
    }
}

class Tree {
    public Node root;

    public void create(String data, String leftStr, String rightStr) {
        if (root == null) {
            root = new Node(data);
            root.left = !leftStr.equals(".") ? new Node(leftStr) : null;
            root.right = !rightStr.equals(".") ? new Node(rightStr) : null;
        } else
            search(root, data, leftStr, rightStr);
    }

    public void search(Node node, String data, String leftStr, String rightStr) {
        if (node == null) return;
        if (node.data.equals(data)) {
            node.left = !leftStr.equals(".") ? new Node(leftStr) : null;
            node.right = !rightStr.equals(".") ? new Node(rightStr) : null;
        } else {
            search(node.left, data, leftStr, rightStr);
            search(node.right, data, leftStr, rightStr);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.left != null)
                preOrder(node.left);
            if (node.right != null)
                preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            if (node.left != null)
                inOrder(node.left);
            System.out.print(node.data);
            if (node.right != null)
                inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            if (node.left != null)
                postOrder(node.left);
            if (node.right != null)
                postOrder(node.right);
            System.out.print(node.data);
        }
    }
}
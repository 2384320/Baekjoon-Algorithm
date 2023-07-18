import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            root.setNode(num);
        }
        postOrder(root);

        br.close();
    }
    
    private static void postOrder(Node root) {
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);
        System.out.println(root.root);
    }
}

class Node {
    int root;
    Node left, right;

    Node(int root) {
        this.root = root;
    }

    public void setNode(int root) {
        if (root < this.root) {
            if (this.left == null) this.left = new Node(root);
            else this.left.setNode(root);
        } else {
            if (this.right == null) this.right = new Node(root);
            else this.right.setNode(root);
        }
    }
}
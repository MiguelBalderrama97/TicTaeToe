
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Node n = new Node();
        Node res = breadthFS(n);
        System.out.println(res);
    }

    public static Node depthFS(Node n) {
        Node temp;
        if (n.isFinal()) {
            return n;
        }

        n.generateChildren();
        for (int i = 0; i < n.getChildrenSize(); i++) {
            temp = depthFS(n.getChild(i));
            if (temp != null) {
                return temp;
            }
        }
        return null;
    }

    public static Node breadthFS(Node n) {
        Node temp;
        LinkedList<Node> q = new LinkedList<>();
        q.push(n);

        while (!q.isEmpty()) {
            temp = q.pop();
            if (temp.isFinal()) {
                return temp;
            }

            temp.generateChildren();
            for (int i = 0; i < temp.getChildrenSize(); i++) {
                q.push(temp.getChild(i));
            }
        }
        return null;
    }
}

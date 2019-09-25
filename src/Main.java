
public class Main {

    public static void main(String[] args) {
        Node n = new Node();
        System.out.println(n);
        n.generateChildren();
        for(int i = 0; i < n.getChildrenSize(); i++){
            System.out.println(n.getChild(i));
        }
    }
}

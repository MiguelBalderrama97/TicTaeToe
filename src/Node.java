
import java.util.ArrayList;


public class Node {
    
    private byte[] tictaetoe;
    private byte turn;
    private ArrayList<Node> childrens;
    
    private final int ARRAY_SIZE = 9;
    
    public Node(){ //NODO INICIAL
        this.tictaetoe = new byte[ARRAY_SIZE];
        for(int i: tictaetoe){
            tictaetoe[i] = 0;
        }
        this.turn = 1;
        this.childrens = new ArrayList<>();
    }
    
    public Node(Node node){ 
        this.tictaetoe = new byte[9];
        System.arraycopy(node.tictaetoe, 0, this.tictaetoe, 0, ARRAY_SIZE);
        this.turn = node.turn;
    }
    
    public void generateChildren(){ // GENERAR TODOS LOS NODOS HIJOS Y ANAÑDIRLOS A LA LISTA CHILDREN
        
    }

    @Override
    public String toString() {
        // (X,0, , , , , , , ) Turn: X
        String  s = "{";
        for(int i: tictaetoe){
            s += this.tictaetoe[i] == 0 ? " " : this.tictaetoe[i] == 1 ? "X" : "O";
            s += i < ARRAY_SIZE-1 ? "," : "";
        }
        s += "} Turn: ";
        s += this.turn ==  1 ? "X" : "O";
        return s;
    }
    
    
}

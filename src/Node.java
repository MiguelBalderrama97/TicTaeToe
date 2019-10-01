
import java.util.ArrayList;
import java.util.Arrays;

public class Node {

    private byte[] tictaetoe;               //(0)-VACIO     (1)-X's     (2)-O's
    private byte turn;                      //(1)-X's   (2)-O's
    private ArrayList<Node> children;

    public Node() { //NODO INICIAL
        this.tictaetoe = new byte[9];
        for (int i = 0; i < this.tictaetoe.length; i++) {
            tictaetoe[i] = 0;
        }
        this.turn = 1;
        this.children = new ArrayList<>();
    }

    public Node(Node node) {
        this.tictaetoe = new byte[9];
        System.arraycopy(node.tictaetoe, 0, this.tictaetoe, 0, this.tictaetoe.length);
        this.turn = node.turn;
        this.children = new ArrayList<>();
    }

    public void generateChildren() { // GENERAR TODOS LOS NODOS HIJOS Y ANAÑDIRLOS A LA LISTA CHILDREN
        byte market = (byte) (this.turn == 1 ? 1 : 0); //DEFINIR CUAL CARACTER SE ESCRIBIRA DEPENDIENDO DEL TURNO
        Node node;
        this.children.clear();  // LIMPIAR LA LISTA EN CASO DE VOLVERLA A LLAMAR
        for (int i = 0; i < this.tictaetoe.length; i++) {
            if (this.tictaetoe[i] == 0) { //COMPROBAR SI LA CASILLA ESTA VACIA
                node = new Node(this); //CREAR UN NODO HIJO DE NUESTRO NODO ACTUAL
                node.tictaetoe[i] = market; //SOBRESCRIBIR CON NUESTRO MARKET
                node.turn = (byte) (this.turn == 1 ? 2 : 1); //CAMBIO DE TURNO
                this.children.add(node); //AGREGAR EL NODO A LA LISTA CHILDREN
            }
        }
    }

    public int getChildrenSize() { // SABER NUMERO DE HIJOS
        return this.children.size();
    }

    public Node getChild(int index) { // OBETENR UN NODO HIJO POR EL INDEX, SI EL INDICE NO ES VALIDO SE REGRESA UN OBJETO NULL
        if (index < 0 || index >= this.children.size()) {
            return null;
        }
        return this.children.get(index);
    }

    public void printChildren() {
        for (int i = 0; i < this.children.size(); i++) {
            System.out.println(this.children.get(i));
        }
    }

    public boolean isFinal() { //REVISA SI EL ESTADO ACTUAL ES FINAL
        for (int i = 0; i < 3; i++) {
            //REVISAR COLUMNAS
            if (this.tictaetoe[i] != 0 && this.tictaetoe[i] == this.tictaetoe[i + 3] && this.tictaetoe[i] == this.tictaetoe[i + 6]) {
                return true;
            }
            //REVISAR COLUMNAS
            if (this.tictaetoe[i * 3] != 0 && this.tictaetoe[i * 3] == this.tictaetoe[i + 3 + 1] && this.tictaetoe[i * 3] == this.tictaetoe[i * 3 + 2]) {
                return true;
            }
        }

        if (this.tictaetoe[0] != 0 && this.tictaetoe[0] == this.tictaetoe[4] && this.tictaetoe[0] == this.tictaetoe[8]) {
            return true;
        }
        return this.tictaetoe[2] != 0 && this.tictaetoe[2] == this.tictaetoe[4] && this.tictaetoe[2] == this.tictaetoe[6];
    }
    

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Node)){
            return false;
        }

        Node temp = (Node)obj;
        
        for (int i = 0; i < this.tictaetoe.length; i++) {
            if(this.tictaetoe[i] != temp.tictaetoe[i]){
                return false;
            }
        }
        
        return this.turn == temp.turn;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Arrays.hashCode(this.tictaetoe);
        hash = 53 * hash + this.turn;
        return hash;
    }
   
    @Override
    public String toString() {
        // (X,0, , , , , , , ) Turn: X
        String s = "{";
        for (int i = 0; i < this.tictaetoe.length; i++) {
            s += this.tictaetoe[i] == 0 ? " " : (this.tictaetoe[i] == 1 ? "X" : "O");
            s += i < this.tictaetoe.length - 1 ? "," : "";
        }
        s += "} Turn: ";
        s += this.turn == 1 ? "X" : "O";
        return s;
    }
}

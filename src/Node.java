
import java.util.ArrayList;


public class Node {
    
    private byte[] tictaetoe;               //(0)-VACIO     (1)-X's     (2)-O's
    private byte turn;                      //(1)-X's   (2)-O's
    private ArrayList<Node> children;
    
    public Node(){ //NODO INICIAL
        this.tictaetoe = new byte[9];
        for(int i = 0; i < this.tictaetoe.length; i++){
            tictaetoe[i] = 0;
        }
        this.turn = 1;
        this.children = new ArrayList<>();
    }
    
    public Node(Node node){ 
        this.tictaetoe = new byte[9];
        System.arraycopy(node.tictaetoe, 0, this.tictaetoe, 0, this.tictaetoe.length);
        this.turn = node.turn;
        this.children = new ArrayList<>();
    }
    
    public void generateChildren(){ // GENERAR TODOS LOS NODOS HIJOS Y ANAÑDIRLOS A LA LISTA CHILDREN
        byte market = (byte)(this.turn == 1 ? 1 : 0); //DEFINIR CUAL CARACTER SE ESCRIBIRA DEPENDIENDO DEL TURNO
        for(int i = 0; i < this.tictaetoe.length; i++){
            if(this.tictaetoe[i] == 0){ //COMPROBAR SI LA CASILLA ESTA VACIA
                Node node = new Node(this); //CREAR UN NODO HIJO DE NUESTRO NODO ACTUAL
                node.tictaetoe[i] = market; //SOBRESCRIBIR CON NUESTRO MARKET
                node.turn = (byte)(this.turn == 1 ? 2 : 1); //CAMBIO DE TURNO
                this.children.add(node); //AGREGAR EL NODO A LA LISTA CHILDREN
            }
        }
    }
    
    public void printChildrens(){
        for(int i = 0; i < this.children.size(); i++){
            System.out.println(this.children.get(i));
        }
    } 

    @Override
    public String toString() {
        // (X,0, , , , , , , ) Turn: X
        String  s = "{";
        for(int i = 0; i < this.tictaetoe.length; i++){
            s += this.tictaetoe[i] == 0 ? " " : (this.tictaetoe[i] == 1 ? "X" : "O");
            s += i < this.tictaetoe.length-1 ? "," : "";
        }
        s += "} Turn: ";
        s += this.turn ==  1 ? "X" : "O";
        return s;
    } 
}

package src;

import java.util.HashMap;

public class Nodo {
    
    HashMap<String, String> valores;
    String nombre;
    Nodo hijo_izquieda, hijo_derecha;

    public Nodo(String nombre, HashMap<String, String> valores) {
        this.nombre = nombre;
        this.valores = valores;
        this.hijo_izquieda = null;
        this.hijo_derecha = null;
    }

    public String toString() {
        return this.nombre + " : " + this.valores.toString();
    }

}

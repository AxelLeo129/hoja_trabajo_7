package src;

import java.util.HashMap;

public class Arbol {
 
    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void addNodo(String nombre, HashMap<String, String> valores) {
        Nodo nuevo = new Nodo(nombre, valores);
        if(this.raiz == null) {
            this.raiz = nuevo;
        } else {
            Nodo ayuda = this.raiz;
            Nodo padre;
            while(true) {
                padre = ayuda;
                if(nombre.compareTo(ayuda.nombre) < 0) {
                    ayuda = ayuda.hijo_izquieda;
                    if(ayuda == null) {
                        padre.hijo_izquieda = nuevo;
                        return;
                    }
                } else {
                    ayuda = ayuda.hijo_derecha;
                    if(ayuda == null) {
                        padre.hijo_derecha = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void inOrder(Nodo r) {
        if(r != null) {
            inOrder(r.hijo_izquieda);
            System.out.println(r.nombre + ": " + r.valores.toString());
            inOrder(r.hijo_derecha);
        }
    }

    public Nodo searchNodo(String nombre) {
        Nodo auxiliar = this.raiz;
        while(!auxiliar.nombre.equals(nombre)) {
            if(nombre.compareTo(auxiliar.nombre) < 0) {
                auxiliar = auxiliar.hijo_izquieda;
            } else {
                auxiliar = auxiliar.hijo_derecha;
            }
            if(auxiliar == null) {
                return null;
            }
        }
        return auxiliar;
    } 

}

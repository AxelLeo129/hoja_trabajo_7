package src;

import java.util.ArrayList;
import java.util.HashMap;

public class View {

    public View() {}

    public void execute() {
        Lector lector = new Lector();
        ArrayList<String> lineas = new ArrayList<>();
        lineas = lector.readFile("assets/diccionario.txt");
        Arbol ingles = fillTree(lineas, 0);
        Arbol espaniol = fillTree(lineas, 1);
        Arbol frances = fillTree(lineas, 2);
        
        
        /*frances.inOrder(frances.raiz);
        System.out.println(frances.searchNodo("perro").toString());*/

        
    }

    public Arbol fillTree(ArrayList<String> lineas, int numero_lenguaje) {
        Arbol lenguaje = new Arbol();
        lineas.forEach((n) -> {
            HashMap<String, String> valores = new HashMap<>();
            String[] e = n.split(",");
            valores.put("i", e[0]);
            valores.put("e", e[1]);
            valores.put("f", e[1]);
            lenguaje.addNodo(e[numero_lenguaje], valores);
        });
        return lenguaje;
    }

}
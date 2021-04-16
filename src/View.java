package src;

import java.util.HashMap;

public class View {

    public View() {}

    public void execute() {
        /*Lector lector = new Lector();
        System.out.println(lector.readFile("assets/diccionario.txt"));*/
        Arbol tree = new Arbol();
        HashMap<String, String> i = new HashMap<>();
        i.put("ingles", "house");
        i.put("español", "casa");
        i.put("frances", "loger");
        HashMap<String, String> j = new HashMap<>();
        j.put("ingles", "dog");
        j.put("español", "perro");
        j.put("frances", "chien");
        HashMap<String, String> k = new HashMap<>();
        k.put("ingles", "homework");
        k.put("español", "tarea");
        k.put("frances", "devoirs");
        tree.addNodo("house", i);
        tree.addNodo("dog", j);
        tree.addNodo("homework", k);
        tree.inOrder(tree.raiz);
        System.out.println(tree.searchNodo("dog").toString());

        /*
        house,casa,loger
        dog,perro,chien
        homework,tarea,devoirs
        woman,mujer,femme
        town,pueblo,ville
        yes,si,Oui
        */
    }

}
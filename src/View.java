import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class View {

    public View() {}

    public void execute() {
        Lector lector = new Lector();
        ArrayList < String > lineas;
        Scanner sc = new Scanner(System.in);
        lineas = lector.readFile("assets/diccionario.txt");
        Arbol ingles = fillTree(lineas, 0);
        Arbol espaniol = fillTree(lineas, 1);
        Arbol frances = fillTree(lineas, 2);

        int option = 0;

        System.out.println("Bienvenidos al traductor de documentos");

        while (option != 8) {
            boolean validar = false;

            while (!validar) {
                System.out.println("1. Español - Inglés\n2. Español - Francés\n3. Inglés - Español\n4. Inglés - Francés\n5. Francés - Español\n6. Francés - Inglés\n7. Mostrar diccionario inglés \n8. Salir\nSeleccione una opcion: ");
                try {
                    option = Integer.parseInt(sc.next());
                    if (option < 8 && option > 0)
                        validar = true;
                    else
                        System.out.println("Ingrese una opción válida\n");
                } catch (Exception e) {
                    System.out.println("Ingrese una opción válida\n");
                }
            }

            validar = false;

            if (option == 1) {
                ArrayList < String > oraciones = lector.readFile("assets/es.txt");
                System.out.println(translate(oraciones, espaniol, "i"));
            } else if (option == 2) {
                ArrayList < String > oraciones = lector.readFile("assets/es.txt");
                System.out.println(translate(oraciones, espaniol, "f"));
            } else if (option == 3) {
                ArrayList < String > oraciones = lector.readFile("assets/en.txt");
                System.out.println(translate(oraciones, ingles, "e"));
            } else if (option == 4) {
                ArrayList < String > oraciones = lector.readFile("assets/en.txt");
                System.out.println(translate(oraciones, ingles, "f"));
            } else if (option == 5) {
                ArrayList < String > oraciones = lector.readFile("assets/fr.txt");
                System.out.println(translate(oraciones, frances, "e"));
            } else if (option == 6) {
                ArrayList < String > oraciones = lector.readFile("assets/fr.txt");
                System.out.println(translate(oraciones, frances, "i"));
            } else if(option == 7) {
                System.out.println("Diccionario Inglés:");
                ingles.inOrder(ingles.raiz);
            } else if (option == 8) {
                System.out.println("Feliz día :)");
            }
        }
    }

    public Arbol fillTree(ArrayList < String > lineas, int numero_lenguaje) {
        Arbol lenguaje = new Arbol();
        lineas.forEach((n) -> {
            HashMap < String,
            String > valores = new HashMap < > ();
            String[] e = n.split(",");
            valores.put("i", e[0]);
            valores.put("e", e[1]);
            valores.put("f", e[1]);
            lenguaje.addNodo(e[numero_lenguaje], valores);
        });
        return lenguaje;
    }

    public String translate(ArrayList < String > oracion, Arbol lenguaje, String language) {
        String traducido = "Traducción: ";
        for (int j = 0; j < oracion.size(); j++) {
            String[] e = oracion.get(j).split(" ");
            for (int i = 0; i < e.length; i++) {
                Nodo palabra = lenguaje.searchNodo(e[i].toLowerCase());
                if (palabra == null) {
                    traducido += "*" + e[i] + "* ";
                } else {
                    traducido += palabra.valores.get(language) + " ";
                }
            }
        };
        return traducido;
    }

}
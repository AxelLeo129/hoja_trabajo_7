package src;

public class View {
    
    public View() { }

    public void execute() {
        Lector lector = new Lector();
        System.out.println(lector.readFile("assets/diccionario.txt"));
    }

}

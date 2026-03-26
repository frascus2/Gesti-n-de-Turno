import sistema.GestorTurnos;
import sistema.GestorTurnosMemoria;
import sistema.TurnosApp;
 
public class App {
 
    public static void main(String[] args) throws Exception {
        GestorTurnos gestorTurnos = new GestorTurnosMemoria();
        TurnosApp turnosApp = new TurnosApp(gestorTurnos);
        turnosApp.star();
    }
}

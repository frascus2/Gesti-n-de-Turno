package sistema;
 
public interface GestorTurnos {
 
    void agregarTurno(Cliente cliente);
    void atenderTurno(Empleado empleado);
    void mostrarTurnosPendientes();
    void mostrarTurnosAtendidos();
}
 
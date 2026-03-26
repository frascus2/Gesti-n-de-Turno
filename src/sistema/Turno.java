package sistema;
 
public class Turno {
 
    private int id;
    private Cliente cliente;
    private Empleado empleado;
 
    public Turno(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }
 
    // Getters
    public int getId() {
        return id;
    }
 
    public Cliente getCliente() {
        return cliente;
    }
 
    public Empleado getEmpleado() {
        return empleado;
    }
 
    // Setters
    public void setId(int id) {
        this.id = id;
    }
 
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
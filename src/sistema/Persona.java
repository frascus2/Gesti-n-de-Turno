package sistema;
 
public class Persona {
 
    private String nombre;
    private int id;
 
    public Persona(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }
 
    // Getters
    public String getNombre() {
        return nombre;
    }
 
    public int getId() {
        return id;
    }
 
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre;
    }
}
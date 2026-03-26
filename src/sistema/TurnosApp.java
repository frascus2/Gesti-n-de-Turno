package sistema;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class TurnosApp {
 
    private GestorTurnos gestorTurnos;
    public List<Empleado> empleados;
    public List<Cliente> clientes;
 
    // Constructor
    public TurnosApp(GestorTurnos gestorTurnos) {
        this.gestorTurnos = gestorTurnos;
        this.empleados = new ArrayList<>();
        this.clientes = new ArrayList<>();
        cargarDatosIniciales();
    }
 
    // Datos iniciales requeridos por el enunciado
    private void cargarDatosIniciales() {
        // Clientes y empelados 
        clientes.add(new Cliente("Alejandro Quisoboni", 1));
        clientes.add(new Cliente("Jonathan Carabalí", 2));
        clientes.add(new Cliente("Alano Quisobonito", 3));
 
        // 2 empleados con nombres de los integrantes del grupo
        empleados.add(new Empleado("Ana Martínez", 1));
        empleados.add(new Empleado("Alexandra Palomino", 2));
 
        // 3 turnos para los clientes registrados
        gestorTurnos.agregarTurno(clientes.get(0));
        gestorTurnos.agregarTurno(clientes.get(1));
        gestorTurnos.agregarTurno(clientes.get(2));
    }
 
    public void star() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
 
        while (opcion != 0) {
            System.out.println();
            System.out.println("  ****************************************");
            System.out.println("       SISTEMA DE GESTIÓN DE TURNOS");
            System.out.println("  ****************************************");
            System.out.println("  1. Registrar cliente");
            System.out.println("  2. Registrar empleado");
            System.out.println("  3. Crear turno para cliente");
            System.out.println("  4. Atender siguiente turno");
            System.out.println("  5. Mostrar turnos pendientes");
            System.out.println("  6. Mostrar turnos atendidos");
            System.out.println("  0. Salir");
            System.out.println("  ----------------------------------------");
            System.out.print("  Seleccione una opción: ");
 
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  Por favor ingrese un número válido.");
                continue;
            }
 
            System.out.println();
            switch (opcion) {
                case 1 -> registrarCliente(scanner);
                case 2 -> registrarEmpleado(scanner);
                case 3 -> crearTurno(scanner);
                case 4 -> atenderSiguienteTurno();
                case 5 -> gestorTurnos.mostrarTurnosPendientes();
                case 6 -> gestorTurnos.mostrarTurnosAtendidos();
                case 0 -> System.out.println("  Saliendo del sistema. ¡Hasta luego!");
                default -> System.out.println("  Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
 
    private void registrarCliente(Scanner scanner) {
        System.out.println("  -- Registrar Cliente --");
        System.out.print("  Nombre: ");
        String nombre = scanner.nextLine();
        int id = clientes.size() + 1;
        Cliente nuevo = new Cliente(nombre, id);
        clientes.add(nuevo);
        System.out.println("  Cliente registrado exitosamente.");
        System.out.println();
        System.out.println("  === Lista de Clientes (" + clientes.size() + ") ===");
        for (Cliente c : clientes) {
            System.out.println("  " + c);
        }
    }
 
    private void registrarEmpleado(Scanner scanner) {
        System.out.println("  -- Registrar Empleado --");
        System.out.print("  Nombre: ");
        String nombre = scanner.nextLine();
        int id = empleados.size() + 1;
        Empleado nuevo = new Empleado(nombre, id);
        empleados.add(nuevo);
        System.out.println("  Empleado registrado exitosamente.");
        System.out.println();
        System.out.println("  === Lista de Empleados (" + empleados.size() + ") ===");
        for (Empleado e : empleados) {
            System.out.println("  " + e);
        }
    }
 
    private void crearTurno(Scanner scanner) {
        System.out.println("  -- Crear Turno para Cliente --");
        if (clientes.isEmpty()) {
            System.out.println("  No hay clientes registrados.");
            return;
        }
        System.out.println("  Clientes disponibles:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("  [" + (i + 1) + "] " + clientes.get(i));
        }
        System.out.print("  Seleccione el número de cliente: ");
        try {
            int opcion = Integer.parseInt(scanner.nextLine().trim());
            if (opcion < 1 || opcion > clientes.size()) {
                System.out.println("  Cliente no encontrado.");
                return;
            }
            gestorTurnos.agregarTurno(clientes.get(opcion - 1));
        } catch (NumberFormatException e) {
            System.out.println("  Opción inválida.");
        }
    }
 
    private void atenderSiguienteTurno() {
        if (empleados.isEmpty()) {
            System.out.println("  No hay empleados registrados.");
            return;
        }
        // El primer empleado disponible atiende el turno
        gestorTurnos.atenderTurno(empleados.get(0));
        System.out.println("  Turno atendido por: " + empleados.get(0).getNombre());
    }
}
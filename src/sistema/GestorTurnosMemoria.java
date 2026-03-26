package sistema;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GestorTurnosMemoria implements GestorTurnos {

    private Queue<Turno> colaTurnos;
    private List<Turno> turnosAtendidos;
    private int idTurno = 1;

    // Constructor
    public GestorTurnosMemoria() {
        colaTurnos = new LinkedList<>();
        turnosAtendidos = new ArrayList<>();
    }

    @Override
    public void agregarTurno(Cliente cliente) {
        idTurno++;
        Turno turno = new Turno(idTurno, cliente);
        colaTurnos.add(turno);
        System.out.println("  Turno #" + turno.getId() + " creado para: " + cliente.getNombre());
    }

    @Override
    public void atenderTurno(Empleado empleado) {
        Turno turno = colaTurnos.poll();
        turno.setEmpleado(empleado);
        turnosAtendidos.add(turno);
    }

    @Override
    public void mostrarTurnosPendientes() {
        if (colaTurnos.isEmpty()) {
            System.out.println("  No hay turnos pendientes.");
            return;
        }
        System.out.println("  --- Turnos Pendientes (" + colaTurnos.size() + ") ---");
        for (Turno t : colaTurnos) {
            System.out.println("  Turno #" + t.getId() + " | Cliente: " + t.getCliente().getNombre());
        }
    }

    @Override
    public void mostrarTurnosAtendidos() {
        if (turnosAtendidos.isEmpty()) {
            System.out.println("  No hay turnos atendidos.");
            return;
        }
        System.out.println("  --- Turnos Atendidos (" + turnosAtendidos.size() + ") ---");
        for (Turno t : turnosAtendidos) {
            System.out.println("  Turno #" + t.getId() + " | Cliente: " + t.getCliente().getNombre()
                    + " | Empleado: " + t.getEmpleado().getNombre());
        }
    }
}
package aulaVirtual;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa a un alumno del aula virtual.
 * Un alumno puede estar inscrito en varias asignaturas.
 */
public class Alumno extends Usuario {//Alumno va a heredar de Usuario

    private Map<Asignatura, Integer> notas;

    public Alumno(String nombre, String email) {
        super(nombre, email);
        this.notas = new HashMap<>();
    }

    public Map<Asignatura, Integer> getNotas() {
        return new HashMap<>(notas);
    }
    public void imprimirAlumno() {
        System.out.println("Nombre del alumno: " + getNombre());
        System.out.println("Email: " + getEmail());
        System.out.println("Asignaturas inscritas:");
        for (Asignatura asignatura : getAsignaturas()) {
            System.out.println("- " + asignatura.getNombre());
        }
    }

    protected void asignarNota(Asignatura asignatura, int nota) {
        if (getAsignaturas().contains(asignatura)) {
            notas.put(asignatura, nota);
        } else {
            System.out.println("El alumno no está inscrito en esta asignatura.");
        }
    }

    public void mostrarNotas() {
        System.out.println("Notas del alumno " + nombre + ":");
        for (Map.Entry<Asignatura, Integer> entry : notas.entrySet()) {
            System.out.println(entry.getKey().getNombre() + ": " + entry.getValue());
        }
    }

    public int obtenerNota(Asignatura asignatura) {
        return notas.getOrDefault(asignatura, -1);
    }

}
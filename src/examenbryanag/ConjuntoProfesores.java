package examenbryanag;

import java.util.ArrayList;

public class ConjuntoProfesores {

    private ArrayList<Profesor> profesores;

    public ConjuntoProfesores() {
        profesores = new ArrayList<>();
    }

    public void Cargar() {
        profesores.clear();
        String nombre = "";
        String id = "";
        String area = "";
        String categoria = "";
        String status = "";
        String idioma = "";
        String tiempo = "";
        Profesor nuevoProfesor = new Profesor(nombre, id, area, categoria, status, idioma, tiempo);
        agregar(nuevoProfesor);
    }

    public int numProfesores() {
        return profesores.size();
    }

    public Profesor recuperar(int o) {
        return profesores.get(o);
    }

    public void agregar(Profesor nuevo) {
        profesores.add(nuevo);
    }

}

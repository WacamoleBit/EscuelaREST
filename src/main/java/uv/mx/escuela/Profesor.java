package uv.mx.escuela;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String nombre;
    private List<String> clases;
    private String genero;
    
    
    public Profesor() {
        clases = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getClases() {
        return clases;
    }

    public void setClases(List<String> clases) {
        this.clases = clases;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
}

package empresa;

import java.util.*;

public class Empresa {

    private String nombre;
    private List<Persona> listaPersonas = new ArrayList<Persona>();

    public Empresa() {
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + ", listaPersonas=" + listaPersonas + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    public String imprimirSueldoBruto() {
        String resultado = "";
        for (Persona persona : listaPersonas) {
            if (persona instanceof Empleado) {
                resultado += String.format("Nombre: %s, Sueldo: %.2f\n", persona.getNombre(),
                        ((Empleado) persona).getSueldoBruto());
            }
        }
        return resultado;
    }

}
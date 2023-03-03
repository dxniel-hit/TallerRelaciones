package empresa;

import java.util.*;

public class Empleado extends Persona {

    private Double sueldoBruto;
    private List<Directivo> listaDirectores;



    public Empleado(String nombre, Integer edad) {
        super(nombre, edad);
    }

    public Empleado(String nombre, Integer edad, Double sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(Double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    public List<Directivo> getListaDirectores() {
        return listaDirectores;
    }

    public void setListaDirectores(List<Directivo> listaDirectores) {
        this.listaDirectores = listaDirectores;
    }

    @Override
    public String toString() {
        return "Empleado [sueldoBruto=" + sueldoBruto + ", listaDirectores=" + listaDirectores + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((sueldoBruto == null) ? 0 : sueldoBruto.hashCode());
        result = prime * result + ((listaDirectores == null) ? 0 : listaDirectores.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;
        if (sueldoBruto == null) {
            if (other.sueldoBruto != null)
                return false;
        } else if (!sueldoBruto.equals(other.sueldoBruto))
            return false;
        if (listaDirectores == null) {
            if (other.listaDirectores != null)
                return false;
        } else if (!listaDirectores.equals(other.listaDirectores))
            return false;
        return true;
    }

}

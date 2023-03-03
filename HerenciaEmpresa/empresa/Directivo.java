package empresa;

import java.util.ArrayList;
import java.util.List;

public class Directivo extends Empleado {

    private Categoria categoria;
    private List<Empleado> listaSubOrdinados = new ArrayList<Empleado>();

    public Directivo(String nombre, Integer edad, Double sueldoBruto, Categoria categoria,
            List<Empleado> listaSubOrdinados) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
        this.listaSubOrdinados = listaSubOrdinados;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Empleado> getListaSubOrdinados() {
        return listaSubOrdinados;
    }

    public void setListaSubOrdinados(List<Empleado> listaSubOrdinados) {
        this.listaSubOrdinados = listaSubOrdinados;
    }

    @Override
    public String toString() {
        return "Directivo [categoria=" + categoria + ", listaSubOrdinados=" + listaSubOrdinados + "]";
    }

    

}

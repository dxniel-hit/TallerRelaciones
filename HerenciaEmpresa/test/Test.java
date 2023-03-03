package test;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import empresa.Categoria;
import empresa.Directivo;
import empresa.Empleado;
import empresa.Empresa;
import empresa.Persona;

public class Test {

    public static void main(String[] args) {

        /*
         * Empresa empresa = new Empresa("UQ Empresa");
         * Persona persona = new Empleado("Daniel", 17, 100000.0);
         * Cliente cliente = new Cliente("Juan", 18, "213");
         * 
         * ArrayList<Empleado> listaSubOrdinados = new ArrayList<Empleado>();
         * 
         * listaSubOrdinados.add((Empleado) persona);
         * 
         * Directivo directivo = new Directivo("Jose", 18, 5000000.0, Categoria.GERENTE,
         * listaSubOrdinados);
         * empresa.getListaPersonas().add(persona);
         * empresa.getListaPersonas().add(cliente);
         * 
         * empresa.getListaPersonas().add(directivo);
         */

        // Hacer un método que imprima el salario bruto de los empleados. Se debe
        // manipular la lista de personas de la clase Empresa.
        Empresa empresa = new Empresa();
        ArrayList<Empleado> listaSubOrdinados = new ArrayList<Empleado>();

        Persona empleado1 = new Empleado("Daniel", 12, 50000.0);
        Persona empleado2 = new Empleado("Jairo", 12, 55000.0);

        listaSubOrdinados.add((Empleado) empleado1);

        empresa.getListaPersonas().add(empleado1);
        empresa.getListaPersonas().add(empleado2);

        Directivo directivo = new Directivo("Ramón", 13, 54000.00, Categoria.GERENTE, listaSubOrdinados);

        empresa.getListaPersonas().add(directivo);

        JOptionPane.showMessageDialog(null, empresa.imprimirSueldoBruto());
    }
}

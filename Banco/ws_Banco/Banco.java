package Banco.ws_Banco;

import java.util.*;

import javax.swing.JOptionPane;

public class Banco {

    private String nombre;
    private List<Cuenta> listaCuentas = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();

    public Banco() {
    }

    public Banco(String nombre, List<Cuenta> listaCuentas) {
        this.nombre = nombre;
        this.listaCuentas = listaCuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((listaCuentas == null) ? 0 : listaCuentas.hashCode());
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
        Banco other = (Banco) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (listaCuentas == null) {
            if (other.listaCuentas != null)
                return false;
        } else if (!listaCuentas.equals(other.listaCuentas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Banco [nombre=" + nombre + ", listaCuentas=" + listaCuentas + "]";
    }

    /**
     * Función para comparar saldos.
     * 
     * @param cuentaAComparar
     * @return
     */
    public boolean compararSaldos(Cuenta cuentaAComparar) {

        // Pregunta por un saldo a comparar dado por el usuario.
        Cuenta cuentaPrimaria = new Cuenta("Daniel", "Correa", "0000", CategoriaCuenta.SALDO,
                preguntarSaldo("Saldo que desea comparar: "));

        if (cuentaPrimaria.getSaldoCuenta() < cuentaAComparar.getSaldoCuenta())
            return false;
        return true;
    }

    /**
     * Función para transferir dinero. Crea dos parámetros Double con getSaldoCuenta
     * y luego los compara.
     * 
     * @param cuentaDestino
     * @param cuentaOrigen
     * @param cantidadTransferida
     */
    public void transferirDinero(Cuenta cuentaDestino, Cuenta cuentaOrigen, Double cantidadTransferida) {

        Double dineroDestino = cuentaDestino.getSaldoCuenta();
        Double dineroOrigen = cuentaDestino.getSaldoCuenta();

        if (dineroOrigen >= cantidadTransferida) {
            cuentaOrigen.setSaldoCuenta(dineroOrigen - cantidadTransferida);
            cuentaDestino.setSaldoCuenta(dineroDestino + cantidadTransferida);
            JOptionPane.showMessageDialog(null, String.format("Se transfirieron %.2f desde la cuenta %s a la cuenta %s",
                    cantidadTransferida, cuentaOrigen.getNumeroCuentaBanco(), cuentaDestino.getNumeroCuentaBanco()));
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo hacer la transferencia");
        }
    }

    // Función para hacer que el código no se vea tan feo.
    public static Double preguntarSaldo(String mensaje) {
        return Double.parseDouble(JOptionPane.showInputDialog(null, mensaje));
    }
}

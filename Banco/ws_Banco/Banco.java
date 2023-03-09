package Banco.ws_Banco;

import java.text.Format;
import java.util.*;

import javax.swing.JOptionPane;

public class Banco {

    private String nombre;
    private Cuenta cuentaBanco;
    private List<Cuenta> listaCuentas = new ArrayList<>();
    private List<Cliente> listaClientes = new ArrayList<>();
    private List<Beneficiario> listaBeneficiarios = new ArrayList<Beneficiario>();

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

    public Cuenta getCuentaBanco() {
        return cuentaBanco;
    }

    public void setCuentaBanco(Cuenta capitalBanco) {
        this.cuentaBanco = capitalBanco;
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

    public void retirarDinero(Cuenta cuenta, Double cantidadRetiro) {

        Double dineroCuenta = cuenta.getSaldoCuenta();

        if (dineroCuenta > cantidadRetiro) {
            cuenta.setSaldoCuenta(dineroCuenta - cantidadRetiro);
            JOptionPane.showMessageDialog(null, String.format("Se retiraron %.2f desde la cuenta %s",
                    cantidadRetiro, cuenta.getNumeroCuentaBanco()));
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo hacer el retiro de dinero");
        }
    }

    /**
     * 
     * @param cuenta
     */
    public void consultarSaldo(Cuenta cuenta) {

        JOptionPane.showMessageDialog(null, String.format("El saldo de la cuenta es: %.2f", cuenta.getSaldoCuenta()));
    }

    /**
     * Función para transferir dinero. Crea dos parámetros Double con getSaldoCuenta
     * y luego los compara.
     * 
     * @param cuentaDestino
     * @param cuentaOrigen
     * @param cantidadTransferida
     */
    public void transferirDineroOtraCuenta(Cuenta cuentaDestino, Cuenta cuentaOrigen, Double cantidadTransferida) {

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

    public void depositarDinero(Cuenta cuenta, Double dineroDeposito) {

        Double saldoCuenta = cuenta.getSaldoCuenta();
        Double saldoBanco = cuentaBanco.getSaldoCuenta();
        if (dineroDeposito > saldoCuenta) {
            JOptionPane.showMessageDialog(null, "No se pudo hacer el deposito");
        }
        else {
            cuentaBanco.setSaldoCuenta(dineroDeposito + saldoBanco);
            cuenta.setSaldoCuenta(saldoCuenta - dineroDeposito);
        }
    }

    // Función para hacer que el código no se vea tan feo.
    public static Double preguntarSaldo(String mensaje) {
        return Double.parseDouble(JOptionPane.showInputDialog(null, mensaje));
    }

}

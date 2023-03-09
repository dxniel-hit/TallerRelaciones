package Banco.ws_Banco;

import javax.swing.JOptionPane;
import java.util.*;

public class Cuenta {

    private String nombresTitular;
    private String apellidosTitular;
    private String numeroCuentaBanco;
    private CategoriaCuenta tipoDeCuenta;
    private Double saldoCuenta;
    private Cliente cuentaTitular;
    private Banco bancoAsociado;
    private List<Beneficiario> listaBeneficiarios = new ArrayList<Beneficiario>();

    public Cuenta() {
    }

    public Cuenta(String nombresTitular, String apellidosTitular, String numeroCuentaBanco,
            CategoriaCuenta tipoDeCuenta, Double saldoCuenta, Banco bancoAsociado) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.numeroCuentaBanco = numeroCuentaBanco;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldoCuenta = saldoCuenta;
        this.bancoAsociado = bancoAsociado;
    }

    public Cuenta(String nombresTitular, String apellidosTitular, String numeroCuentaBanco,
            CategoriaCuenta tipoDeCuenta, Double saldoCuenta, Cliente cuentaTitular, Banco bancoAsociado,
            List<Beneficiario> listaBeneficiarios) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.numeroCuentaBanco = numeroCuentaBanco;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldoCuenta = saldoCuenta;
        this.cuentaTitular = cuentaTitular;
        this.bancoAsociado = bancoAsociado;
        this.listaBeneficiarios = listaBeneficiarios;
    }

    public String getNombresTitular() {
        return nombresTitular;
    }

    public void setNombresTitular(String nombresTitular) {
        this.nombresTitular = nombresTitular;
    }

    public String getApellidosTitular() {
        return apellidosTitular;
    }

    public void setApellidosTitular(String apellidosTitular) {
        this.apellidosTitular = apellidosTitular;
    }

    public String getNumeroCuentaBanco() {
        return numeroCuentaBanco;
    }

    public void setNumeroCuentaBanco(String numeroCuentaBanco) {
        this.numeroCuentaBanco = numeroCuentaBanco;
    }

    public CategoriaCuenta getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(CategoriaCuenta tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public Double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(Double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public Cliente getCuentaTitular() {
        return cuentaTitular;
    }

    public void setCuentaTitular(Cliente cuentaTitular) {
        this.cuentaTitular = cuentaTitular;
    }

    @Override
    public String toString() {
        return "nombresTitular=" + nombresTitular + ", apellidosTitular=" + apellidosTitular
                + ", numeroCuentaBanco=" + numeroCuentaBanco + ", tipoDeCuenta=" + tipoDeCuenta + ", saldoCuenta="
                + saldoCuenta;
    }

    /**
     * Imprime los detalles de la cuenta bancaria en pantalla
     * 
     * @param nombresTitular
     * @param apellidosTitular
     * @param numeroCuentaBanco
     * @param tipoDeCuenta
     * @param saldoCuenta
     */
    public void imprimirAtributosEnPantalla() {
        JOptionPane.showMessageDialog(null, "Detalles de la cuenta: \n" + this.toString());
    }

    /**
     * Consulta el saldo de una cuenta.
     */
    public void consultarSaldo() {
        JOptionPane.showMessageDialog(null, String.format("El saldo de su cuenta es: %.2f", this.getSaldoCuenta()));
    }

    /**
     * Añade saldo a una cuenta.
     * 
     * @param saldoAniadir
     */
    public void depositarDinero(Banco bancoAsociado) {
        Cuenta cuentaBanco = bancoAsociado.getCuentaBanco();
        Double saldoAniadir = Banco.preguntarSaldo(
                String.format("Saldo que desea depositar: \n Saldo actual: %.2f", this.getSaldoCuenta()));
        if (comprobarSaldo(saldoAniadir)) {
            JOptionPane.showMessageDialog(null, String.format("Saldo depositado sin éxito"));
        } else {
            this.setSaldoCuenta(this.getSaldoCuenta() - saldoAniadir);
            cuentaBanco.setSaldoCuenta(cuentaBanco.getSaldoCuenta() + saldoAniadir);
            JOptionPane.showMessageDialog(null,
                    String.format("Saldo depositado con éxito.\n Su saldo actual es: %.2f", this.getSaldoCuenta()));
        }
    }

    /**
     * Saca saldo de una cuenta verificando si el saldo retirado no sea mayor a el
     * saldo actual.
     * 
     * @param saldoSacado
     */
    public void retirarDinero() {
        Double saldoSacado = Banco.preguntarSaldo(
                String.format("Saldo actual: %.2f \nSaldo que desea sacar a su cuenta:", this.getSaldoCuenta()));
        if (comprobarSaldo(saldoSacado)) {
            JOptionPane.showMessageDialog(null, "No se pudo hacer la transferencia");
        } else if (saldoSacado > this.getSaldoCuenta()) {
            JOptionPane.showMessageDialog(null, "Error: No puede sacar más saldo del que tiene disponible.");
        } else {
            setSaldoCuenta(saldoCuenta - saldoSacado);
            JOptionPane.showMessageDialog(null, String
                    .format("Saldo retirado con éxito.\nEl saldo actual de su cuenta es: %.2f", this.getSaldoCuenta()));
        }
    }

    public static boolean comprobarSaldo(Double saldo) {
        if (saldo.isNaN() || saldo == 0 || saldo < 0) {
            return true;
        }
        return false;
    }

    /*
     * Función rápida para salirme de un gallo
     */

}
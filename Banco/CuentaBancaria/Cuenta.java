package Banco.CuentaBancaria;

import javax.swing.JOptionPane;

public class Cuenta {

    private String nombresTitular;
    private String apellidosTitular;
    private String numeroCuentaBanco;
    private String tipoDeCuenta;
    private Double saldoCuenta;

    public Cuenta() {
    }

    public Cuenta(String nombresTitular, String apellidosTitular, String numeroCuentaBanco, CategoriaCuenta categoria,
            Double saldoCuenta) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.numeroCuentaBanco = numeroCuentaBanco;
        this.saldoCuenta = saldoCuenta;
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

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public Double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(Double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
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
    public void imprimirAtributosEnPantalla(Cuenta cuenta) {
        JOptionPane.showMessageDialog(null, "Detalles de la cuenta: \n" + cuenta.toString());
    }

    /**
     * Consulta el saldo de una cuenta.
     */
    public void consultarSaldo(Cuenta cuenta) {
        JOptionPane.showMessageDialog(null, String.format("El saldo de su cuenta es: %f", cuenta.getSaldoCuenta()));
    }

    /**
     * Añade saldo a una cuenta.
     * 
     * @param saldoAniadir
     */
    public void aniadirSaldo(Cuenta cuentaA, Double saldoAniadir) {
        cuentaA.setSaldoCuenta(cuentaA.getSaldoCuenta()+saldoAniadir);
    }

    /**
     * Saca saldo de una cuenta verificando si el saldo retirado no sea mayor a el
     * saldo actual.
     * 
     * @param saldoSacado
     */
    public void sacarSaldo(Double saldoSacado) {
        if (saldoSacado > this.getSaldoCuenta())
            JOptionPane.showMessageDialog(null, "Error: No puede sacar más saldo del que tiene disponible.");
        else {
            setSaldoCuenta(saldoCuenta - saldoSacado);
            JOptionPane.showMessageDialog(null, "Saldo retirado con éxito.");
        }
    }

    /*
     * Función rápida para salirme de un gallo
     */

}
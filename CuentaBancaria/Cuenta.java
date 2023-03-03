package CuentaBancaria;

import javax.swing.JOptionPane;

public class Cuenta {

    private String nombresTitular;
    private String apellidosTitular;
    private String numeroCuentaBanco;
    private String tipoDeCuenta;
    private Double saldoCuenta;

    public Cuenta() {
    }

    public Cuenta(String nombresTitular, String apellidosTitular, String numeroCuentaBanco, String tipoDeCuenta,
            Double saldoCuenta) {
        this.nombresTitular = nombresTitular;
        this.apellidosTitular = apellidosTitular;
        this.numeroCuentaBanco = numeroCuentaBanco;
        this.tipoDeCuenta = tipoDeCuenta;
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
    public void imprimirAtributosEnPantalla(String nombresTitular, String apellidosTitular, String numeroCuentaBanco,
            String tipoDeCuenta,
            Double saldoCuenta) {
        JOptionPane.showMessageDialog(null, String.format(
                "El estado actual de su cuenta es: \nNombres del titular: %s\nApellidos del titular: %s\n Número de la cuenta bancaria: %s\nTipo de cuenta: %s\nSaldo de la cuenta: %f",
                nombresTitular, apellidosTitular, numeroCuentaBanco, tipoDeCuenta, saldoCuenta));
    }

    /**
     * Consulta el saldo de una cuenta.
     */
    public void consultarSaldo() {
        JOptionPane.showMessageDialog(null, String.format("El saldo de su cuenta es: %f", this.saldoCuenta));
    }

    /**
     * Añade saldo a una cuenta.
     * 
     * @param saldoAniadir
     */
    public void aniadirSaldo(int saldoAniadir) {
        setSaldoCuenta(saldoCuenta + saldoAniadir);
    }

    /**
     * Saca saldo de una cuenta verificando si el saldo retirado no sea mayor a el
     * saldo actual.
     * 
     * @param saldoSacado
     */
    public void sacarSaldo(int saldoSacado) {
        if (saldoSacado > saldoCuenta)
            JOptionPane.showMessageDialog(null, "Error: No puede sacar más saldo del que tiene disponible.");
        else {
            setSaldoCuenta(saldoCuenta - saldoSacado);
            JOptionPane.showMessageDialog(null, "Saldo retirado con éxito.");
        }
    }

}
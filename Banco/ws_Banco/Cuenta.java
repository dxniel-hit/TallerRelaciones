package Banco.ws_Banco;

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
        this.tipoDeCuenta = ""+ CategoriaCuenta.SALDO;
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
    public void aniadirSaldo() {
        Double saldoAniadir = Banco.preguntarSaldo(
                String.format("Saldo que desea añadir a su cuenta: \n Saldo actual: %.2f", this.getSaldoCuenta()));
        if (comprobarSaldo(saldoAniadir)) {
            JOptionPane.showMessageDialog(null, String.format("Saldo añadido sin éxito"));
        } else {
            this.setSaldoCuenta(this.getSaldoCuenta() + saldoAniadir);
            JOptionPane.showMessageDialog(null,
                    String.format("Saldo añadido con éxito.\n Su saldo actual es: %.2f", this.getSaldoCuenta()));
        }
    }

    /**
     * Saca saldo de una cuenta verificando si el saldo retirado no sea mayor a el
     * saldo actual.
     * 
     * @param saldoSacado
     */
    public void sacarSaldo() {
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
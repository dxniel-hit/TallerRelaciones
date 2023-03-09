package Banco.ws_Banco;

import javax.swing.*;
import java.util.*;

public class Beneficiario {

    private String nombreBeneficiario;
    private Cuenta cuentaAsociada;
    private Restriccion restriccion;
    private List<Cuenta> listaCuentasAsociadas = new ArrayList<Cuenta>();
    private Banco bancoAsociado;

    public Beneficiario() {
    }

    public Beneficiario(String nombreBeneficiario, Cuenta cuentaAsociada, Restriccion restriccion,
            List<Cuenta> listaCuentasAsociadas, Banco bancoAsociado) {
        this.nombreBeneficiario = nombreBeneficiario;
        this.cuentaAsociada = cuentaAsociada;
        this.restriccion = restriccion;
        this.listaCuentasAsociadas = listaCuentasAsociadas;
        this.bancoAsociado = bancoAsociado;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public Cuenta getCuentaAsociada() {
        return cuentaAsociada;
    }

    public void setCuentaAsociada(Cuenta cuentaAsociada) {
        this.cuentaAsociada = cuentaAsociada;
    }

    public Restriccion getRestriccion() {
        return restriccion;
    }

    public void setRestriccion(Restriccion restriccion) {
        this.restriccion = restriccion;
    }

    public List<Cuenta> getListaCuentasAsociadas() {
        return listaCuentasAsociadas;
    }

    public void setListaCuentasAsociadas(List<Cuenta> listaCuentasAsociadas) {
        this.listaCuentasAsociadas = listaCuentasAsociadas;
    }

    public Banco getBancoAsociado() {
        return bancoAsociado;
    }

    public void setBancoAsociado(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }

    private void retirarDinero() {

        Double saldoCuentaAsociada = cuentaAsociada.getSaldoCuenta();
        Double dineroRetirar = Banco.preguntarSaldo("Cuanto desea retirar: ");

        if (Cuenta.comprobarSaldo(dineroRetirar)) {
            JOptionPane.showMessageDialog(null, "Error");
        }

        if (dineroRetirar > restriccion.getRangoSuperior()) {
            JOptionPane.showMessageDialog(null, "Error");
        }

        else {
            cuentaAsociada.setSaldoCuenta(saldoCuentaAsociada - dineroRetirar);
        }
    }

}

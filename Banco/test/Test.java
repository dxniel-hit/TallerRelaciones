package Banco.test;

import java.util.*;

import javax.swing.JOptionPane;

import Banco.ws_Banco.Banco;
import Banco.ws_Banco.CategoriaCuenta;
import Banco.ws_Banco.Cuenta;

public class Test {

        public static void main(String[] args) {

                // Inicializo algunas variables para probar las funciones. Puede cambiar los
                // saldos si desea.
                Cuenta cuenta1 = new Cuenta("Daniel", "Correa", "1", CategoriaCuenta.AHORRO, 50000.0, null);
                Cuenta cuenta2 = new Cuenta("Daniel", "Correa", "2", CategoriaCuenta.SALDO, 55000.0, null);
                Cuenta cuenta3 = new Cuenta("Daniel", "Correa", "3", CategoriaCuenta.SALDO, 60000.0, null);

                ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>(Arrays.asList(cuenta1, cuenta2, cuenta3));

                Banco banco = new Banco("Banco UQ", listaCuentas);

                /**
                 * Prueba de la función transferirDinero.
                 */
                JOptionPane.showMessageDialog(null,
                                String.format("Inicio de la transferencia\nSaldo actual de ambas cuentas:\nCuenta 1: %.2f $\nCuenta 2: %.2f $",
                                                cuenta2.getSaldoCuenta(),
                                                cuenta3.getSaldoCuenta()));

                banco.transferirDineroOtraCuenta(cuenta2, cuenta3, Banco.preguntarSaldo("Saldo que desea transferir"));

                JOptionPane.showMessageDialog(null,
                                String.format("Resultado de la transferencia\nSaldo actual de ambas cuentas:\nCuenta 1: %.2f\nCuenta 2: %.2f",
                                                cuenta2.getSaldoCuenta(),
                                                cuenta3.getSaldoCuenta()));

                /*
                 * Prueba de las funciones de Cuenta Bancaria
                 * Estos métodos los hice distintos, use this para así evitar crear la instancia
                 * de Banco como parámetro y evitar usar el constructor vacio.
                 */

                cuenta1.imprimirAtributosEnPantalla();

                cuenta3.consultarSaldo();

                cuenta3.depositarDinero(banco);

                cuenta2.retirarDinero();
        }
}

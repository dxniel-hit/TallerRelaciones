package Banco.test;

import java.util.*;

import javax.swing.JOptionPane;

import Banco.CuentaBancaria.Banco;
import Banco.CuentaBancaria.CategoriaCuenta;
import Banco.CuentaBancaria.Cuenta;

public class Test {

        public static void main(String[] args) {

                // Inicializo algunas variables para probar las funciones. Puede cambiar los
                // saldos si desea.
                Cuenta cuenta1 = new Cuenta("Daniel", "Correa", "1", CategoriaCuenta.AHORRO, 50000.0);
                Cuenta cuenta2 = new Cuenta("Daniel", "Correa", "2", CategoriaCuenta.SALDO, 55000.0);
                Cuenta cuenta3 = new Cuenta("Daniel", "Correa", "3", CategoriaCuenta.SALDO, 60000.0);

                ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>(Arrays.asList(cuenta1, cuenta2, cuenta3));

                Banco banco = new Banco("Banco UQ", listaCuentas);

                /**
                 * Prueba de la función transferirDinero.
                 */
                JOptionPane.showMessageDialog(null,
                                String.format("Saldo actual de ambas cuentas:\nCuenta 1: %.2f $\nCuenta 2: %.2f $",
                                                cuenta2.getSaldoCuenta(),
                                                cuenta3.getSaldoCuenta()));

                // Esta parte es estática. My bad.
                banco.transferirDinero(cuenta2, cuenta3,
                                Banco.preguntarSaldo(String.format(
                                                "¿Cuánto dinero desea transferir?\nSaldo actual de la cuenta: %.2f",
                                                cuenta2.getSaldoCuenta())));

                JOptionPane.showMessageDialog(null,
                                String.format("Saldo actual de ambas cuentas:\nCuenta 1: %.2f\nCuenta 2: %.2f",
                                                cuenta2.getSaldoCuenta(),
                                                cuenta3.getSaldoCuenta()));

                /*
                 * Prueba de la función compararSaldos(). Le va a pedir un saldo para comparar.
                 */
                banco.compararSaldos(cuenta1);

                /*
                 * Prueba de las funciones de Cuenta Bancaria
                 * Estos métodos los hice distintos, use this para así evitar ponerlo
                 * como parámetro y evitar usar el constructor vacio.
                 */

                cuenta1.imprimirAtributosEnPantalla();

                cuenta3.consultarSaldo();

                cuenta3.aniadirSaldo();
                                
                cuenta2.sacarSaldo();
        }
}

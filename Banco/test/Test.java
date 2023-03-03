package Banco.test;
import java.util.ArrayList;
import java.util.Arrays;

import Banco.CuentaBancaria.Banco;
import Banco.CuentaBancaria.Cuenta;

public class Test {

    public static void main(String[] args) {

        Cuenta cuenta1 = new Cuenta("Daniel", "Correa", "1", "Ahorros", 50000.0);
        Cuenta cuenta2 = new Cuenta("Daniel", "Correa", "2", "Ahorros", 55000.0);
        Cuenta cuenta3 = new Cuenta("Daniel", "Correa", "3", "Ahorros", 60000.0);

        ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>(Arrays.asList(cuenta1, cuenta2, cuenta3));

        Banco banco = new Banco("Banco UQ", listaCuentas);

        /*
         * Función para comparar saldos, sirve.
         * System.out.println(banco.compararSaldos(cuenta1));
         * 
         * 
         */

        System.out.println(String.format("Saldo actual de ambas cuentas:\n %.2f\n %.2f", cuenta2.getSaldoCuenta(),
                cuenta3.getSaldoCuenta()));
        banco.transferirDinero(cuenta2, cuenta3, banco.preguntarSaldo());
        System.out.println(String.format("Saldo actual de ambas cuentas:\n %.2f\n %.2f", cuenta2.getSaldoCuenta(),
                cuenta3.getSaldoCuenta()));

    }

}

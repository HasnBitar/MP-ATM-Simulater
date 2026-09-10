package org.example;

import org.example.entities.Customer;
import org.example.logic.ATMOperations;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        ATMOperations atm = new ATMOperations();
        System.out.println(atm.CheckBalance(new Customer()));
    }
}

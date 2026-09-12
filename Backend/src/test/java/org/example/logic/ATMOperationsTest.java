package org.example.logic;

import org.example.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMOperationsTest {

    ATMOperations atmOperations;

    @BeforeEach
    void setUp() {
        atmOperations = new ATMOperations();
    }


    @Test
    void checkBalance_whenCustomerNull_thenReturnZero() {

        double value = atmOperations.CheckBalance(null);
        assertEquals(0.0, value);
    }

    @Test
    void checkBalance_whenCustomer_thenReturnBalance() {
        Customer customer = new Customer();
        customer.setBalance(1000);
        double value = atmOperations.CheckBalance(customer);
        assertEquals(1000.0, value);
    }

    @Test
    void deposit() {
    }

    @Test
    void withdraw() {
    }

    @Test
    void transfer() {
    }

    @Test
    void checkMailPassword() {
    }
}
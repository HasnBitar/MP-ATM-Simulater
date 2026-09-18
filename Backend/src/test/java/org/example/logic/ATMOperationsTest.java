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
    void deposit_whenCustomerNull_thenReturnFalse() {

        boolean value = atmOperations.deposit(0.0, null);
        assertFalse(value);
    }

    @Test
    void deposit_whenAmountLessEqualZero_thenReturnFalse() {

        boolean value = atmOperations.deposit(0.0, new Customer());
        assertFalse(value);
    }

    @Test
    void deposit_whenCustomerAndAmount_thenReturnTrue() {

        boolean value = atmOperations.deposit(1.0, new Customer());
        assertTrue(value);
    }

    @Test
    void withdraw_whenCustomerNull_thenReturnFalse() {
        boolean value = atmOperations.withdraw(0.0, null);
        assertFalse(value);
    }

    @Test
    void withdraw_whenAmountLessEqualZero_thenReturnFalse() {
        boolean value = atmOperations.withdraw(0.0, new Customer());
        assertFalse(value);
    }

    @Test
    void withdraw_whenAmountBiggerThanBalance_thenReturnFalse() {

        Customer customer = new Customer();
        customer.setBalance(1000);

        boolean value = atmOperations.withdraw(2000, customer);
        assertFalse(value);
    }

    @Test
    void withdraw_whenAmountLessThanBalance_thenReturnTrue() {

        Customer customer = new Customer();
        customer.setBalance(2000);

        boolean value = atmOperations.withdraw(1000, customer);
        assertTrue(value);
    }

    @Test
    void transfer_whenSourceCustomerIsNull_thenReturnFalse() {

        boolean value = atmOperations.transfer(null, new Customer(), 0.0);
        assertFalse(value);
    }

    @Test
    void transfer_whenTargetCustomerIsNull_thenReturnFalse() {

        boolean value = atmOperations.transfer(new Customer(), null, 0.0);
        assertFalse(value);
    }

    @Test
    void transfer_whenAmountBiggerThanBalance_thenReturnFalse() {

        Customer sourceCustomer = new Customer();
        sourceCustomer.setBalance(1000);

        boolean value = atmOperations.transfer(sourceCustomer, new Customer(), 2000.0);
        assertFalse(value);
    }

    @Test
    void transfer_whenBalanceBiggerThanAmount_thenReturnTrue() {

        Customer sourceCustomer = new Customer();
        sourceCustomer.setBalance(1000);

        boolean value = atmOperations.transfer(sourceCustomer, new Customer(), 500);
        assertTrue(value);
    }

    @Test
    void checkMailPassword_whenEmailIsNull_thenReturnFalse() {
        boolean value = atmOperations.checkMailPassword(new Customer(), null, "123");
        assertFalse(value);
    }

    @Test
    void checkMailPassword_whenPasswordIsNull_thenReturnFalse() {
        boolean value = atmOperations.checkMailPassword(new Customer(), "x@x.xom", null);
        assertFalse(value);
    }

    @Test
    void checkMailPassword_whenCustomerIsNull_thenReturnFalse() {
        boolean value = atmOperations.checkMailPassword(null, "x@x.xom", "null");
        assertFalse(value);
    }

    @Test
    void checkMailPassword_whenPasswordIsWrong_thenReturnFalse() {

        Customer customer = new Customer();
        customer.setEmail("x@x.com");
        customer.setPassword("123");

        boolean value = atmOperations.checkMailPassword(customer, "x@x.xom", "456");
        assertFalse(value);
    }

    @Test
    void checkMailPassword_whenPasswordAndMailTrue_thenReturnTrue() {

        Customer customer = new Customer();
        customer.setEmail("x@x.com");
        customer.setPassword("123");

        boolean value = atmOperations.checkMailPassword(customer, "x@x.com", "123");
        assertTrue(value);
    }
}
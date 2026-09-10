package org.example.logic;

import org.example.entities.Customer;

import java.util.logging.Logger;

public class ATMOperations {

    private Logger logger = Logger.getLogger(ATMOperations.class.getName());

    public double CheckBalance(Customer customer) {
        if (customer != null) {
            logger.info("Checking Balance");
            return customer.getBalance();
        }
        logger.warning("Customer is null");
        return 0.0;
    }
    public boolean Deposit(double amount, Customer customer) {
        if (customer != null) {
            if (amount > 0) {
                logger.info("Depositing");
                customer.setBalance(customer.getBalance() + amount);
                return true;
            }
            logger.warning("No deposited amount");
            return false;
        }
        logger.warning("Customer is null");
        return false;
    }
    public boolean Withdraw(double amount, Customer customer) {
        if (customer != null) {
            if (customer.getBalance() < amount) {
                logger.warning("not enough balance");
                return false;
            }
            logger.info("Withdrawing");
            customer.setBalance(customer.getBalance() - amount);
            return true;
        }
        logger.warning("Customer is null");
        return false;
    }
    public boolean Transfer(Customer sourceCustomer, Customer targetCustomer, double amount) {
        if (sourceCustomer == null || targetCustomer == null) {
            logger.warning("One of the Customers or Both are missing");
            return false;
        }
        if (sourceCustomer.getBalance() < amount) {
            logger.warning("Not enough balance");
            return false;
        }
        logger.info(String.format("Transferring %.2f", amount));
        Withdraw(amount, sourceCustomer);
        Deposit(amount, targetCustomer);
        return true;
    }

    public boolean checkMailPassword(Customer customer, String mail, String password) {
        if (customer == null) {
            logger.warning("Customer is null");
            return false;
        }
        if (mail == null || password == null) {
            logger.warning("Mail or password is null");
            return false;
        }
        return customer.getEmail().equals(mail) && customer.getPassword().equals(password);
    }

}

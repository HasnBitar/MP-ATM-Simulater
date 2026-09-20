package org.example.sql.dao;

import org.example.entities.Customer;
import org.example.sql.connection.SqlConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomerDAO {

    private static Logger logger = Logger.getLogger(CustomerDAO.class.getName());

    //TODO
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet = null;

        try (Connection conn = SqlConnection.startConnection();
             Statement statement = conn.createStatement();){

            logger.info("Getting all customers");

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from Customer";
            resultSet = statement.executeQuery(selectSql);
            System.out.println("after statement");
            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(4));
                customers.add(new Customer());
            }

            return customers;
        }catch(SQLException e){
            e.printStackTrace();
            return  null;
        }

    }
    //TODO
    public Customer createCustomer(Customer customer) throws SQLException { return null;}
    //TODO
    public Customer getCustomerById(int id) throws SQLException { return null;}
    //TODO
    public Customer updateCustomer(int customerId, Customer customer) throws SQLException { return null;}
    //TODO
    public Customer deleteCustomer(int customerId) throws SQLException { return null;}

}

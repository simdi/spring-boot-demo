package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.models.Customer;


@Component
public class CustomerService {
  @Autowired
  private CustomerDAO customerDAO;

  public Customer addCustomer(Customer customer) {
    return customerDAO.save(customer);
  }

  public List<Customer> getCustomers() {
    return customerDAO.findAll();
  }

  public Customer getCustomer(int id) {
    Optional<Customer> optionalCustomer = customerDAO.findById(id);
    if (!optionalCustomer.isPresent()) {
      throw new CustomerNotFoundException("Customer record not found.");
    }
    return optionalCustomer.get();
  }

  public Customer updateCustomer(int id, Customer customer) {
    customer.setId(id);
    return customerDAO.save(customer);
  }

  public void deleteCustomer(int id) {
    customerDAO.deleteById(id);
  }
}
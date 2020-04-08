package com.example.demo.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CustomerDAO;
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
    return customerDAO.findById(id).get();
  }

  public Customer updateCustomer(int id, Customer customer) {
    customer.setId(id);
    return customerDAO.save(customer);
  }

  public void deleteCustomer(int id) {
    customerDAO.deleteById(id);
  }
}
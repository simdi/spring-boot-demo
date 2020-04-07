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
  private List<Customer> customerList = new CopyOnWriteArrayList<>();

  public Customer addCustomer(Customer customer) {
    return customerDAO.save(customer);
  }

  public List<Customer> getCustomers() {
    return customerDAO.findAll();
  }

  public Customer getCustomer(int id) {
    return customerList.stream().filter(c -> c.getId() == id).findFirst().get();
  }

  public Customer updateCustomer(int id, Customer customer) {
    customerList
      .stream()
      .forEach(c -> {
        if (c.getId() == id) {
          c.setFirstName(customer.getFirstName());
          c.setLastName(customer.getLastName());
          c.setEmail(customer.getEmail());
        }
      });

    return getCustomer(id);
  }

  public void deleteCustomer(int id) {
    customerList.stream().forEach(c -> {
      if (c.getId() == id) {
        customerList.remove(c);
      }
    });
  }
}
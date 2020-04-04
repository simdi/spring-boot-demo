package com.example.demo.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.example.demo.models.Customer;

public class CustomerService {
  private int customerIdCount = 1;
  private List<Customer> customerList = new CopyOnWriteArrayList<>();

  public Customer addCustomer(Customer customer) {
    customer.setId(customerIdCount);
    customerList.add(customer);
    customerIdCount++;
    return customer;
  }

  public List<Customer> getCustomers() {
    return customerList;
  }

  public Customer getCustomer(int customerId) {
    return customerList.stream().filter(c -> c.getId() == customerId).findFirst().get();
  }

  public Customer updateCustomer(int id, Customer customer) {
    customerList.stream().forEach(c -> {
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
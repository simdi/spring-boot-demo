package com.example.demo.services;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import com.example.demo.models.Customer;


@Component
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
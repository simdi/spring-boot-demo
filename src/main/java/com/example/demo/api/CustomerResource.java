package com.example.demo.api;

import java.util.List;

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
  @Autowired
  private CustomerService customerService;

  @GetMapping
  public List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

  @GetMapping(value = "/{id}")
  public Customer getCustomer(@PathVariable("id") int id) {
    return customerService.getCustomer(id);
  }

  @PostMapping
  public Customer addCustomer(@RequestBody Customer customer) {
    return customerService.addCustomer(customer);
  }

  @PutMapping(value = "/{id}")
  public Customer updatedCustomer(@PathVariable("id") int id,@RequestBody Customer customer) {
    return customerService.updateCustomer(id, customer);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteCustomer(@PathVariable("id") int id) {
    customerService.deleteCustomer(id);
  }
}
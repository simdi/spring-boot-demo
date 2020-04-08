package com.example.demo.api;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
  @GetMapping
  public String Home() {
    return "Application is running..." + new Date();
  }
}
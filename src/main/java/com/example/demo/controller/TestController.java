package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/login")
  public String login(@RequestParam("username") String username) {
    return "login";
  }

  @GetMapping("/logout")
  public String logout() {
    return "logout";
  }
}

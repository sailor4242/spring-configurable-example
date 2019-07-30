package com.dzavorin.configurable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class Application {

  public static void main(String[] args) {
    System.out.println("Hello World!");

    SpringApplication.run(Application.class, args);

    Account account = new Account();

    account.testConfigurable();
  }

}

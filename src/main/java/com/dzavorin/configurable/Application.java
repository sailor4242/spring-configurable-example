package com.dzavorin.configurable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class Application {

  public static void main(String[] args) throws Exception {

    SpringApplication.run(Application.class, args);

    //via constructor
    Account accountConstructor = new Account();
    System.out.println(accountConstructor.helloAccount());

    //via reflection
    Account accountReflection = (Account) Account.class.getDeclaredConstructors()[0].newInstance();
    System.out.println(accountReflection.helloAccount());
  }

}

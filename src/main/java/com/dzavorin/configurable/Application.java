package com.dzavorin.configurable;

import com.dzavorin.configurable.cadence.HelloWorkflow;
import com.dzavorin.configurable.cadence.HelloWorkflowImpl;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.worker.Worker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication
@EnableSpringConfigured
public class Application {

  public static void main(String[] args) throws Exception {

    SpringApplication.run(Application.class, args);

    System.out.println("=== Configurable Demo ===");

    //via constructor
    Account accountConstructor = new Account();
    System.out.println(accountConstructor.helloAccount());

    //via reflection
    Account accountReflection = (Account) Account.class.getDeclaredConstructors()[0].newInstance();
    System.out.println(accountReflection.helloAccount());

  }

}

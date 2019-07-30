package com.dzavorin.configurable.cadence;

import com.dzavorin.configurable.Account;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import com.dzavorin.configurable.MyService;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true, preConstruction = true)
public class HelloWorkflowImpl implements HelloWorkflow {

  @Autowired
  private MyService myService;

  private Account account;

  @PostConstruct
  public void init() {
    account = new Account();
    System.out.println("Hello from post construct -  " + account.helloAccount());
  }

  @Override
  public String process() {
    return myService.returnHello() + " from Cadence";
  }
}

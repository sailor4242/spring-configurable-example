package com.dzavorin.configurable;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true, preConstruction = true)
public class Account {

  @Autowired
  private MyService service;

  public String helloAccount() {
    return service.returnHello() + " " + this.getClass().getSimpleName();
  }

}

package com.dzavorin.configurable.cadence;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import com.dzavorin.configurable.MyService;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true, preConstruction = true)
public class HelloWorkflowImpl implements HelloWorkflow {

  @Autowired
  private MyService myService;

  @Override
  public String process() {
    return myService.returnHello() + " from Cadence";
  }
}

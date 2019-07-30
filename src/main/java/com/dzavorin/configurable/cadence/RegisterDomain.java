package com.dzavorin.configurable.cadence;

import com.uber.cadence.DomainAlreadyExistsError;
import com.uber.cadence.RegisterDomainRequest;
import com.uber.cadence.serviceclient.IWorkflowService;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("cadence")
@RequiredArgsConstructor
public class RegisterDomain implements CommandLineRunner {

  @Autowired
  private final CadenceProperties cadenceProperties;

  @Override
  public void run(String... strings) throws Exception {
    log.debug("trying to register domain :{} using host:{} and port:{}", cadenceProperties.getDomain(),
        cadenceProperties.getHost(), cadenceProperties.getPort());

    IWorkflowService cadenceService = new WorkflowServiceTChannel(
        cadenceProperties.getHost(), cadenceProperties.getPort());
    RegisterDomainRequest request = new RegisterDomainRequest();
    request.setDescription("sample domain");
    request.setEmitMetric(false);
    request.setName(cadenceProperties.getDomain());
    int retentionPeriodInDays = 5;
    request.setWorkflowExecutionRetentionPeriodInDays(retentionPeriodInDays);
    try {
      cadenceService.RegisterDomain(request);
      log.debug("Successfully registered domain {} with retentionDays={}", cadenceProperties.getDomain(),
          retentionPeriodInDays);
    } catch (DomainAlreadyExistsError e) {
      log.error("domain  already exists {} {}", cadenceProperties.getDomain(), e);
    }

  }
}

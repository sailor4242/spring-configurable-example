package com.dzavorin.configurable.cadence;

import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.worker.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("cadence")
@RequiredArgsConstructor
public class CadenceWorker implements CommandLineRunner {

  private final CadenceProperties cadenceProperties;

  @Override
  public void run(String... strings) throws Exception {
    System.out.println("=== Cadence Demo ===");

    String TASK_LIST_PARENT = "tasklist";
    // Start a worker that hosts both parent and child workflow implementations.
    Worker.Factory factory = new Worker.Factory(cadenceProperties.getDomain());
    Worker worker = factory.newWorker(TASK_LIST_PARENT);
    worker.registerWorkflowImplementationTypes(HelloWorkflowImpl.class);

    // Start listening to the workflow and activity task lists.
    factory.start();

    // Start a workflow execution. Usually this is done from another program.
    WorkflowClient workflowClient = WorkflowClient.newInstance(cadenceProperties.getHost(),
        cadenceProperties.getPort(), cadenceProperties.getDomain());
    // Get a workflow stub using the same task list the worker uses.
    HelloWorkflow workflow = workflowClient.newWorkflowStub(HelloWorkflow.class);

    // Execute a workflow waiting for it to complete.
    String greeting = workflow.process();
    System.out.println(greeting);

    System.exit(0);
  }

}

package com.dzavorin.configurable.cadence;

import com.uber.cadence.workflow.WorkflowMethod;

public interface HelloWorkflow {

  @WorkflowMethod(executionStartToCloseTimeoutSeconds = 100, taskList = "tasklist")
  String process();

}

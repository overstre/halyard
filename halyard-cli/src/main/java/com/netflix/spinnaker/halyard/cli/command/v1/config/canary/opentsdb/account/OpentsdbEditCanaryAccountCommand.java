package com.netflix.spinnaker.halyard.cli.command.v1.config.canary.opentsdb.account;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.canary.account.AbstractEditCanaryAccountCommand;
import com.netflix.spinnaker.halyard.config.model.v1.canary.AbstractCanaryAccount;
import com.netflix.spinnaker.halyard.config.model.v1.canary.opentsdb.OpentsdbCanaryAccount;

@Parameters(separators = "=")
public class OpentsdbEditCanaryAccountCommand extends AbstractEditCanaryAccountCommand<OpentsdbCanaryAccount> {

  @Override
  protected String getServiceIntegration() {
    return "Opentsdb";
  }

  @Parameter(
          names = "--base-url",
          description = "The base URL to the Opentsdb server."
  )
  private String baseUrl;

    @Override
  protected AbstractCanaryAccount editAccount(OpentsdbCanaryAccount account) {
    account.setEndpoint(isSet(baseUrl) ? new OpentsdbCanaryAccount.Endpoint().setBaseUrl(baseUrl) : account.getEndpoint());

    return account;
  }
}

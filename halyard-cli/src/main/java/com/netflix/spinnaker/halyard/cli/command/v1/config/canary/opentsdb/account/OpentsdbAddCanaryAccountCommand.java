package com.netflix.spinnaker.halyard.cli.command.v1.config.canary.opentsdb.account;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.canary.account.AbstractAddCanaryAccountCommand;
import com.netflix.spinnaker.halyard.config.model.v1.canary.AbstractCanaryAccount;
import com.netflix.spinnaker.halyard.config.model.v1.canary.Canary;
import com.netflix.spinnaker.halyard.config.model.v1.canary.opentsdb.OpentsdbCanaryAccount;

@Parameters(separators = "=")
public class OpentsdbAddCanaryAccountCommand extends AbstractAddCanaryAccountCommand {

  @Override
  protected String getServiceIntegration() {
    return "Opentsdb";
  }

  @Parameter(
          names = "--base-url",
          required = true,
          description = "The base URL to the Opentsdb server."
  )
  private String baseUrl;

  @Override
  protected AbstractCanaryAccount buildAccount(Canary canary, String accountName) {
    OpentsdbCanaryAccount account = (OpentsdbCanaryAccount)new OpentsdbCanaryAccount().setName(accountName);

    account.setEndpoint(new OpentsdbCanaryAccount.Endpoint().setBaseUrl(baseUrl));

    return account;
  }

  @Override
  protected AbstractCanaryAccount emptyAccount() {
    return new OpentsdbCanaryAccount();
  }
}

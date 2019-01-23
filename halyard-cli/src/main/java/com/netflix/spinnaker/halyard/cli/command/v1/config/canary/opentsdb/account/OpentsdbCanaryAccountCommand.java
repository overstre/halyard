package com.netflix.spinnaker.halyard.cli.command.v1.config.canary.opentsdb.account;

import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.canary.account.AbstractCanaryAccountCommand;

/**
 * Interact with the Opentsdb service integration
 */
@Parameters(separators = "=")
public class OpentsdbCanaryAccountCommand extends AbstractCanaryAccountCommand {

  @Override
  protected String getServiceIntegration() {
    return "Opentsdb";
  }

  public OpentsdbCanaryAccountCommand() {
    registerSubcommand(new OpentsdbAddCanaryAccountCommand());
    registerSubcommand(new OpentsdbEditCanaryAccountCommand());
  }
}


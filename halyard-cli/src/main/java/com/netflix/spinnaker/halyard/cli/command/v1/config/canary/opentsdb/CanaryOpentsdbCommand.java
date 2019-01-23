package com.netflix.spinnaker.halyard.cli.command.v1.config.canary.opentsdb;

import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.config.AbstractConfigCommand;
import com.netflix.spinnaker.halyard.cli.command.v1.config.canary.EnableDisableCanaryServiceIntegrationCommandBuilder;
import com.netflix.spinnaker.halyard.cli.command.v1.config.canary.opentsdb.account.OpentsdbCanaryAccountCommand;
import com.netflix.spinnaker.halyard.cli.services.v1.Daemon;
import com.netflix.spinnaker.halyard.cli.services.v1.OperationHandler;
import com.netflix.spinnaker.halyard.cli.ui.v1.AnsiFormatUtils;
import com.netflix.spinnaker.halyard.config.model.v1.canary.Canary;
import com.netflix.spinnaker.halyard.config.model.v1.canary.opentsdb.OpentsdbCanaryServiceIntegration;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Parameters(separators = "=")
@Data
@EqualsAndHashCode(callSuper = false)
public class CanaryOpentsdbCommand extends AbstractConfigCommand {

  String commandName = OpentsdbCanaryServiceIntegration.NAME;

  String shortDescription = "Configure your canary analysis Opentsdb service integration settings for Spinnaker.";

  String longDescription = shortDescription;

  public CanaryOpentsdbCommand() {
    registerSubcommand(new EnableDisableCanaryServiceIntegrationCommandBuilder().setName("Opentsdb").setEnable(true).build());
    registerSubcommand(new EnableDisableCanaryServiceIntegrationCommandBuilder().setName("Opentsdb").setEnable(false).build());
    registerSubcommand(new OpentsdbCanaryAccountCommand());
  }

  @Override
  protected void executeThis() {
    String currentDeployment = getCurrentDeployment();

    new OperationHandler<Canary>()
        .setOperation(Daemon.getCanary(currentDeployment, !noValidate))
        .setFailureMesssage("Failed to load canary settings.")
        .setSuccessMessage("Configured canary settings: ")
        .setFormat(AnsiFormatUtils.Format.STRING)
        .setUserFormatted(true)
        .get();
  }
}

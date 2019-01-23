package com.netflix.spinnaker.halyard.config.model.v1.canary.opentsdb;

import com.netflix.spinnaker.halyard.config.model.v1.canary.AbstractCanaryAccount;
import com.netflix.spinnaker.halyard.config.model.v1.canary.AbstractCanaryServiceIntegration;
import com.netflix.spinnaker.halyard.config.model.v1.node.Secret;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class OpentsdbCanaryAccount extends AbstractCanaryAccount implements Cloneable {
  private Endpoint endpoint;
  private Set<AbstractCanaryServiceIntegration.SupportedTypes> supportedTypes = Collections.singleton(AbstractCanaryServiceIntegration.SupportedTypes.METRICS_STORE);

  @Data
  public static class Endpoint {
    private String baseUrl;
  }
}

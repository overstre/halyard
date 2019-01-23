package com.netflix.spinnaker.halyard.config.model.v1.canary.opentsdb;

import com.netflix.spinnaker.halyard.config.model.v1.canary.AbstractCanaryServiceIntegration;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class OpentsdbCanaryServiceIntegration extends AbstractCanaryServiceIntegration<OpentsdbCanaryAccount> implements Cloneable {
  public static final String NAME = "opentsdb";

  String name = NAME;
  private Long metadataCachingIntervalMS;
}

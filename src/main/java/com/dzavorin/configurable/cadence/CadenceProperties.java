package com.dzavorin.configurable.cadence;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties("cadence")
public class CadenceProperties {

  private String domain;
  private String host;
  private Integer port;

}

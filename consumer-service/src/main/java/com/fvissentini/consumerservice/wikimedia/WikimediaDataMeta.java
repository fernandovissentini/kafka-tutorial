package com.fvissentini.consumerservice.wikimedia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikimediaDataMeta {
  private String uri;
  private String requestId;
  private String id;
  private String dt;
  private String domain;
  private String stream;
  private String topic;
  private int partition;
  private long offset;

}

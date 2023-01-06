package com.fvissentini.producerservice.wikimedia;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WikimediaDataMetaDto {
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

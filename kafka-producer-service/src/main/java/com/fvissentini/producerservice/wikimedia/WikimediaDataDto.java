package com.fvissentini.producerservice.wikimedia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikimediaDataDto {

  private WikimediaDataMetaDto meta;
  private long id;
  private String type;
  private int namespace;
  private String title;
  private String comment;
  private long timestamp;
  private String user;
  private boolean bot;
  private boolean minor;
  private boolean patrolled;
  private JsonNode length;
  private JsonNode revision;
  private String serverUrl;
  private String serverName;
  private String serverScriptPath;
  private String wiki;
  private String parsedcomment;
}

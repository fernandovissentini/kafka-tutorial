package com.fvissentini.consumerservice.wikimedia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikimediaData {

  private WikimediaDataMeta meta;
  @Id
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
  private String serverUrl;
  private String serverName;
  private String serverScriptPath;
  private String wiki;
  private String parsedcomment;
}

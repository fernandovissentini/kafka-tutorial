package com.fvissentini.producerservice.wikimedia;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
record WikimediaData(
    String $schema,
    WikimediaDataMeta meta,
    long id,
    String type,
    int namespace,
    String title,
    String comment,
    long timestamp,
    String user,
    boolean bot,
    boolean minor,
    boolean patrolled,
    String length,
    String revision,
    String serverUrl,
    String serverName,
    String serverScriptPath,
    String wiki,
    String parsedcomment
    ) {
}

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
record WikimediaDataMeta(
    String uri,
    String requestId,
    String id,
    String dt,
    String domain,
    String stream,
    String topic,
    int partition,
    long offset
    ) {
}

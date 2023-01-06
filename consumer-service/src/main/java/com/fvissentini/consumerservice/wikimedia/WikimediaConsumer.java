package com.fvissentini.consumerservice.wikimedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class WikimediaConsumer {

  private final WikimediaService service;

  private final ObjectMapper mapper;

  @KafkaListener(topics = "wikimedia_recentchange", groupId = "wikimedia")
  @SneakyThrows
  public void receiveMessage(String data) {
    try {
      service.save(mapper.readValue(data, WikimediaData.class));
    } catch (Exception e) {
      log.error("Error reading message", e);
    }

  }


}

package com.fvissentini.producerservice.wikimedia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@AllArgsConstructor
@Slf4j
public class WikimediaChangeHandler implements EventHandler {

  private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();
  private final KafkaTemplate<String, WikimediaData> kafkaTemplate;
  private final String topic;

  @Override
  public void onOpen() throws Exception {

  }

  @Override
  public void onClosed() throws Exception {

  }

  @Override
  public void onMessage(String event, MessageEvent messageEvent) throws Exception {
    log.info("Message received {}", messageEvent.getData());
    try {
      kafkaTemplate.send(
          topic,
          MAPPER.readValue(messageEvent.getData(), WikimediaData.class)
      );
    } catch (Exception e) {
      log.error("Error: ",e);
    }
    System.out.println("stop");
  }

  @Override
  public void onComment(String comment) throws Exception {

  }

  @Override
  public void onError(Throwable t) {

  }
}

package com.fvissentini.producerservice.wikimedia;

import static com.fvissentini.producerservice.wikimedia.WikimediaTopicConfig.TOPIC_NAME;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WikimediaProducer {

  private KafkaTemplate<String, WikimediaDataDto> kafkaTemplate;

  @SneakyThrows
  @EventListener(ApplicationReadyEvent.class)
  public void sendMessage() {
    EventHandler handler = new WikimediaChangeHandler(kafkaTemplate, TOPIC_NAME);
    String url = "https://stream.wikimedia.org/v2/stream/recentchange";
    EventSource source = new EventSource.Builder(handler, URI.create(url)).build();
    source.start();

    TimeUnit.SECONDS.sleep(30);
  }

}

package com.fvissentini.kafkatutorial.kafka;

import static com.fvissentini.kafkatutorial.config.KafkaTopicConfig.TOPIC_NAME;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ProducerService {

  private KafkaTemplate<String, String> template;

  public void sendMessage(String message) {
    log.info("Sending message: {}", message);
    template.send(TOPIC_NAME, UUID.randomUUID().toString(), message);
  }

}

package com.fvissentini.kafkatutorial.kafka;

import static com.fvissentini.kafkatutorial.config.KafkaTopicConfig.TOPIC_NAME;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ProducerService {

  private KafkaTemplate<String, Message> template;

  @SneakyThrows
  public void sendMessage(String message) {
    log.info("Sending message: {}", message);
    UUID id = UUID.randomUUID();
    var messageToSend = MessageBuilder
        .withPayload(new Message(id, message))
        .setHeader(KafkaHeaders.TOPIC, TOPIC_NAME)
        .setHeader(KafkaHeaders.CORRELATION_ID, id.toString())
        .build();
    template.send(messageToSend);
  }

}

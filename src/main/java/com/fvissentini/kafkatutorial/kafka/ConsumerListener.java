package com.fvissentini.kafkatutorial.kafka;

import static com.fvissentini.kafkatutorial.config.KafkaTopicConfig.TOPIC_NAME;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerListener {

  @KafkaListener(topics = TOPIC_NAME, groupId = "myGroup")
  public void listenTopic(Message message) {
    log.info("Message reveived: {}", message);
  }

}

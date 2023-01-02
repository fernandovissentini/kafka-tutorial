package com.fvissentini.kafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  public NewTopic tutorialTopic() {
    return TopicBuilder.name("tutorial").build();
  }

}

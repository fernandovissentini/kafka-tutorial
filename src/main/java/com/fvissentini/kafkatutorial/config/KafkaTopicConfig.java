package com.fvissentini.kafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  public static final String TOPIC_NAME = "tutorialTopic";

  @Bean
  public NewTopic tutorialTopic() {
    return TopicBuilder
        .name(TOPIC_NAME)
        .partitions(1)
        .replicas(1)
        .build();
  }

}

package com.hendisantika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/12/21
 * Time: 19.12
 */
@Configuration
public class KafkaConfig {
    @Autowired
    private KafkaProperties kafkaProperties;

    @Value("${hendi.topic-name}")
    private String topicName;
}

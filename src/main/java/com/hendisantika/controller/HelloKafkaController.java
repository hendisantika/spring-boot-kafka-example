package com.hendisantika.controller;

import com.hendisantika.PracticalAdvice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/12/21
 * Time: 19.18
 */
@RestController
public class HelloKafkaController {

    private static final Logger logger = LoggerFactory.getLogger(HelloKafkaController.class);

    private final KafkaTemplate<String, Object> template;
    private final String topicName;
    private final int messagesPerRequest;
    private CountDownLatch latch;

    public HelloKafkaController(
            final KafkaTemplate<String, Object> template,
            @Value("${hendi.topic-name}") final String topicName,
            @Value("${hendi.messages-per-request}") final int messagesPerRequest) {
        this.template = template;
        this.topicName = topicName;
        this.messagesPerRequest = messagesPerRequest;
    }

    @GetMapping("/hello")
    public String hello() throws Exception {
        latch = new CountDownLatch(messagesPerRequest);
        IntStream.range(0, messagesPerRequest)
                .forEach(i -> this.template.send(topicName, String.valueOf(i),
                        new PracticalAdvice("A Practical Advice", i))
                );
        latch.await(60, TimeUnit.SECONDS);
        logger.info("All messages received");
        return "Hello Kafka!";
    }
}

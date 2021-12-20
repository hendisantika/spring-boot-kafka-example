package com.hendisantika;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-kafka-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/12/21
 * Time: 19.10
 */
public record PracticalAdvice(@JsonProperty("message") String message,
                              @JsonProperty("identifier") int identifier) {
}

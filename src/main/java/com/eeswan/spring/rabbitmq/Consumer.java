package com.eeswan.spring.rabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static Logger log = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "${myqueue}")
    public void handler(String message) {
        log.info("소비기 > " + message);
    }
}

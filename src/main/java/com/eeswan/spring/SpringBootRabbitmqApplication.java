package com.eeswan.spring;

        import com.eeswan.spring.rabbitmq.Producer;
        import org.springframework.amqp.core.Queue;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;
        import org.springframework.scheduling.annotation.EnableScheduling;
        import org.springframework.scheduling.annotation.Scheduled;

        import java.util.Date;

@EnableScheduling
@SpringBootApplication
public class SpringBootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqApplication.class, args);
    }

    @Value("${myqueue}")
    String queue;

    @Bean
    Queue queue() {
        return new Queue(queue, false);
    }

    @Autowired
    Producer producer;

    @Scheduled(fixedDelay = 500L)
    public void sendMessages() {
        producer.sendTo(queue, "안녕하세요! 지금시간은 " + new Date());
    }

    /*
    @Bean
    CommandLineRunner sender(Producer producer) {
        return args -> {
            producer.sendTo(queue,"안녕하세요! 반가워요~");
        };
    }
*/
}

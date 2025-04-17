package fiit.mdudak.producer;


import fiit.mdudak.dto.wikimedia.PageCreate;
import fiit.mdudak.producer.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

    @Autowired
    private WikimediaStream stream;

    @Autowired
    private Producer producer;

    @Override
    public void run(String... args) throws IOException {
        PageCreate record;
        while ((record = stream.getPageCreate()) != null) {
            producer.send(record);
        }
    }

}

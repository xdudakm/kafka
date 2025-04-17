package fiit.mdudak.producer.kafka;

import fiit.mdudak.dto.BpPageCreate;
import fiit.mdudak.dto.wikimedia.PageCreate;
import lombok.extern.java.Log;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Log
@Service
public class Producer {
    @Value("${spring.kafka.topic.name}")
    private String topicName;
    private final KafkaTemplate<String, BpPageCreate> kafkaTemplate;
    private static Long recordId = 0L;

    public Producer(KafkaTemplate<String, BpPageCreate> kafkaTemplate) throws FileNotFoundException {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Bean
    Producer getProducer() throws FileNotFoundException {
        return new Producer(kafkaTemplate);
    }

    public void send(PageCreate pageCreate) {
        BpPageCreate bpPageCreate = new BpPageCreate();
        bpPageCreate.setId(pageCreate.getMeta().getId());
        bpPageCreate.setDt(pageCreate.getMeta().getDt());
        bpPageCreate.setPartition(pageCreate.getMeta().getPartition());
        bpPageCreate.setOffset(pageCreate.getMeta().getOffset());
        bpPageCreate.setTitle(pageCreate.getPageTitle());
        bpPageCreate.setRecordId(recordId);
        ProducerRecord<String, BpPageCreate> record = new ProducerRecord<>(topicName, bpPageCreate);
        kafkaTemplate.send(record);
        log.info("record sent -> " + pageCreate.toString());
        recordId++;
    }

}

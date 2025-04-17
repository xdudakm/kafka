package fiit.mdudak.consumer2.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import fiit.mdudak.dto.BpPageCreate;
import lombok.extern.java.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Log
@Service
public class Consumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final FileOutputStream fileOutputStream;

    public Consumer(@Value("${spring.kafka.consumer.group-id}") String logFile) throws FileNotFoundException {
        fileOutputStream = new FileOutputStream(logFile + ".txt");
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
    )
    public void consume(ConsumerRecord<String, BpPageCreate> record) throws Exception {
        log.info("record received -> " + record.value());
        String sData = objectMapper.writeValueAsString(record.value()) + "\n";
        fileOutputStream.write(sData.getBytes());
        fileOutputStream.flush();
        Thread.sleep(300);
    }

}

package fiit.mdudak.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.MessageEvent;
import fiit.mdudak.dto.wikimedia.PageCreate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.Iterator;

@Configuration
public class WikimediaStream {
    private final Iterator<MessageEvent> it;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public WikimediaStream(@Value("${wikimedia.stream.url}") String url) {
        EventSource eventSource = new EventSource.Builder(URI.create(url)).build();
        it = eventSource.messages().iterator();
    }
    public PageCreate getPageCreate() throws JsonProcessingException {
        if (it.hasNext()) {
            return objectMapper.readValue(it.next().getData(), PageCreate.class );
        }
        return null;
    }
}

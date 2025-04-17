package fiit.mdudak.dto.wikimedia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Meta {
    private UUID id;
    private Date dt;
    private Integer partition;
    private Long offset;
}
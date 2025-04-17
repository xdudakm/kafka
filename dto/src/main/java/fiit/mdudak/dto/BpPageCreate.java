package fiit.mdudak.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class BpPageCreate implements Serializable {
    private Long recordId;
    private UUID id;
    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss'Z'")
    private Date dt;
    private Integer partition;
    private Long offset;
    private String title;
}

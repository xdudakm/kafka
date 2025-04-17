package fiit.mdudak.dto.wikimedia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class PageCreate {
    Meta meta;
    @JsonProperty(value = "page_title")
    String pageTitle;
}

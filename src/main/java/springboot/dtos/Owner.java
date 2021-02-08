package springboot.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {

    private long reputation;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("display_name")
    private String displayName;
    private String link;
}

package springboot.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import springboot.Utils.CustomJsonDateDeserializer;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    private Owner owner;
    @JsonProperty("is_answered")
    private boolean isAnswered;
    @JsonProperty("creation_date")
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date creationDate;
    private String link;
    private String title;
}

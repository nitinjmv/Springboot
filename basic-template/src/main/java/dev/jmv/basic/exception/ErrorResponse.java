package dev.jmv.basic.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Data
@Builder
@JsonPropertyOrder({"httpErrorCode", "errorMessage", "errorDetails"})
public class ErrorResponse {

    @JsonProperty(value = "status")
    private int httpErrorCode;

    @JsonProperty(value = "title")
    private String errorMessage;

    @JsonProperty(value = "detail")
    private List<String> errorDetails;

}

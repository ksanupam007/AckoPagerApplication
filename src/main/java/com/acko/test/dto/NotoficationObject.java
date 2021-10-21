package com.acko.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NotoficationObject {
    @JsonProperty("phone_number")
    private String phoneNumber;
    private String message;
}

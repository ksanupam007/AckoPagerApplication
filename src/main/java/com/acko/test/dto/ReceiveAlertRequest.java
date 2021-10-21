package com.acko.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReceiveAlertRequest {

    @JsonProperty("team_id")
    private String teamId;
}

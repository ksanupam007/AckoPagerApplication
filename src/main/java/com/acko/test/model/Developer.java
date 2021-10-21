package com.acko.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class Developer {

    @Id
    private String id;

    @JsonProperty("team_id")
    private String teamId;

    private String name;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}

package com.acko.test.dto;

import com.acko.test.model.Developer;
import com.acko.test.model.Team;
import lombok.Data;

import java.util.List;

@Data
public class CreateTeamRequest {
    private Team team;
    private List<Developer> developers;
}

package com.acko.test.controller;

import com.acko.test.model.Team;
import com.acko.test.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateTeamApiTest {

    @Autowired
    private TeamRepository repository;


    @Test
    public void createTeam() throws Exception{
        Team team = new Team();
        repository.save(new Team());
    }

}
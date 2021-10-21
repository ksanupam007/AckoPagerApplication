package com.acko.test.service;

import com.acko.test.dto.CreateTeamRequest;
import com.acko.test.model.Developer;
import com.acko.test.model.Team;
import com.acko.test.repository.DevelopersRepository;
import com.acko.test.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilityService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DevelopersRepository developerRepository;


    public CreateTeamRequest createTeam(CreateTeamRequest teamVO) {
        Team team = teamVO.getTeam();
        List<Developer> developers = teamVO.getDevelopers();
        team = teamRepository.save(team);
        for (Developer developer : developers) {
            developer.setTeamId(team.getId());
            developerRepository.save(developer);
        }
        return teamVO;
    }
}

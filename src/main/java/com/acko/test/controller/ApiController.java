package com.acko.test.controller;

import com.acko.test.dto.CreateTeamRequest;
import com.acko.test.dto.NotoficationObject;
import com.acko.test.dto.ReceiveAlertRequest;
import com.acko.test.dto.ReceiveAlertResponse;
import com.acko.test.model.Developer;
import com.acko.test.model.Team;
import com.acko.test.repository.DevelopersRepository;
import com.acko.test.repository.TeamRepository;
import com.acko.test.service.NotificationService;
import com.acko.test.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ApiController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private DevelopersRepository developerRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UtilityService utilityService;

    @RequestMapping(value = "/document/create/team", method = RequestMethod.POST)
    public CreateTeamRequest createTeam(@RequestBody CreateTeamRequest teamVO) {
        return utilityService.createTeam(teamVO);
    }



    @RequestMapping(value = "/receive/alert", method = RequestMethod.POST)
    public ReceiveAlertResponse receiveAlert(@RequestBody ReceiveAlertRequest request) {
        ReceiveAlertResponse response = new ReceiveAlertResponse();
        List<Developer> developers = developerRepository.findByTeamId(request.getTeamId());
        try {
            NotoficationObject notoficationRequestObject = new NotoficationObject();
            notoficationRequestObject.setPhoneNumber(developers.get(0).getPhoneNumber());
            notoficationRequestObject.setMessage("Too many 5xx!");
            response.setMessage(notificationService.sendNotification(notoficationRequestObject));
        } catch (Exception e) {
            response.setMessage("FAILURE");
        }
        return response;
    }


}

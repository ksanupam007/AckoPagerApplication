package com.acko.test.service;

import com.acko.test.dto.NotoficationObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class NotificationService {

    @Value("${notification.url}")
    private String url;

//    emailService
//    mobileServices

    public String sendNotification(NotoficationObject object) {
        try {

            final String baseUrl = url;
            URI uri = new URI(baseUrl);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> result = restTemplate.postForEntity(uri, object, String.class);
            if(result.getStatusCodeValue() == 201 || result.getStatusCodeValue() == 200)
                return "SUCCESS";
            else
                return "FAILURE";
        } catch (Exception e) {
            return "FAILURE";
        }
    }
}

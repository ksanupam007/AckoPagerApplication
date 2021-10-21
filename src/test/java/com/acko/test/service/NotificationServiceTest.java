package com.acko.test.service;

import com.acko.test.dto.NotoficationObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NotificationServiceTest {

    @Autowired
    private  NotificationService notificationService;

    @Test
    public void notificationTest() {
        NotoficationObject notoficationRequestObject = new NotoficationObject();
        notoficationRequestObject.setPhoneNumber("9999999999");
        notoficationRequestObject.setMessage("Too many 5xx!");
        assertEquals("SUCCESS",notificationService.sendNotification(notoficationRequestObject));
    }
}
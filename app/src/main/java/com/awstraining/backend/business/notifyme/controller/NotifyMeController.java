package com.awstraining.backend.business.notifyme.controller;

import com.awstraining.backend.api.rest.v1.NotifyMeApi;
import com.awstraining.backend.api.rest.v1.model.NotifyMe;
import com.awstraining.backend.api.rest.v1.model.SentMessage;
import com.awstraining.backend.business.notifyme.NotifyMeDO;
import com.awstraining.backend.business.notifyme.NotifyMeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// TODO: lab1
//  1. Create RestController "notification/v1".
//  2. Familiarize yourself with api, open-api contract, how it is generated?
@RestController
@RequestMapping("notification/v1")
public class NotifyMeController implements NotifyMeApi {


    // TODO: lab1
    //  1. Inject service with business logic.
    //private final NotifyMeService notifyMeService;
    private final NotifyMeService service;

    @Autowired
    public NotifyMeController(final NotifyMeService service) {
        this.service = service;
    }


    // TODO: lab1
    //  1. Implement notifyMe method. 
    //  Method should return Http 200 and content of sent message to subscribers.
    @Override
    public ResponseEntity<SentMessage> notifyMe(NotifyMe notifyMe) {
        String text = service.notifyMe(map(notifyMe));
        service.notifyMe(map(notifyMe));
        return ResponseEntity.ok(map(text));
    }

    private static SentMessage map(String message) {
        return new SentMessage().text(message);
    }

    private NotifyMeDO map(NotifyMe notifyMe) {
        return new NotifyMeDO(notifyMe.getText(), notifyMe.getSourceLc(), notifyMe.getTargetLc());
    }
}

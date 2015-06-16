package websocket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ScheduleTask {

    @Autowired
    private SimpMessagingTemplate template;

    // this will send a message to an endpoint on which a client can subscribe
    @Scheduled(fixedRate = 5000)
    public void trigger() {
        this.template.convertAndSend("/topic/message", "Date: " + new Date());
    }

}

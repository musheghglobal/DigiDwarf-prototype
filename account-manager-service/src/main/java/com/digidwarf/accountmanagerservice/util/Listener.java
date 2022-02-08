package com.digidwarf.accountmanagerservice.util;

import com.digidwarf.accountmanagerservice.request.UserRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Listener {

//    @KafkaListener(topics = "topicName", groupId = "group-id")
//    public void listen(String message) {
//        System.out.println("Received Messasge in group - group-id: " + message);
//    }
//
//    @KafkaListener(topics = "topicName")
//    public void listenWithHeaders(
//            @Payload String message,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        System.out.println(
//                "Received Message: " + message + "from partition: " + partition);
//    }


    @KafkaListener(topics = "kafka", groupId = "groupId1")
    public void listener(Object user) {
        System.out.println("****************************");
        System.out.println(user);
    }


}

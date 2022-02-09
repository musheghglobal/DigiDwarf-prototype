package com.digidwarf.loginregistrationservice.connection;


import com.digidwarf.loginregistrationservice.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class DwarfConnectionProvider {

    private final KafkaTemplate<String, UserRequest> kafkaTemplate;

    @PostMapping
    public void sendOrder() {
        kafkaTemplate.send("kafka", new UserRequest());
    }

//    public void sendMessage(String topicName, User message) {
//
//        kafkaTemplate.send(topicName, message);
//
//        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//
//            @Override
//            public void onSuccess(SendResult<String, Object> result) {
//                System.out.println("success");
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("fail");
//            }
//        });
//    }

}
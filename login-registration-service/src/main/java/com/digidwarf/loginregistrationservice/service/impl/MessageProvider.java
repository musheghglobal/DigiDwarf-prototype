package com.digidwarf.loginregistrationservice.service.impl;

import com.digidwarf.loginregistrationservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

//@Service
//@RequiredArgsConstructor
public class MessageProvider {

//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    public void sendMessage(String msg) {
//        ListenableFuture<SendResult<String, String>> topicName = kafkaTemplate.send("topicName", msg);
//    }
//
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

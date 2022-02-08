package com.digidwarf.loginregistrationservice.endpoint;


import com.digidwarf.loginregistrationservice.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/msg")
public class MsgController {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping
    public void sendOrder() {
        kafkaTemplate.send("kafka", "dgbhdgbhndf");
    }
}
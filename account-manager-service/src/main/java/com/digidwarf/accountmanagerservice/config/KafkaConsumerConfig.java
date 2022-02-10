package com.digidwarf.accountmanagerservice.config;

import com.digidwarf.accountmanagerservice.request.UserRequest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

   @Value("${dwarf.kafka.host}")
   private String OBJECT_VALUE;

   @Bean
   public ConsumerFactory<String, UserRequest> consumerFactory() {
      Map<String, Object> props = new HashMap<>();
      props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, OBJECT_VALUE);
      props.put(ConsumerConfig.GROUP_ID_CONFIG, "groupId1");
      props.put(JsonDeserializer.TRUSTED_PACKAGES, "com/digidwarf/accountmanagerservice/request/*");
      return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(UserRequest.class));
   }
   @Bean
   public ConcurrentKafkaListenerContainerFactory<String, UserRequest> kafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, UserRequest>
      factory = new ConcurrentKafkaListenerContainerFactory<>();
      factory.setConsumerFactory(consumerFactory());
      return factory;
   }
}   
package org.vedantacomp.saga.config;

import org.springframework.context.annotation.Configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.vedantacomp.common.dto.BookingCreatedEvent;
import org.vedantacomp.common.dto.ProcessPaymentReply;
import org.vedantacomp.common.dto.SeatAllocationReply;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SagaKafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers:localhost:9092}")
    private String bootstrapServers;

    private Map<String, Object> baseConsumerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        return props;
    }

    private <T> ConcurrentKafkaListenerContainerFactory<String, T> createFactory(Class<T> targetType) {
        JsonDeserializer<T> deserializer = new JsonDeserializer<>(targetType);
        deserializer.setUseTypeHeaders(false); // Disregards upstream producer package paths
        deserializer.addTrustedPackages("*");

        ErrorHandlingDeserializer<T> errorHandlingDeserializer = new ErrorHandlingDeserializer<>(deserializer);

        ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(
            baseConsumerProps(),
            new StringDeserializer(),
            errorHandlingDeserializer
        ));
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, BookingCreatedEvent> bookingCreatedKafkaListenerContainerFactory() {
        return createFactory(BookingCreatedEvent.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SeatAllocationReply> seatAllocationReplyKafkaListenerContainerFactory() {
        return createFactory(SeatAllocationReply.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ProcessPaymentReply> paymentReplyKafkaListenerContainerFactory() {
        return createFactory(ProcessPaymentReply.class);
    }
}

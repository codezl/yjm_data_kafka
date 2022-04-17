package com.zcdl.yjm_data_kafka.mq;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * 消费Ehome消息
 */
//@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "yjm_huizhou", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "batchFactory")
    public void receive(List<ConsumerRecord<String, String>> records, Acknowledgment ack) {
        records.forEach(record -> {
            System.out.println("===========消费信息===========");
            try {
                // 消费偏移量
                long offset = record.offset();
                // 分区
                int partition = record.partition();
                // 主题
                String topic = record.topic();
                // 信息
                String payload = record.value();
                System.out.println(payload);
            } catch (Exception e) {
                log.error("消息消费报错", e);
            }
        });
        // 手动提交偏移量
        ack.acknowledge();
    }

}
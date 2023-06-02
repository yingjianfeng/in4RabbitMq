package com.in.controller;

import com.in.binders.MyMessageChannels;
import com.in.producer.MyAckMessageProducer;
import com.in.producer.MyLazyMessageProducer;
import com.in.producer.MyMessageProducer;
import lombok.AllArgsConstructor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yingjf
 * @date: 2023/5/23 19:31
 * @description:
 */
@AllArgsConstructor
@RestController

public class MyController {

    private final MyMessageProducer myMessageProducer;
    private final MyAckMessageProducer myAckMessageProducer;
    private final MyLazyMessageProducer myLazyMessageProducer;

    @GetMapping("/produce/{message}")
    public String producer(@PathVariable("message") String message){
        myMessageProducer.send(message);

        return "success";
    }


    @GetMapping("/ack/produce/{message}")
    public String producerAck(@PathVariable("message") String message){
        myAckMessageProducer.send(message);

        return "success";
    }


    @GetMapping("/lazy/produce/{message}")
    public String producerLazy(@PathVariable("message") String message){
        myLazyMessageProducer.send(message);
        return "success";
    }

}

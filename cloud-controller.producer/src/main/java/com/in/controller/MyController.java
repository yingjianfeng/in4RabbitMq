package com.in.controller;

import com.in.binders.MyMessageChannels;
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

    @GetMapping("/produce/{message}")
    public String producer(@PathVariable("message") String message){
        myMessageProducer.send(message);

        return "success";
    }

}

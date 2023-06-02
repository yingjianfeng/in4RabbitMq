package com.in.producer.impl;

import com.in.binders.MyAckMessageChannels;
import com.in.binders.MyMessageChannels;
import com.in.producer.MyAckMessageProducer;
import com.in.producer.MyMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author: yingjf
 * @date: 2023/5/24 15:08
 * @description:
 */
@AllArgsConstructor
@EnableBinding({MyAckMessageChannels.class})
@Service("myAckMessageProducer")
public class MyAckMessageProducerImpl implements MyAckMessageProducer {

    private final MyAckMessageChannels myAckMessageChannels;
    @Override
    public void send(String message) {
        myAckMessageChannels.myAckOutputChannel().send(MessageBuilder.withPayload(message).build());
    }
}

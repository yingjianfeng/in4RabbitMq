package com.in.producer.impl;

import com.in.binders.MyMessageChannels;
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
@EnableBinding({MyMessageChannels.class})
@Service("myMessageProducer")
public class MyMessageProducerImpl implements MyMessageProducer{

    private final MyMessageChannels myMessageChannels;
    @Override
    public void send(String message) {
        myMessageChannels.myOutputChannel().send(MessageBuilder.withPayload(message).build());
    }
}

package com.in.producer.impl;

import com.in.binders.MyAckMessageChannels;
import com.in.binders.MyLazyMessageChannels;
import com.in.producer.MyAckMessageProducer;
import com.in.producer.MyLazyMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Service;

/**
 * @author: yingjf
 * @date: 2023/5/24 15:08
 * @description:
 */
@AllArgsConstructor
@EnableBinding({MyLazyMessageChannels.class})
@Service("myLazyMessageProducer")
public class MyLazyMessageProducerImpl implements MyLazyMessageProducer {

    private final MyLazyMessageChannels myLazyMessageChannels;
    @Override
    public void send(String message) {
        MessageHeaderAccessor messageHeaderAccessor = new MessageHeaderAccessor();
        messageHeaderAccessor.setHeader("x-delay", 5000);
        MessageBuilder messageBuilder = MessageBuilder.withPayload(message).setHeaders(messageHeaderAccessor);

        myLazyMessageChannels.myLazyOutputChannel().send(messageBuilder.build());
    }
}

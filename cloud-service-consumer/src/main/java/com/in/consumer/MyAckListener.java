package com.in.consumer;

import com.in.binders.MyAckMessageChannels;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;


import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;

import java.io.IOException;

/**
 * @author: yingjf
 * @date: 2023/5/23 19:27
 * @description:
 */
@Slf4j
@EnableBinding(MyAckMessageChannels.class)
public class MyAckListener {
    private int i = 0;

    @StreamListener(MyAckMessageChannels.INPUT)
    public void receive(Message<String> message) throws Exception {
        Channel channel = message.getHeaders().get(AmqpHeaders.CHANNEL, Channel.class);
        Long deliveryTag = message.getHeaders().get(AmqpHeaders.DELIVERY_TAG, Long.class);
        try {
            if (true) {
                System.out.println("i= " + i + " error! ");
                throw new Exception("xxx");
            }
            // 处理消息
            // 如果处理成功，手动确认消息
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            // 处理异常，手动拒绝消息
            channel.basicReject(deliveryTag, false);
        }

//        i++;
//        if (true) {
//            System.out.println("i= "+i+" error! ");
//            throw new Exception("xxx");
//        } else {
//            // 手动确认消息已经被消费
//            Channel channel = message.getHeaders().get(AmqpHeaders.CHANNEL, Channel.class);
//            Long tab = message.getHeaders().get(AmqpHeaders.DELIVERY_TAG, Long.class);
//            //channel.basicAck(tab, false);
//        }
//        System.out.println("i= "+i+" Received message: " + message.getPayload());
    }


}

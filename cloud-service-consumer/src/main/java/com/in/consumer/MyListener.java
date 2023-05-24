package com.in.consumer;

import com.in.binders.MyMessageChannels;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author: yingjf
 * @date: 2023/5/23 19:27
 * @description:
 */
@Slf4j
@EnableBinding(MyMessageChannels.class)
public class MyListener {

    @StreamListener(MyMessageChannels.INPUT)
    public void handleMessage(String message) {
        System.out.println("Received message: " + message);
    }

}

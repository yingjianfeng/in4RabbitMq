package com.in.binders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

/**
 * @author: yingjf
 * @date: 2023/5/23 19:20
 * @description:
 */
@Service("myMessageChannels")
public interface MyMessageChannels {
    String INPUT = "my-input-channel";


    @Input(INPUT)
    SubscribableChannel myInputChannel();

}
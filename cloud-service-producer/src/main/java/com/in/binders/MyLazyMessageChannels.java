package com.in.binders;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

/**
 * @author: yingjf
 * @date: 2023/5/23 19:19
 * @description:
 */
@Service("myLazyMessageChannels")
public interface MyLazyMessageChannels {
    String OUTPUT = "my-lazy-output-channel";



    @Output(OUTPUT)
    MessageChannel myLazyOutputChannel();

}

package com.in.producer;

/**
 * @author: yingjf
 * @date: 2023/5/24 15:07
 * @description:
 */

public interface MyAckMessageProducer {

    void send(String message);

}

package com.in.producer;

import org.springframework.stereotype.Service;

/**
 * @author: yingjf
 * @date: 2023/5/24 15:07
 * @description:
 */

public interface MyMessageProducer {

    void send(String message);

}

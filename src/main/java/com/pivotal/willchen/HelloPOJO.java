package com.pivotal.willchen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by chenw13 on 7/29/16.
 */
@RefreshScope
@Component
@EnableAutoConfiguration
public class HelloPOJO {

    @Value("${hello.signature:default}")
    String signature;

    public String getSignature() {
        return signature;
    }
}

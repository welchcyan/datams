package com.pivotal.willchen;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenw13 on 7/28/16.
 */
@EnableDiscoveryClient
@RestController
public class HelloController {

    private Log log = LogFactory.getLog(HelloController.class);

    public HelloController() {
        log.info("Hello Controller initialized");
    }

    @Autowired
    HelloPOJO helloPOJO;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "salutation", defaultValue = "Hello") String salutation, @RequestParam(value = "name", defaultValue = "Bob") String name) {
        log.info(String.format("Now saying \"%s\" to %s", salutation, name));
        Greeting gree = new Greeting(salutation, name);
        return gree.getMessage() + (helloPOJO.getSignature() == null ? "Empty": helloPOJO.getSignature() );
    }

    private static class Greeting {

        private static final String template = "%s, %s!";

        private String message;

        public Greeting(String salutation, String name) {
            this.message = String.format(template, salutation, name);
        }

        public String getMessage() {
            return this.message;
        }

    }

}

package com.dyp.test.jms.spring.activemq;

import static org.junit.Assert.*;

import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/SpringContext.xml")
public class TopicProducerServiceImplTest {

	@Autowired
    private ProducerServiceImpl producerService;
    @Autowired
    @Qualifier("topicDestination")
    private Destination destination;
    
    @Test
    public void testSend() {
        for (int i=0; i<2; i++) {
            producerService.sendMessage(destination, "你好，生产者！这是消息：" + (i+1));
        }
    }

}

package cn.tyrone.springboot.integrate.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 接收消费者 返回数据
 */
@Component
public class RxCousResultProduce {

    private Logger logger = LoggerFactory.getLogger(RxCousResultProduce.class);

    /**
     * 使用JmsListener配置消费者监听的队列
     *
     * @param text
     *            接收到的消息
     */
    @JmsListener(destination = "out.queue")
    public void consumerMessage(String text) {
        logger.info("RxCousResultProduce : 从out.queue队列收到的回复报文为:" + text);
    }
}

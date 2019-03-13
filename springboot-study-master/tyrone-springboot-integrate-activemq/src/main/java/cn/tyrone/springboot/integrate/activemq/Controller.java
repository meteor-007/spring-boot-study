package cn.tyrone.springboot.integrate.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @Description:
 * @Auther: czwei
 * @Date: 2019/3/13 10:14
 */
public class Controller {
    @Resource
    Producer producer;

    @GetMapping(value = "/activeMqSendMes")
    @ResponseBody
    public String activeMqSendMes() {
        int num = 10;
        try {
            //ActiveMQQueue 队列模式
            //ActiveMQTopic 订阅模式
            Destination destinationQueue = new ActiveMQQueue("suimh_queue");
            for (int i = 1; i <= num; i++) {
                producer.convertAndSend(destinationQueue, "这是queueProducer发送的第" + i + "个消息！");
            }
            return "activeMQ生产成功！";
        } catch (Exception e) {
            return "activeMQ生产失败！";
        }
    }

}

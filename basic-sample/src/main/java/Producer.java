import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消息生产者
 */
public class Producer {
    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:rabbitmq-context.xml");
        //RabbitMQ模板
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);

        for (int i = 0; i < 100; i++) {
            template.convertAndSend("test1", "hello");
            Thread.sleep(1000);
        }
        ctx.destroy(); //容器销毁
    }
}

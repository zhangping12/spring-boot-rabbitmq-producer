package com.imooc.springbootrabbitmqproducer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * 描述：rabbitmq配置类
 */
@Configuration
public class TopicRabbitConfig {

    @Bean
    public Queue queue1(){
        return new Queue("queue1");
    }

    @Bean
    public Queue queue2(){
        return new Queue("queue2");
    }

    //定义交换机
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("bootExchange");
    }

    //绑定交换机
    @Bean
    Binding bingdingExchangeMessage1(Queue queue1,TopicExchange exchange){
        return BindingBuilder.bind(queue1).to(exchange).with("dog.red");
    }

    @Bean
    Binding bingdingExchangeMessage2(Queue queue2,TopicExchange exchange){
        return BindingBuilder.bind(queue2).to(exchange).with("dog.#");
    }
}

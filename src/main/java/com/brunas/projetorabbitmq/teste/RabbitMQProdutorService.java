package com.brunas.projetorabbitmq.teste;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProdutorService {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProdutorService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarTopicFila1(String mensagem) {
        rabbitTemplate.convertAndSend("topic-exchange", "app1.pagamento", mensagem);
        System.out.println("Enviando mensagem: " + mensagem);
    }

    public void enviarTopicFila2(String mensagem) {
        rabbitTemplate.convertAndSend("topic-exchange", "app1.compras", mensagem);
        System.out.println("Enviando mensagem: " + mensagem);
    }

    public void enviarTopicFila3(String mensagem) {
        rabbitTemplate.convertAndSend("topic-exchange", "app2.compras", mensagem);
        System.out.println("Enviando mensagem: " + mensagem);
    }
}

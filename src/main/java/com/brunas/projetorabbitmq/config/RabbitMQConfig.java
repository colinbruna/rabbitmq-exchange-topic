package com.brunas.projetorabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    //As exchanges do tipo Topic, permitem enviar as mensagens de acordo com o assunto.
    //Com base na forma como se nomeia as routing keys é possível criar padrões de regras e relaçoes entre sistemas

    //FILAS
    @Bean
    public Queue fila1() { return new Queue("fila1", true); }

    @Bean
    public Queue fila2() {
        return new Queue("fila2", true);
    }

    @Bean
    public Queue fila3() {
        return new Queue("fila3", true);
    }

    //EXCHANGE DO TIPO TOPIC
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topic-exchange");
    }

    //BINDINGS
    //rountingKey (*.key) (*.key*) (*.key.*) (key.*)
    //* substituiu uma palavra e # substituiu 0 ou mais palavras
    @Bean
    Binding binding(Queue fila1, TopicExchange exchange) {
        return BindingBuilder.bind(fila1).to(exchange).with("app1.*"); //recebe app1.pagamento e app1.compras
    }

    @Bean
    Binding binding2(Queue fila2, TopicExchange exchange) {
        return BindingBuilder.bind(fila2).to(exchange).with("*.compras"); // recebe app1.compras e app2.compras
    }

    @Bean
    Binding binding3(Queue fila3, TopicExchange exchange) {
        return BindingBuilder.bind(fila3).to(exchange).with("*.pagamento"); //recebe app1.pagamento
    }
}

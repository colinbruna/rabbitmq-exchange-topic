package com.brunas.projetorabbitmq.controller;

import com.brunas.projetorabbitmq.teste.RabbitMQProdutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
public class RabbitMQController {

    private final RabbitMQProdutorService produtorService;

    public RabbitMQController(RabbitMQProdutorService produtorConfig) {
        this.produtorService = produtorConfig;
    }

    @GetMapping("/fila1")
    public void enviarFila1(@RequestBody String mensagem) {
        produtorService.enviarTopicFila1(mensagem);
    }

    @GetMapping("/fila2")
    public void enviarFila2(@RequestBody String mensagem) {
        produtorService.enviarTopicFila2(mensagem);
    }

    @GetMapping("/fila3")
    public void enviarFila3(@RequestBody String mensagem) {
        produtorService.enviarTopicFila3(mensagem);
    }

}

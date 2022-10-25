### Exchange topic

Essa é uma das exchanges mais flexíveis, que nos permite enviar as mensagens de acordo com o assunto(tópico). E com base na forma que você nomeia
as routing keys é possível criar padrões de regras e relações entre os sistemas.

Por exemplo: routing key (x.*); routing key (*.z); routing key (*.y.*).

Então se o nosso sistema é de compras e nós precisamos enviar uma mensagem para a exchange, é possível criar uma condição baseada na routing
key para que somente as filas ou sistemas similares recebam a mensagem.

Nesse caso, se nós enviarmos uma mensagem chamada (x.log), somente a fila referente a esse tópico irá receber a mensagem por conta do padrão
que nós criamos. Ou se você enviar uma mensagem (t.z), somente a exchange relativa a essa chave irá recebê-la.

Por isso a Topic Exchange possui uma relação bastante flexível para encaminhar as nossas mensagens.

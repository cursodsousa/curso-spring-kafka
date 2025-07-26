package io.github.cursodsousa.icompras.logistica.publisher;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cursodsousa.icompras.logistica.model.AtualizacaoEnvioPedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EnvioPedidoPublisher {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${icompras.config.kafka.topics.pedidos-enviados}")
    private String topico;

    public void enviar(AtualizacaoEnvioPedido atualizacaoEnvioPedido){
        log.info("Publicando pedido enviado {} ", atualizacaoEnvioPedido.codigo());

        try {
            var json = objectMapper.writeValueAsString(atualizacaoEnvioPedido);
            kafkaTemplate.send(topico, "dados", json);
            log.info("Publicado o pedido enviado {}, código de rastreio: {}",
                    atualizacaoEnvioPedido.codigo(), atualizacaoEnvioPedido.codigoRastreio());
        } catch (Exception e){
            log.error("Erro ao publicar envio do pedido", e);
        }
    }
}

package io.github.cursodsousa.icompras.pedidos.subscriber.representation;

import io.github.cursodsousa.icompras.pedidos.model.enums.StatusPedido;

public record AtualizacaoStatusPedidoRepresentation(
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal,
        String codigoRastreio
) {
}

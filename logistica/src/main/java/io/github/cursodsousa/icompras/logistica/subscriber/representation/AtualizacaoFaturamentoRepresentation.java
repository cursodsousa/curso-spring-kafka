package io.github.cursodsousa.icompras.logistica.subscriber.representation;

import io.github.cursodsousa.icompras.logistica.model.StatusPedido;

public record AtualizacaoFaturamentoRepresentation(
        Long codigo, StatusPedido status, String urlNotaFiscal
) {
}

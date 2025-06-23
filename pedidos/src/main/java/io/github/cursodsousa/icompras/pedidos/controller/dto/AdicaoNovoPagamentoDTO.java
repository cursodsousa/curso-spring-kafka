package io.github.cursodsousa.icompras.pedidos.controller.dto;

import io.github.cursodsousa.icompras.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(
        Long codigoPedido, String dados, TipoPagamento tipoPagamento) {
}

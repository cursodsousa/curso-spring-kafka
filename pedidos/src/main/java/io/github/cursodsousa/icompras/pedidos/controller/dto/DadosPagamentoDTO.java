package io.github.cursodsousa.icompras.pedidos.controller.dto;

import io.github.cursodsousa.icompras.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(String dados, TipoPagamento tipoPagamento) {
}

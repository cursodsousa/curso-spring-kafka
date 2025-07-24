package io.github.cursodsousa.icompras.faturamento.publisher.representation;

public record AtualizacaoStatusPedido(
        Long codigo, StatusPedido status, String urlNotaFiscal) {
}

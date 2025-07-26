package io.github.cursodsousa.icompras.pedidos.service;

import io.github.cursodsousa.icompras.pedidos.model.enums.StatusPedido;
import io.github.cursodsousa.icompras.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository repository;

    @Transactional
    public void atualizarStatus(
            Long codigo, StatusPedido status, String urlNotaFiscal, String rastreio){

        repository.findById(codigo).ifPresent(pedido -> {
            pedido.setStatus(status);

            if(urlNotaFiscal != null){
                pedido.setUrlNotaFiscal(urlNotaFiscal);
            }

            if(rastreio != null){
                pedido.setCodigoRastreio(rastreio);
            }
        });
    }
}

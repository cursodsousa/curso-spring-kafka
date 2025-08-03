package io.github.cursodsousa.icompras.pedidos.validator;

import feign.FeignException;
import io.github.cursodsousa.icompras.pedidos.client.ClientesClient;
import io.github.cursodsousa.icompras.pedidos.client.ProdutosClient;
import io.github.cursodsousa.icompras.pedidos.client.representation.ClienteRepresentation;
import io.github.cursodsousa.icompras.pedidos.client.representation.ProdutoRepresentation;
import io.github.cursodsousa.icompras.pedidos.model.ItemPedido;
import io.github.cursodsousa.icompras.pedidos.model.Pedido;
import io.github.cursodsousa.icompras.pedidos.model.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoValidator {

    private final ProdutosClient produtosClient;
    private final ClientesClient clientesClient;

    public void validar(Pedido pedido){
        Long codigoCliente = pedido.getCodigoCliente();
        validarCliente(codigoCliente);
        pedido.getItens().forEach(this::validarItem);
    }

    private void validarCliente(Long codigoCliente){
        try{
            var response = clientesClient.obterDados(codigoCliente);
            ClienteRepresentation cliente = response.getBody();
            log.info("Cliente de código {} encontrado: {}", cliente.codigo(), cliente.nome());

            if(!cliente.ativo()){
                throw new ValidationException("codigoCliente", "Cliente Inativo.");
            }

        } catch (FeignException.NotFound e){
            var message = String.format("Cliente de código %d não encontrado.", codigoCliente);
            throw new ValidationException("codigoCliente", message);
        }

    }

    private void validarItem(ItemPedido item){
        try {
            var response = produtosClient.obterDados(item.getCodigoProduto());
            ProdutoRepresentation produto = response.getBody();
            log.info("Produto de código {} encontrado: {}", produto.codigo(), produto.nome());

            if(!produto.ativo()){
                throw new ValidationException("codigoProduto", "Produto inativo.");
            }

        } catch (FeignException.NotFound e){
            var message = String.format("Produto de código %d não encontrado.", item.getCodigoProduto());
            throw new ValidationException("codigoProduto", message);
        }
    }
}

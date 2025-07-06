package io.github.cursodsousa.icompras.faturamento;

import io.github.cursodsousa.icompras.faturamento.model.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeradorNotaFiscalService {

    public void gerar(Pedido pedido){
      log.info("Gerada nota fiscal para o pedido {} ", pedido.codigo());
    }
}

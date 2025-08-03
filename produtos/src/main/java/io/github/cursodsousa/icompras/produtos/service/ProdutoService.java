package io.github.cursodsousa.icompras.produtos.service;

import io.github.cursodsousa.icompras.produtos.model.Produto;
import io.github.cursodsousa.icompras.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public Optional<Produto> obterPorCodigo(Long codigo){
        return repository.findById(codigo);
    }

    public void deletar(Produto produto) {
        produto.setAtivo(false);
        repository.save(produto);
    }
}

package com.example.crud_produto.services;

import com.example.crud_produto.model.Produto;
import com.example.crud_produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Produto produto, Long id) {
        return produtoRepository.findById(id)
                .map(existing -> {
                    existing.setNome(produto.getNome());
                    existing.setPreco(produto.getPreco());
                    return produtoRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }
}

package com.example.crud_produto.controller;


import com.example.crud_produto.model.Produto;
import com.example.crud_produto.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produto", description = "Operações para gerenciamento de produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping()
    @Operation(summary = "Listar todos produtos", description = "Retorna uma lista com todos produtos cadastrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID", description = "Retorna um produto especifico buscado por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        return produtoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar novo produto", description = "Salva novo produto no banco de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição")
    })
    public Produto create(@RequestBody Produto produto) {
        return produtoService.saveProduto(produto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto por ID", description = "Atualiza um produto do banco de dados, buscado pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto novoProduto) {
        return produtoService.findById(id)
                .map(produtoAtualizado -> {
                    produtoAtualizado.setNome(novoProduto.getNome());
                    produtoAtualizado.setPreco(novoProduto.getPreco());

                    produtoService.saveProduto(produtoAtualizado);
                    return ResponseEntity.ok(produtoAtualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover produto por ID", description = "Remove um produto do banco de dados, pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

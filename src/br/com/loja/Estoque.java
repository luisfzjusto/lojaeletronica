package br.com.loja;

import java.util.HashMap;

import java.util.Map;

public class Estoque {
	private Map<Produto, Integer> estoque;

	public Estoque() {
		this.estoque = new HashMap<>();
	}
	
	//Método para adicionar produto ao estoque
	public void adicionarProduto(Produto produto, int quantidade) {
		if (estoque.containsKey(produto)) {
			int quantidadeAtual = estoque.get(produto);
			estoque.put(produto, quantidadeAtual + quantidade);
		} else {
			estoque.put(produto, quantidade);
		}
		System.out.println(quantidade + " unidades do produto " + produto.getNome() + " adicionadas ao estoque");
	}
	
	//Método para remover produto do estoque
	public void removerProduto(Produto produto, int quantidade) {
		if (estoque.containsKey(produto)) {
			int quantidadeAtual = estoque.get(produto);
			if (quantidadeAtual >= quantidade) {
				estoque.put(produto, quantidadeAtual - quantidade);
				System.out.println(quantidade + " unidades do produto " + produto.getNome() + "removidas do estoque");
			} else {
				System.out.println("Quantidade insuficiente do produto " + produto.getNome() + " em estoque");
			}
		} else {
			System.out.println("Produto " + produto.getNome() + " não encontrado no estoque");
		}
	}
	
	//Método para obter a quantidade de um produto em estoque
	public int getQuantidadeEmEstoque(Produto produto) {
        return estoque.getOrDefault(produto, 0);
    }
	
	
}

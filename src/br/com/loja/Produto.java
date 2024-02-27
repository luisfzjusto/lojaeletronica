package br.com.loja;

import java.util.Scanner;

public class Produto {
	private String nome;
	private String descricao;
	private float preco;
	private int qtdeEstoque;
	
	public Produto(String nome, String descricao, float preco, int qtdeEstoque) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.qtdeEstoque = qtdeEstoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	
	public static Produto cadastrarProduto(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome:");
		String nome = scanner.nextLine();
		
		System.out.println("Digite a descricao:");
		String descricao = scanner.nextLine();
		
		System.out.println("Digite o preco:");
		float preco = scanner.nextFloat();
		
		System.out.println("Digite a quantidade:");
		int qtdeEstoque = scanner.nextInt();
		
		return new Produto(nome, descricao, preco, qtdeEstoque);				
	}
	
	public void exibirProduto() {
		System.out.println("Nome: " + nome);
		System.out.println("Descrição: " + descricao);
		System.out.println("Preço: " + preco);
		System.out.println("Quantidade em estoque: " + qtdeEstoque);		
	}
	
	//Método para verificar se existe o produto em estoque
	public boolean verificarEstoque(int qtdeDesejada) {
		return qtdeDesejada <= qtdeEstoque;
	}
	
	//Método para atualizar estoque após venda
	public int atualizarEstoque(int qtdeVendida) {
		return qtdeEstoque = qtdeEstoque - qtdeVendida;
	}
	
	
	
}

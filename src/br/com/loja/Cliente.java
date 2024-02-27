package br.com.loja;

import java.util.Scanner;

public class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private String dn;
	private String senha;
	private float saldo;
	
	public Cliente(String nome, String endereco, String telefone, String email, String dn, String senha) {
		this.nome = nome;
		this.endereco = endereco;	
		this.telefone = telefone;
		this.email = email;
		this.dn = dn;
		this.senha = senha;
		this.saldo = 100.0f;
	}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDn() {
		return dn;
	}



	public void setDn(String dn) {
		this.dn = dn;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public float getSaldo() {
		return saldo;
	}



	public void setSaldo(float valor) {
		saldo += valor;
	}



	public static Cliente cadastrarCliente(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome:");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o endereço:");
		String endereco = scanner.nextLine();
		
		System.out.println("Digite o telefone:");
		String telefone = scanner.nextLine();
		
		System.out.println("Digite o email:");
		String email = scanner.nextLine();
		
		System.out.println("Digite a data de nascimento:");
		String dn = scanner.nextLine();
		
		System.out.println("Digite a senha:");
		String senha = scanner.nextLine();
		
		return new Cliente(nome, endereco, telefone, email, dn, senha);				
	}
	
	public void exibirCliente() {
		System.out.println("Nome: " + nome);
		System.out.println("Endereço: " + endereco);
		System.out.println("Telefone: " + telefone);
		System.out.println("E-mail: " + email);
		System.out.println("Data de Nascimento: " + dn);
		System.out.println("Senha: " + senha);
		System.out.println("Saldo: " + saldo);
		
	}
	
}



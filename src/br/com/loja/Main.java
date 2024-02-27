package br.com.loja;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		ArrayList<Cliente> listaClientes = new ArrayList<>();
		ArrayList<Produto> listaProdutos = new ArrayList<>();
		ArrayList<Venda> listaVendas = new ArrayList<>();
		
		boolean executando = true;
		int opcao = 0;
		while(executando) {
			System.out.println("Bem-vindo a loja G3");
			System.out.println("Escolha uma opção");
			System.out.println("1 - Cadastrar clientes");
			System.out.println("2 - Listar clientes");
			System.out.println("3 - Cadastrar produtos");
			System.out.println("4 - Listar produtos");
			System.out.println("5 - Comprar produtos");
			System.out.println("6 - Adicionar saldo");
			System.out.println("7 - Sair");
			
			if (scanner.hasNextInt()) {
				opcao = scanner.nextInt();
				scanner.nextLine();
			
			
			switch (opcao) {
				case 1:
					Cliente cliente = Cliente.cadastrarCliente();
					listaClientes.add(cliente);
					System.out.println("Cliente cadastrado com sucesso");
					cliente.exibirCliente();
					break;
				case 2:
					if (listaClientes.isEmpty()) {
						System.out.println("Não há clientes cadastrados");
					} else {
						System.out.println("Clientes cadastrados:");
						for (Cliente c : listaClientes) {
							c.exibirCliente();
							System.out.println();
						}
					}
					break;
				case 3:
					Produto produto = Produto.cadastrarProduto();
					listaProdutos.add(produto);
					System.out.println("Produto cadastrado com sucesso");
					produto.exibirProduto();
					break;
				case 4:
					if (listaProdutos.isEmpty()) {
						System.out.println("Não há produtos cadastrados");
					} else {
						System.out.println("Produtos cadastrados:");
						for (Produto p : listaProdutos) {
							p.exibirProduto();
							System.out.println();
						}
					}
					break;
				case 5:
					if (listaClientes.isEmpty() || listaProdutos.isEmpty()) {
						System.out.println("Não é possível realizar a compra");
						break;
					} else {
						System.out.println("Selecione o cliente (digite o número):");
						for (int i = 0; i < listaClientes.size(); i++) {
							System.out.println((i + 1) + " . " + listaClientes.get(i).getNome());
						}
						int indiceCliente = scanner.nextInt();
						if(indiceCliente > 0 && indiceCliente <= listaClientes.size()){						
							Cliente clienteSelecionado = listaClientes.get(indiceCliente - 1);
						
						ArrayList<ItemVenda> itensVenda = new ArrayList<>();
						boolean adicionandoProdutos = true;
						float totalVenda = 0.0f;
						while(adicionandoProdutos) {
							System.out.println("Selecione o produto (digite o número):");
							for (int i = 0; i < listaProdutos.size(); i++) {
								System.out.println((i +1) + " . " + listaProdutos.get(i).getNome() + " Preço: " + listaProdutos.get(i).getPreco());
							}
							int indiceProduto = scanner.nextInt();
							if (indiceProduto == -1) {
								adicionandoProdutos = false;
							} else if(indiceProduto > 0 && indiceProduto <= listaProdutos.size()) {
								Produto produtoSelecionado = listaProdutos.get(indiceProduto - 1);
								System.out.println("Digite a quantidade desejada:");
								int quantidade = scanner.nextInt();
								if (quantidade <= produtoSelecionado.getQtdeEstoque()) {
									ItemVenda itemVenda = new ItemVenda(produtoSelecionado, quantidade);
									itensVenda.add(itemVenda);
									totalVenda += itemVenda.calcularSubtotal();
									produtoSelecionado.setQtdeEstoque(produtoSelecionado.getQtdeEstoque() - quantidade);
									System.out.println("Item adicionado ao carrinho.");								
							} else {
								System.out.println("Quantidade indisponível em estoque.");								
							}
						} else {
							System.out.println("Opção inválida. Digite um número válido ou -1 para sair");
						}							
						
					}
					
					if (clienteSelecionado.getSaldo() >= totalVenda) {
						clienteSelecionado.setSaldo(clienteSelecionado.getSaldo()- totalVenda);
					} else {
						System.out.println("Saldo insuficiente.");
						break;
					}
					
					Venda novaVenda = new Venda(clienteSelecionado);
					novaVenda.setItens(itensVenda);
					
					listaVendas.add(novaVenda);
					
					System.out.println("Venda realizada com sucesso");
					break;
				} else {
					System.out.println("Cliente não encontrado.");
				}					
			}					
				case 6:
					System.out.println("Digite o número correspondente ao cliente que deseja adicionar saldo:");
					for (int i = 0; i < listaClientes.size(); i++) {
				        System.out.println((i + 1) + " . " + listaClientes.get(i).getNome());
				    }
					int indiceClienteDeposito = scanner.nextInt();
					if (indiceClienteDeposito > 0 && indiceClienteDeposito <= listaClientes.size()) {
				        System.out.println("Digite o valor a ser depositado:");
				        float valorDeposito = scanner.nextFloat();
				        if (valorDeposito > 0) {
				            Cliente clienteDeposito = listaClientes.get(indiceClienteDeposito - 1);
				            clienteDeposito.setSaldo(valorDeposito);
				            System.out.println("Depósito realizado com sucesso. Novo saldo: " + clienteDeposito.getSaldo());
				        } else {
				            System.out.println("Valor de depósito inválido. O valor deve ser maior que zero.");
				        }
				    } else {
				        System.out.println("Cliente não encontrado.");
				    }
				    break;
				case 7:
					System.out.println("Obrigado pela visita e até a próxima!");
					executando = false;
					break;
				default:
					System.out.println("Opção inválida. Favor digitar novamente");
					break;
				}			
			} else {
			System.out.println("Opção inválida. Favor digitar um número");
			scanner.nextLine();
			
		}
		
		}
		scanner.close();	
	
	}

}



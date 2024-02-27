package br.com.loja;

import java.util.ArrayList;

public class Venda {
	private Cliente cliente;
	private ArrayList<ItemVenda> itens;
	
	public Venda(Cliente cliente) {
		this.cliente = cliente;
		this.itens = new ArrayList<>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemVenda> itens) {
		this.itens = itens;
	}
	
	//Método para calcular o total da venda
	public float calcularTotal() {
		float total = 0.0f;
		for (ItemVenda item : itens) {
			total = total + item.calcularSubtotal();
		}
		return total;
	}
}

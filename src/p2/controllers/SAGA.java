package p2.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import p2.entities.Cliente;

public class SAGA {
	private Map<String, Cliente> clientes;

	public SAGA() {
		this.clientes = new HashMap<>();
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		if (clientes.containsKey(cpf))
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
		return cpf;
	}
	
	public String listaClientes() {
		List<String> clientes = new ArrayList<>();
		for(Cliente c : this.clientes.values()) {
			clientes.add(c.toString());
		}
		Collections.sort(clientes);
		return clientes.stream().map(c -> c.toString()).collect(Collectors.joining(" | "));
	}
	
	public void removerCliente(String cpf) {
		if (clientes.containsKey(cpf)) {
			clientes.remove(cpf);
		}
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if (!clientes.containsKey(cpf)) 
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		this.clientes.get(cpf).editaAtributo(atributo, novoValor);
	}

	public String exibeCliente(String cpf) {
		if (!clientes.containsKey(cpf)) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		}
		return this.clientes.get(cpf).toString();
	}
}

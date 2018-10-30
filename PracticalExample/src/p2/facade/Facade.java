package p2.facade;

import easyaccept.EasyAccept;
import p2.controllers.SAGA;

public class Facade {

	private SAGA saga;

	public Facade() {
		inicializa();
	}

	public static void main(String[] args) {
		args = new String[] { "p2.facade.Facade", "tests/acceptance_tests/use_case_1.txt" };
		EasyAccept.main(args);
	}

	public void inicializa() {
		this.saga = new SAGA();
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.saga.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return this.saga.exibeCliente(cpf);
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		this.saga.editaCliente(cpf, atributo, novoValor);
	}
	
	public String exibeClientes() {
		return this.saga.listaClientes();	
	}
	
	public void removeCliente(String cpf) {
		this.saga.removerCliente(cpf);
	}
}

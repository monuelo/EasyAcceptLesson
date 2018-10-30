package p2.entities;

public class Cliente {

	private String cpf, nome, email, localizacao;

	public Cliente(String cpf, String nome, String email, String localizacao) {

		validaCpf(cpf);
		validaEntrada(cpf, "Erro no cadastro do cliente: cpf invalido.");
		validaEntrada(nome, "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		validaEntrada(email, "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		validaEntrada(localizacao, "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");

		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %s", this.nome, this.localizacao, this.email);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	public void editaAtributo(String atributo, String novoValor) {
		validaEntrada(atributo, "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		validaEntrada(novoValor, "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		switch (atributo) {
		case "nome":
			this.nome = novoValor;
			break;
		case "localizacao":
			this.localizacao = novoValor;
			break;
		case "email":
			this.email = novoValor;
			break;
		default:
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		}
	}

	private void validaEntrada(String entrada, String mensagem) {
		if (entrada == null || entrada.trim().isEmpty())
			throw new IllegalArgumentException(mensagem);
	}

	private void validaCpf(String cpf) {
		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
	}

}

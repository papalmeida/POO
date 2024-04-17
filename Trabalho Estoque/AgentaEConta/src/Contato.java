import java.util.Date;

// Entidade contato na aplicacao
public class Contato {
	int numero;
	String nome;
	String telefone;
	String email;
	Date dataNasc;

	int pegarNumero() {
		return numero;
	}

	void colocarNumero(int numero) {
		if (numero > 0)
			this.numero = numero;
	}

	String pegarNome() {
		return nome;
	}

	void colocarNome(String nome) {
		if (nome != null && nome.length() > 2)
			this.nome = nome;
	}

	String pegarTelefone() {
		return telefone;
	}

	void colocarTelefone(String telefone) {
		if (telefone != null) // && telefone.length() == 11)
			this.telefone = telefone;
	}

	String pegarEmail() {
		return email;
	}

	void colocarEmail(String email) {
		if (email != null)
			this.email = email;
	}

	Date pegarDataNasc() {
		return dataNasc;
	}

	void colocarDataNasc(Date dataNasc) {
		if (dataNasc != null)
			this.dataNasc = dataNasc;
	}

}

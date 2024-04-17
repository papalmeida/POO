import java.util.Date;

// Entidade agenda na aplicacao
public class Agenda {
	// armazena os contatos em um vetor
	Contato[] contatos = new Contato[4]; // Como aumentar???
	// numero de contatos armazenados na agenda
	int numContatos;
	int proxNumero = 1;

	// adicionar o contato na agenda
	// adiciona na posicao numContatos
	boolean add(Contato c) {
		if (c != null) {
			// verificando se nao estah cheio
			if (numContatos == contatos.length) {
				Contato[] vaux = new Contato[2 * contatos.length];
				for (int i = 0; i < numContatos; i++) {
					vaux[i] = contatos[i];
				}
				contatos = vaux;
			}

			c.colocarNumero(proxNumero);
			proxNumero++;
			contatos[numContatos] = c;
			numContatos++;
			return true;

		} else
			return false;
	}

	boolean excluir(int numero) {
		if (numero > 0) {
			// localizar o contato a ser excluido
			for (int i = 0; i < contatos.length; i++) {
				if (contatos[i] != null
						&& numero == contatos[i].pegarNumero()) {
					// encontrou o contato a ser apagado
					// contatos[i] = null;
					// shift para esquerda
					for (int j = i; j < numContatos; j++) {
						contatos[j] = contatos[j + 1];
					}
					numContatos--;
					contatos[numContatos] = null;
					return true;
				}
			}
			return false;
		} else
			return false;
	}

	boolean alterar(Contato cAlterado) {
		for (int i = 0; i < numContatos; i++) {
			if (cAlterado.pegarNumero() == contatos[i].pegarNumero()) {
				contatos[i] = cAlterado;
				return true;
			}
		}
		return false;
	}

	// Retorna um contato que tenha o numero passado por parametro
	// null se nao encontrar o contato
	Contato buscar(int numero) {
		for (int i = 0; i < numContatos; i++) {
			if (numero == contatos[i].pegarNumero()) {
//				return contatos[i]; // design problematico
				// correto seria usar clonagem de objeto (clonable)
				// retornando uma copia
				Contato aux = new Contato();
				aux.colocarNumero(contatos[i].pegarNumero());
				aux.colocarNome(contatos[i].pegarNome());
				aux.colocarTelefone(contatos[i].pegarTelefone());
				aux.colocarEmail(contatos[i].pegarEmail());
				aux.colocarDataNasc(contatos[i].pegarDataNasc());
				return aux;
			}
		}
		return null;
	}

	// NAO EH NECESSARIO PARAMETRO POIS A AGENDA JA POSSUI OS CONTATOS
	// NAO SE DEVE FAZER E/S EM CLASSES QUE REPRESENTAM ENTIDADES
	// void listar(Contato[] c) { ERRADO!!!
	Contato[] listar() {
//		return contatos; // design problematico
		Contato[] vaux = new Contato[numContatos];
		for (int i = 0; i < numContatos; i++) {
//			vaux[i] = contatos[i];
			vaux[i] = new Contato();
			vaux[i].colocarNumero(contatos[i].pegarNumero());
			vaux[i].colocarNome(contatos[i].pegarNome());
			vaux[i].colocarTelefone(contatos[i].pegarTelefone());
			vaux[i].colocarEmail(contatos[i].pegarEmail());
			vaux[i].colocarDataNasc(contatos[i].pegarDataNasc());
		}
		return vaux; // problemas: explico depois
	}
}

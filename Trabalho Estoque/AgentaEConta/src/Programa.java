import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
	static Scanner scn = new Scanner(System.in);
	// static Agenda agenda = new Agenda();

	public static void main(String[] args) {
		// iniciar a computacao
		Agenda agenda = new Agenda();
		init(agenda);

		int opcao;
		// Scanner scn = new Scanner(System.in);

		// menu de operacao da agenda
		do {
			System.out.println("0- SAIR");
			System.out.println("1- adicionar");
			System.out.println("2- excluir");
			System.out.println("3- editar");
			System.out.println("4- listar");
			opcao = scn.nextInt();

			switch (opcao) {
			case 0:
				System.out.println("Encerrando o programa");
				break;
			case 1:
				adicionar(agenda);
				break;
			case 2:
				excluir(agenda);
				break;
			case 3:
				alterar(agenda);
				break;
			case 4:
				Contato[] lista = agenda.listar();
				imprimir(lista);
				for (int i = 0; i < lista.length; i++)
					lista[i].numero = 0;
				break;

			default:
				break;
			}

		} while (opcao != 0);

		System.out.println("Fim");

	}

	static void init(Agenda agenda) {
		Contato c = new Contato();
		c.colocarNumero(1);
		c.colocarNome("jose");
		c.colocarEmail("jose@gmail.com");
		c.colocarTelefone("98888-1234");
		c.colocarDataNasc(new Date());
		agenda.add(c);

		c = new Contato();
		c.colocarNumero(2);
		c.colocarNome("maria");
		c.colocarEmail("maria@gmail.com");
		c.colocarTelefone("98777-1234");
		c.colocarDataNasc(new Date());
		agenda.add(c);

		c = new Contato();
		c.colocarNumero(3);
		c.colocarNome("ana amelia");
		c.colocarEmail("ana@gmail.com");
		c.colocarTelefone("96777-1234");
		c.colocarDataNasc(new Date());
		agenda.add(c);

		c = new Contato();
		c.colocarNumero(4);
		c.colocarNome("joao");
		c.colocarEmail("joao@gmail.com");
		c.colocarTelefone("95555-1234");
		c.colocarDataNasc(new Date());
		agenda.add(c);

	}

	static void adicionar(Agenda agenda) {
		// ler o contato
		Contato c = lerContato();
		// adicionar na agenda
		boolean r = agenda.add(c);
		if (r)
			System.out.println("Contato adicionado");
		else
			System.out.println("Falha em adicionar contato");
	}

	static Contato lerContato() {
		// Scanner scn = new Scanner(System.in);
		Contato c = new Contato();
		System.out.println(" - Ler contato - ");
		System.out.print("Nome: ");
		// c.nome = scn.next();
		c.colocarNome(scn.next());
		System.out.print("telefone: ");
		c.colocarTelefone(scn.next());
		System.out.print("E-mail: ");
		c.colocarEmail(scn.next());

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Data Nasc: ");
		String data = scn.next();

		try {
			c.colocarDataNasc(sdf.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c;
	}

	static void alterar(Agenda agenda) {
		// listar
		Contato[] lista = agenda.listar();
		imprimir(lista);
		// escolher o contato que serah alterado
		System.out.print("Digite o numero do contato a ser alterado: ");
		int numero = scn.nextInt();
		// buscar o contato pelo numero
		Contato c = agenda.buscar(numero);
		// alterar
		System.out.println("Numero: " + c.pegarNumero());
		System.out.println("Nome: " + c.pegarNome());
		System.out.println("telefone: " + c.pegarTelefone());
		System.out.println("E-mail: " + c.pegarEmail());
		System.out.println("Data Nasc: " + c.pegarDataNasc());
		System.out.println("---");

		Contato cAlterado = lerContato(); // nao le o numero
		cAlterado.colocarNumero(c.pegarNumero());

		// atualizar o contato alterado na agenda
		boolean r = agenda.alterar(cAlterado); // onde vai efetivamente alterar
		// imprimir msg sobre o status da alteracao
		if (r)
			System.out.println("Alterou o contato com sucesso");
		else
			System.out.println("Falha em alterar");
	}

	static void excluir(Agenda agenda) {
		// listar os contatos
		Contato[] lista = agenda.listar();
		imprimir(lista);
		// escolher contato a ser excluido pelo numero
		System.out.print("Digite o numero do contato a ser excluido: ");
		int numero = scn.nextInt();
		// excluir
		boolean r = agenda.excluir(numero);
		// imprimir msg sobre o status da exclusao
		if (r)
			System.out.println("Excluiu o contato com sucesso");
		else
			System.out.println("Falha em excluir");
	}

	static void imprimir(Contato[] contatos) {
		System.out.println(" - Lista de Contatos - ");
		System.out.println("NUM\tNOME\tTEL");
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(contatos[i].pegarNumero() + "\t"
						+ contatos[i].pegarNome() + "\t"
						+ contatos[i].pegarTelefone());
			}
		}
	}
}

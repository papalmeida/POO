import java.text.DecimalFormat;
import java.util.Scanner;

public class Sistema {

    static Scanner scn = new Scanner(System.in); 
    public static void main(String[] args) throws Exception {
        
        Estoque estoque = new Estoque();
        int operacao;

        /* Menu */
        do {
            System.out.println("\nO que deseja fazer?\n");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Excluir produto");
            System.out.println("3. Alterar produto");
            System.out.println("4. Listar produtos");
            System.out.println("5. Detalhar produto");
            System.out.print("\nDigite o comando: ");
            operacao = scn.nextInt(); 

			switch (operacao) {
			case 0:
                System.out.println("\nPrograma Finalizado");
				break;
			case 1:
                cadastrar(estoque);
				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;

			default:
				break;
			}

		} while (operacao != 0); 
    }

    static void init(Estoque estoque) {
        Produto produto = new Produto();
        
        String nomes[] = {"Leite", "Macarrão", "Ovos", "Linguiça Suína", "Lagarto"};
        String marcas[] = {"Ibituruno", "Santa Amália", "Zé do Ovo", "Perdigão", "Reptideo"};
        float precos[] = {3.69f, 2.99f, 20.00f, 29.99f, 26.99f};
        
        for (int i = 0; i < 5; i++) {
            produto.addNome(nomes[i]);
            produto.addMarca(marcas[i]);
            produto.addPreco(precos[i]);
            produto.addQuantidade(20);
            estoque.inserir(produto);
        }
    }

    static void cadastrar(Estoque estoque) {
        Produto p = new Produto();
        String nome;
        int verificadorDeNome = 0;
        scn.nextLine();

        System.out.println("Digite as informações do produto:");
        do{
            if(verificadorDeNome!=0) {
                System.out.println("Produto já cadastrado.");
            }
            System.out.print("\nNome:");
            nome = scn.nextLine();
            verificadorDeNome++;
        } while(estoque.);

        p.addNome(nome);
        System.out.print("Marca: ");
        p.addMarca(scn.nextLine());
        System.out.print("Preço: ");
        p.addPreco(scn.nextFloat());
        System.out.print("Quantidade: ");
        p.addQuantidade(scn.nextInt());

    }
}
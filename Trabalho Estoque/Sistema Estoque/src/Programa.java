import java.text.DecimalFormat;
import java.util.Scanner;

public class Programa { 

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        Estoque estoque = new Estoque();
        int comando;
        init(estoque);

        Menu:
        while (true) {
            System.out.println("\n\nBem Vindo ao Lojinho do Tadeu!\nComo posso ajudá-lo?\n");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Alterar Produto");
            System.out.println("4. Listar Produtos");
            System.out.print("\n==> ");
            comando = scn.nextInt();

            switch (comando) {
                case 0: 
                    //Sair
                    System.out.println("\nPrograma finalizado.");
                    Thread.sleep(1000);
                    break Menu;

                case 1:
                    //Inserir
                    inserir(estoque);
                    Thread.sleep(1000);
                    break;

                case 2:
                    //Excluir;
                    break;

                case 3:
                    //Alterar;
                    break;

                case 4:
                    //Listar
                    listar(estoque);
                    Thread.sleep(3000);
                    break;
            
                default:
                    System.out.println("\nComando inválido. Tente novamente.");
                    Thread.sleep(1000);
                    break;
            }
        }
    }

    //Cadastro automático de 5 produtos
    static void init(Estoque estoque) {
        Produto produto = new Produto();
        
        String nomes[] = {"Arroz", "Feijão", "Batata Frita", "Picanha Suína", "Suco de Laranja"};
        String marcas[] = {"PratoFino", "Camil", "BemBrasil", "Saudali", "Del Valle"};
        float precos[] = {11.99f, 8.89f, 41.49f, 29.99f, 4.29f};
        
        for (int i = 0; i < 5; i++) {
            produto.setNome(nomes[i]);
            produto.setMarca(marcas[i]);
            produto.setPreco(precos[i]);
            produto.setQntdEstoque(20);
            estoque.inserir(produto);
        }
    }

    //Inserir produto
    static void inserir(Estoque estoque) {
        Produto produto = new Produto();
        scn.nextLine();
        
        System.out.println("\nDigite as informações do produto a seguir:\n");
        System.out.print("Nome: ");
        produto.setNome(scn.nextLine());
        System.out.print("Marca: ");
        produto.setMarca(scn.nextLine());
        System.out.print("Preço: ");
        produto.setPreco(scn.nextFloat());
        System.out.print("Quantidade: ");
        produto.setQntdEstoque(scn.nextInt());
        
        if (estoque.inserir(produto)) {
            System.out.println("\n" + produto.getNome() + " cadastrado com sucesso.");
        } else {
            System.out.println("\nFalha ao cadastrar.");
        }
    }

    //Listar produtos
    static void listar(Estoque estoque) {

        System.out.println("\nListar por ordem...\n");
        System.out.println("1. De Cadrastro?");
        System.out.println("2. Alfabética?");
        System.out.print("\n==> ");
        int comando = scn.nextInt();

        DecimalFormat currency = new DecimalFormat("#,##0.00");
        Produto[] produtos;
        int nProdutos = estoque.getNProdutos();
String linhaMenu = "----------------------------------------------------";
        switch (comando) {
            //Ordem por código
            case 1:
                produtos = estoque.listarTodos();

                linhaMenu += "---------------";
                System.out.println();
                System.out.println(linhaMenu);
                System.out.printf("|  %-6s  |  %-20s  |  %-8s    |  %-10s  |", 
                "CÓDIGO", "NOME", "PREÇO", "QUANTIDADE");
                System.out.println();
                System.out.println(linhaMenu);
                
                for (int i = 0; i < estoque.getNProdutos(); i++) {
                    System.out.printf(
                        "|  %-6d  |  %-20s  |  R$%8s  |  %-10d  |",
                        produtos[i].getCodigo(), produtos[i].getNome(),
                        currency.format(produtos[i].getPreco()),produtos[i].getQntdEstoque());
                        System.out.println();
                }
                    System.out.println(linhaMenu);
                    break;

            //Ordem alfabética
            case 2:
                produtos = estoque.listarPorNome();

                System.out.println();
                System.out.println(linhaMenu);
                System.out.printf("|  %-20s  |  %-6s  |  %-8s    |", 
                "NOME", "CÓDIGO", "PREÇO");
                System.out.println();
                System.out.println(linhaMenu);

                for (int i = 0; i < nProdutos; i++) {
                    System.out.printf(
                        "|  %-20s  |  %-6d  |  R$%8s  |",
                        produtos[i].getNome(), produtos[i].getCodigo(),
                        currency.format(produtos[i].getPreco()));
                        System.out.println();
                }
                System.out.println(linhaMenu);
                
                break;
        
            default:
                System.out.println("\nERROR!!!");
                break;
        }
    }

    static Produto[] ordenarProdutos(Produto[] produtos) {
        Produto auxOrdem = new Produto();
        int nProdutos = produtos.length;
        for (int i = 0; i < nProdutos; i++) {
            for (int j = i + 1; j < nProdutos; j++) {
                if ((produtos[i].getNome()).compareTo(produtos[j].getNome()) > 0) {
                    auxOrdem = produtos[i];
                    produtos[i] = produtos[j];
                    produtos[j] = auxOrdem;
                }
            }
        }
        return produtos;
    }
}

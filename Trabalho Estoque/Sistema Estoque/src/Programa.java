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
                    excluir(estoque);
                    Thread.sleep(1000);
                    break;

                case 3:
                    //Alterar;
                    alterar(estoque);
                    Thread.sleep(1000);
                    break;

                case 4:
                    //Listar
                    listar(estoque);
                    Thread.sleep(2500);
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
        
        String nomes[] = {"Arroz 5kg", "Macarrão", "Feijão 1kg", "Caixa de Bombom", "Suco de Laranja"};
        String marcas[] = {"PratoFino", "Mara", "Anchieta", "Lacta", "Del Valle"};
        float precos[] = {25.00f, 3.50f, 3.99f, 11.99f, 4.29f};
        
        for (int i = 0; i < 5; i++) {
            produto.setNome(nomes[i]);
            produto.setMarca(marcas[i]);
            produto.setPreco(precos[i]);
            produto.setQntdEstoque(500);
            estoque.inserir(produto);
        }
    }

    //Inserir produto
    static void inserir(Estoque estoque) {
        Produto produto = new Produto();
        String nome;
        int m = 0;
        scn.nextLine();
        
        System.out.println("\nDigite as informações do produto a seguir:\n");
        do {
            if (m != 0) {
                System.out.println("\nEste nome já existe. Tente novamente.\n");
            }
            System.out.print("Nome: ");
            nome = scn.nextLine();
            m++;
        } while (estoque.nomeIgual(nome));
        produto.setNome(nome);
        System.out.print("Marca: ");
        produto.setMarca(scn.nextLine());
        System.out.print("Preço: ");
        produto.setPreco(scn.nextFloat());
        System.out.print("Quantidade: ");
        produto.setQntdEstoque(scn.nextInt());
        
        System.out.println();
        if (estoque.inserir(produto)) {
            System.out.println( "Produto cadastrado com sucesso.");
        } else {
            System.out.println("Falha ao cadastrar.");
        }
    }

    //Excluir produto
    static void excluir(Estoque estoque) {
        listarTodos(estoque.listarTodos());
        System.out.print("\nDigite o código do produto que deseja excluir: ");
        int codigo = scn.nextInt();
        Produto produto = estoque.buscar(codigo);
        
        System.out.println();
        if (produto == null) {
            System.out.println("Não foi possível encontrar um produto com esse código.");
            return;
        }
        System.out.println("Tem certeza que deseja excluir " + produto.getNome() + "?\n");
        System.out.println("1. Não");
        System.out.println("2. Sim");
        System.out.print("\nConfirmar: ");
        if (scn.nextInt() == 1) {
            System.out.println();
            if (estoque.excluir(codigo)) {
                System.out.println("Produto excluído com sucesso.");
            } else {
                System.out.println("Falha ao excluir.");
            }
        }
    }

    //Alterar produto
    static void alterar(Estoque estoque) {
        listarTodos(estoque.listarTodos());
        System.out.print("\nDigite o código do produto que deseja alterar: ");
        int codigo = scn.nextInt();
        Produto produto = estoque.buscar(codigo);

        System.out.println();
    
        if (produto == null) {
            System.out.println("Não foi possível encontrar um produto com esse código.");
            return;
        }

        System.out.println("Qual informação deseja alterar?\n");
        System.out.println("0. Cancelar alteração");
        System.out.println("1. Nome");
        System.out.println("2. Marca");
        System.out.println("3. Preço");
        System.out.println("4. Quantidade");
        System.out.print("\n==> ");
        int caso = scn.nextInt();
        scn.nextLine();
        
        System.out.println();
        switch (caso) {
            case 0:
            System.out.println("Alteração cancelada.");
            return;
            case 1:
            System.out.print("Digite o novo nome: ");
            produto.setNome(scn.nextLine());
            break;
            case 2:
            System.out.print("Digite a nova marca: ");
            produto.setMarca(scn.nextLine());
            break;
            case 3:
            System.out.print("Digite o novo preço: ");
            produto.setPreco(scn.nextFloat());
            break;
            case 4:
            System.out.print("Digite a nova quantidade: ");
            produto.setQntdEstoque(scn.nextInt());
            break;
            
            default:
            System.out.println("Falha ao alterar.");
            return;
        }
        System.out.println();
        if (estoque.alterar(codigo, produto)) {
            System.out.println("Produto alterado com sucesso.");
        } else {
            System.out.println("Falha ao alterar.");
        }
    }

    //Listar produtos
    static void listar(Estoque estoque) {

        System.out.println("\nListagem\n");
        System.out.println("1. Detalhar Produto");
        System.out.println("2. Por Cadrastro");
        System.out.println("3. Por Ordem Alfabética");
        System.out.print("\n==> ");
        int comando = scn.nextInt();

        DecimalFormat currency = new DecimalFormat("#,##0.00");
        Produto[] produtos;
        int nProdutos = estoque.getNProdutos();
        String linhaMenu = "----------------------------------------------------";

        switch (comando) {
            //Ordem por código
            case 1:
                detalhar(estoque);
                break;

            //Ordem por código
            case 2:
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
            case 3:
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

    //Listar todos os produtos(usado na hora de excluir e alterar)
    static void listarTodos(Produto[] produtos) {

        DecimalFormat moeda = new DecimalFormat("#,##0.00");
        int nProdutos = produtos.length;
        String linhaMenu = "-------------------------------------------------------" + 
        "-------------------------------";

        System.out.println();
        System.out.println(linhaMenu);
        System.out.printf("|  %-6s  |  %-20s  |  %-14s  |  %-8s    |  %-10s  |", 
            "CÓDIGO", "NOME", "MARCA", "PREÇO", "QUANTIDADE");
        System.out.println();
        System.out.println(linhaMenu);
            
        for (int i = 0; i < nProdutos; i++) {
            System.out.printf(
                "|  %-6d  |  %-20s  |  %-14s  |  R$%8s  |  %-10d  |",
                produtos[i].getCodigo(), produtos[i].getNome(), produtos[i].getMarca(),
                moeda.format(produtos[i].getPreco()),produtos[i].getQntdEstoque());
            System.out.println();
        }
        System.out.println(linhaMenu);
    }

    //Detalhar um produto
    static void detalhar(Estoque estoque) {
        System.out.println("\nComo deseja detalhar?\n");
        System.out.println("1. Por Código");
        System.out.println("2. Por Nome");
        System.out.print("\n==> ");
        int caso = scn.nextInt();
        Produto produto = new Produto();
        Produto[] vetAux = new Produto[1];

        System.out.println();
        switch (caso) {
            case 1:
                System.out.print("Digite o código do produto: ");
                int codigo = scn.nextInt();
                produto = estoque.buscar(codigo);
                break;
                
            case 2:
                scn.nextLine();
                System.out.print("Digite o nome do produto: ");
                String nome = scn.nextLine();
                produto = estoque.buscarPorNome(nome); 
                break;
        
            default:
                System.out.println("Comando inválido.");
                return;
        }

        if (produto != null) {
            vetAux[0] = produto;
            listarTodos(vetAux);
        } else {
            System.out.println("\nProduto não encontrado.");
        }
    }

    //Imprime por ordem alfabetica
    static void listarPorNome(Produto[] produtos) {
        
        DecimalFormat moeda = new DecimalFormat("#,##0.00");
        int nProdutos = produtos.length;
        String linhaMenu = "-------------------------------------------------------" + 
        "-------------------------------";

        System.out.println();
        System.out.println(linhaMenu);
        System.out.printf("|  %-20s  |  %-6s  |  %-14s  |  %-8s    |  %-10s  |", 
            "NOME", "CÓDIGO", "MARCA","PREÇO", "QUANTIDADE");
        System.out.println();
        System.out.println(linhaMenu);
                
        for (int i = 0; i < nProdutos; i++) {
            System.out.printf(
                "|  %-20s  |  %-6d  |  %-14s  |  R$%8s  |  %-10s  |",
                produtos[i].getNome(), produtos[i].getCodigo(), produtos[i].getMarca(),
                moeda.format(produtos[i].getPreco()), produtos[i].getQntdEstoque());
            System.out.println();
        }

        System.out.println(linhaMenu);
    }


}

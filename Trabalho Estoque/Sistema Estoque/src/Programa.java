import java.text.DecimalFormat;
import java.util.Scanner;

public class Programa { 

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        Estoque estoque = new Estoque();
        init(estoque);
        listar(estoque);
        System.out.println("\n\nDigite um número: ");
        int n = scn.nextInt();
        System.out.println("\nSeu número é" + n);
    }

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

    static void listar(Estoque estoque) {
        
        System.out.println();
        System.out.println("1. Por Código");
        System.out.println("2. Alfabética");
        System.out.print("\nDigite a ordem: ");
        int ordem = scn.nextInt();

        DecimalFormat moeda = new DecimalFormat("#,##0.00");
        Produto[] produtos = estoque.listar();

        switch (ordem) {
            /* Ordem por código (código, nome, preço e quantidade) */
            case 1:
                String linhaMenu = "-------------------------------------------------------------------";
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
                        moeda.format(produtos[i].getPreco()),produtos[i].getQntdEstoque());
                        System.out.println();
                }
                    System.out.println(linhaMenu);
                    break;

            /* Ordem alfabética (nome, código, preço) */
            case 2:
                
                break;
        
            default:
                System.out.println("Erro.");
                break;
        }
    }
}

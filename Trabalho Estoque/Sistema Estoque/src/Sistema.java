import java.util.Scanner;

public class Programa { 

    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        Estoque estoque = new Estoque();
        init(estoque);

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
}

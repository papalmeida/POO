public class Estoque {
    Produto[] produtos = new Produto[10];
    int nProdutos = 0;
    int codigo = 1;

    boolean inserir(Produto novoProduto) {
        if (novoProduto != null) {
            /* Verificar se a lista de produtos está cheia */
            if (nProdutos == produtos.length) {
                Produto[] vetAux = new Produto[nProdutos * 2];
                for (int i = 0; i < nProdutos; i++) {
                    vetAux[i] = produtos[i];
                }
                produtos = vetAux;
            }
            for (int i = 0; i < produtos.length; i++) {
                if (produtos[i] == null) {
                    produtos[i] = new Produto();

                    produtos[i].addCodigo(codigo);
                    produtos[i].addNome(novoProduto.getNome());
                    produtos[i].addMarca(novoProduto.getMarca());
                    produtos[i].addPreco(novoProduto.getPreco());
                    produtos[i].addQuantidade(novoProduto.getQuantidade());

                    codigo++;
                    nProdutos++;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    boolean verificarNome(String nome) {
        for (int i = 0; i < nProdutos; i++) {
            if (produtos[i].nome.equalsIgnoreCase(nome)) {
                return true;
            } 
        }
        return false;
    }
}
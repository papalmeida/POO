public class Estoque {
    Produto[] produtos = new Produto[10];
    int nProdutos = 0;
    int codigo = 0;

    boolean inserir(Produto produto) {
        if (produto != null) {
            if (nProdutos == produtos.length) {
                Produto[] vetAux = new Produto[nProdutos * 2];
                for (int i = 0; i < nProdutos; i++) {
                    vetAux[i] = produtos[i];
                }
                produtos = vetAux;
            }
            if (produtos[nProdutos] == null) {
                produtos[nProdutos] = new Produto();

                produtos[nProdutos].setCodigo(this.codigo);
                produtos[nProdutos].setNome(produto.getNome());
                produtos[nProdutos].setMarca(produto.getMarca());
                produtos[nProdutos].setPreco(produto.getPreco());
                produtos[nProdutos].setQntdEstoque(produto.getQntdEstoque());

                this.codigo++;
                nProdutos++;
                return true;
            }
        }
        return true;
    }

    boolean excluir(int codigo) {
        if (codigo > 0) {
            for (int i = 0; i < nProdutos; i++) {
                if (produtos[i].getCodigo() == codigo) {
                    for (int j = 0; j < produtos.length - 1; j++) {
                        produtos[j] = produtos[j + 1];
                    }
                    nProdutos--;
                    produtos[nProdutos] = null;
                    return true;
                }
            }
        }
        return false;
    }

    boolean alterar(Produto produto) {
        return true;
    }

    Produto buscar(int codigo) {
        return null;
    }

    Produto[] listarTodos() {
        return a;
    }

    Produto[] listarPorNome() {
        return b;
    }

    private boolean produtoIgual(Produto novoProduto) {
        for (int i = 0; i < nProdutos; i++) {
            if (produtos[i].nome.equalsIgnoreCase(novoProduto.nome))
                return true;
        }
        return false;
    }
}

public class Estoque {
    Produto[] produtos = new Produto[10];
    int nProdutos = 0;
    int codigo = 1;

    //Inserir novo produto
    boolean inserir(Produto produto) {
        if (produto != null) {
            if (nProdutos == produtos.length) {
                Produto[] vetAux = new Produto[nProdutos * 2];
                for (int i = 0; i < nProdutos; i++) {
                    vetAux[i] = produtos[i];
                }
                produtos = vetAux;
            }
            if (!nomeIgual(produto)) {
                for (int i = 0; i < produtos.length; i++) {
                    if (produtos[nProdutos] == null) {
                        produtos[nProdutos] = new Produto();
        
                        produtos[nProdutos].setCodigo(this.codigo);
                        produtos[nProdutos].setNome(produto.getNome());
                        produtos[nProdutos].setMarca(produto.getMarca());
                        produtos[nProdutos].setPreco(produto.getPreco());
                        produtos[nProdutos].setQntdEstoque(produto.getQntdEstoque());
        
                        codigo++;
                        nProdutos++;
                        return true;
                    }
                }
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
        Produto[] vetAux = new Produto[nProdutos];
        for (int i = 0; i < nProdutos; i++) {
            vetAux[i] = new Produto();
            vetAux[i].setCodigo(produtos[i].getCodigo());
            vetAux[i].setNome(produtos[i].getNome());
            vetAux[i].setMarca(produtos[i].getMarca());
            vetAux[i].setPreco(produtos[i].getPreco());
            vetAux[i].setQntdEstoque(produtos[i].getQntdEstoque());
        }
        return vetAux;
    }

    Produto[] listarPorNome() {
        Produto[] vetAux = ordenarProdutos();
        return vetAux;
    }

    private boolean nomeIgual(Produto produto) {
        for (int i = 0; i < nProdutos; i++) {
            if (produtos[i].nome.equalsIgnoreCase(produto.nome))
                return true;
        }
        return false;
    }

    int nProdutos() {
        int nProdutos = 0;

        for (int i = 0; i < produtos.length; i++) {
            nProdutos++;
        }

        return nProdutos;
    }

    int getNProdutos() {
        return nProdutos;
    }

    private Produto[] ordenarProdutos() {
        Produto auxProtudo = new Produto();
        Produto[] vetAux = listarTodos();
        for (int i = 0; i < nProdutos; i++) {
            for (int j = i + 1; j < nProdutos; j++) {
                if ((vetAux[i].getNome()).compareToIgnoreCase(vetAux[j].getNome()) > 0) {
                    auxProtudo = vetAux[i];
                    vetAux[i] = vetAux[j];
                    vetAux[j] = auxProtudo;
                }
            }
        }
        return vetAux;
    }
}

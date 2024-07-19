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
            return false;
        }
        return false;
    }

    //Excluir um produto
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

    //Alterar um produto
    boolean alterar(int codigo, Produto produtoAlterado) {
        if (produtoAlterado != null) {
            for (int i = 0; i < nProdutos; i++) {
                if (produtos[i].getCodigo() == codigo) {
                    produtos[i] = produtoAlterado;
                    return true;
                }
            }
        } 
        return false;
    }

    //Buscar um produto
    Produto buscar(int codigo) {
        for (int i = 0; i < nProdutos; i++) {
            if (produtos[i].getCodigo() == codigo) {
                return produtos[i];
            }
        }
        return null;
    }

    //Listar todos os produtos
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

    //Listar em ordem alfabetica
    Produto[] listarPorNome() {
        Produto[] vetAux = ordenarProdutos();
        return vetAux;
    }

    //Verificar se um já existe um produto com o mesmo nome
    boolean nomeIgual(String nome) {
        for (int i = 0; i < nProdutos; i++) {
            if (produtos[i].nome.equalsIgnoreCase(nome))
                return true;
        }
        return false;
    }

    //Quantidade de produtos cadastrados
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

    //Ordenar o array de produtos
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

    Produto buscarPorNome(String nome) {
        for (int i = 0; i < nProdutos; i++) {
            if (produtos[i].getNome().equalsIgnoreCase(nome)) {
                return produtos[i];
            }
        }
        return null;
    }
}

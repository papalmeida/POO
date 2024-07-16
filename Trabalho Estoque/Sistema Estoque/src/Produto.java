public class Produto {
    int codigo; //auto gerado
    String nome;
    String marca;
    double preco;
    int qntdEstoque;

    int getCodigo() {
        return codigo;
    }
    void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    String getNome() {
        return nome;
    }
    void setNome(String nome) {
        this.nome = nome;
    }

    String getMarca() {
        return marca;
    }
    void setMarca(String marca) {
        this.marca = marca;
    }

    double getPreco() {
        return preco;
    }
    void setPreco(double preco) {
        this.preco = preco;
    }
    
    int getQntdEstoque() {
        return qntdEstoque;
    }
    void setQntdEstoque(int qntdEstoque) {
        this.qntdEstoque = qntdEstoque;
    }
}

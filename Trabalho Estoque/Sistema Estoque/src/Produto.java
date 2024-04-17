public class Produto {
    int codigo;
    String nome;
    String marca;
    float preco;
    int quantidade;

    void addCodigo(int codigo) {
        this.codigo = codigo;
    }
    int getCodigo() {
        return codigo;
    }
    
    void addNome(String nome) {
        this.nome = nome;
    }
    String getNome() {
        return nome;
    }
    
    void addMarca(String marca) {
        this.marca = marca;
    }
    String getMarca() {
        return marca;
    }

    void addPreco(float preco) {
        this.preco = preco;
    }
    float getPreco() {
        return preco;
    }

    void addQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    int getQuantidade() {
        return quantidade;
    }
}
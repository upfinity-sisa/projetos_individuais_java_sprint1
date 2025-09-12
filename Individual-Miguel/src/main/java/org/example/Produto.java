package org.example;

public class Produto {
    Integer id;
    String nome;
    Integer quantidade;
    Double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public String getNome() { // <-- ESTE MÉTODO PROVAVELMENTE ESTÁ FALTANDO
        return this.nome;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    public double getPreco() {
        return this.preco;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    @Override
    public String toString() {
        return "Produto: " + this.nome + " | Quantidade: " + this.quantidade + " | Preço Unitário: R$ " + String.format("%.2f", this.preco);
    }
}


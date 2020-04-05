package classes;

import java.io.Serializable;

public class Produto implements Serializable {
    private int codigo;
    private String descricao;
    private int qtdEstoque;

    public Produto(int codigo, String descricao, int qtdEstoque){
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString(){
        return "Codigo: " + this.codigo + "\t| Descricao: " + this.descricao + "\t| Quantidade em estoque: " + qtdEstoque;
    }
}
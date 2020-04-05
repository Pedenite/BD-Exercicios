package classes;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Produto implements Serializable {

    private static final long serialVersionUID = 0x1000000000000000L;

    private int codigo;
    private String descricao;
    private int qtdEstoque;
    private String pattern = "0000000000";
    private DecimalFormat df = new DecimalFormat(pattern);

    public Produto(int codigo, String descricao, int qtdEstoque){
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString(){
        return "Codigo: " + df.format(this.codigo) + "\t| Descricao: " + this.descricao + "\t| Quantidade em estoque: " + qtdEstoque;
    }
}
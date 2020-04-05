package classes;

import java.util.*;
import java.io.*;

public class Loja implements Serializable{
    private ArrayList<Produto> produtos;

    public Loja(){
        produtos = new ArrayList<>();
    }

    public void listarProdutos(){
        System.out.println("\nLista de produtos em estoque:");
        if(produtos.isEmpty()){
            System.out.println("<vazio>");
        }
        for(Produto elem : produtos){
            System.out.println(elem);
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Aperte <enter> para continuar");
        scan.nextLine();
    }

    public void incluiProduto(Produto p){
        produtos.add(p);
    }
}
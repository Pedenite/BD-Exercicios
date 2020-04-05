package classes;

import java.util.*;
import java.io.*;

public class Loja implements Serializable{

    private static final long serialVersionUID = 0x2000000000000000L;

    private ArrayList<Produto> produtos;

    public Loja(){
        produtos = new ArrayList<>();
    }

    public void listarProdutos(){
        System.out.println("\nLista de produtos em estoque:");
        if(produtos.isEmpty()){
            System.out.println("<vazio>");
        }
        int i = 0;
        for(Produto elem : produtos){
            i++;
            System.out.print("Produto " + i + ":\t");
            System.out.println(elem);
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Aperte <enter> para continuar");
        scan.nextLine();
    }

    public void imprimeRegistro() throws FileNotFoundException{
        PrintWriter pw = new PrintWriter("registro.txt");
        pw.println("Lista de produtos em estoque:");
        if(produtos.isEmpty()){
            pw.println("<vazio>");
        }
        int i = 0;
        for(Produto elem : produtos){
            i++;
            pw.print("Produto " + i + ":\t");
            pw.println(elem);
        }
        pw.close();
    }

    public void incluiProduto(Produto p){
        produtos.add(p);
    }
}
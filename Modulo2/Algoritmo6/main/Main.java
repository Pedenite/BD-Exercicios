package main;

import classes.*;
import java.util.*;
import java.io.*;

public class Main{
    //Variaveis globais
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    //Funcoes
    private static void menu(){
        System.out.println("---------------------------Menu---------------------------\n0 - sair\n1 - adicionar produto\n2 - listar todos os produtos");
        System.out.print("Digite o numero correspondente a opcao que deseja >>> ");
    }
    private static void adicionarProduto(Scanner scan, Loja loja){
        int c;
        String d;
        int q;
        System.out.print("Digite o codigo do produto >>> ");
        try{
            c = scan.nextInt();
        } catch (Exception e) {
            System.out.println(ANSI_RED + "O codigo deve conter apenas numeros inteiros de 32bits!" + ANSI_RESET);
            scan.next();
            return;
        }
        System.out.print("Digite a descricao do produto >>> ");
        scan.nextLine();
        d = scan.nextLine();
        System.out.print("Digite a quantidade em estoque >>> ");
        try{
            q = scan.nextInt();
        } catch (Exception e) {
            System.out.println(ANSI_RED + "A quantidade deve conter apenas numeros inteiros de 32bits!" + ANSI_RESET);
            scan.next();
            return;
        }
        loja.incluiProduto(new Produto(c, d, q));
        return;
    }

    public static void main(String args[]) throws FileNotFoundException, IOException{
        
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        int opt;
        Loja loja;
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("produtos.bin"));
            loja = (Loja) ois.readObject();
            loja.listarProdutos(); 
        } catch(Exception e) {
            System.out.println(ANSI_RED + "Arquivo nao encontrado!" + ANSI_RESET + "\nLoja inicializando vazia...");
            loja = new Loja();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        while(!exit){
            menu();
            try{
                opt = scan.nextInt();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Favor digitar apenas numeros inteiros de 32bits!" + ANSI_RESET);
                scan.next();
                continue;
            }
            switch(opt){
                case 0:
                    exit = true;
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("produtos.bin"));
                    oos.writeObject(loja);
                    oos.close();
                    System.out.println("Serializacao concluida!");
                    loja.imprimeRegistro();
                    System.out.println("Registro Impresso!");
                    break;
                case 1:
                    adicionarProduto(scan, loja);
                    break;
                case 2:
                    loja.listarProdutos();
                    break;
                default:
                    System.out.println(ANSI_RED + "Opcao invalida!" + ANSI_RESET);
                    break;
            }
        }
    }
}
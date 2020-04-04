package main;

import classes.Produto;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Loja{
    public static void main(String args[]){
        
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        int opt;
        List<Produto> loja = new ArrayList<>();

        Produto p1 = new Produto(1, "Gayness", 100);
        loja.add(p1);

        System.out.println(loja);

        while(!exit){
            menu();
            try{
                opt = scan.nextInt();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Favor digitar apenas numeros!" + ANSI_RESET);
                scan.next();
                continue;
            }
            switch(opt){
                case 0:
                    exit = true;
                    break;
                case 1:
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
        
        /*
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
        oos.writeObject(cliente);
        oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
		Cliente nico = (Cliente) ois.readObject();
		System.out.println(nico);
		ois.close();
        */  
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private static void menu(){
        System.out.println("---------------------------Menu---------------------------\n0 - sair\n1 - adicionar produto");
        System.out.print("Digite o numero correspondente a opcao que deseja >>> ");
    }
}
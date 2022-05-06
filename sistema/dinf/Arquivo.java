package sistema.dinf;

import java.io.*;
import java.util.Vector;
import java.util.Scanner;

import sistema.dinf.ListaCheckbox;
import sistema.dinf.ItemCheckbox;

public class Arquivo {

    public Arquivo() {
        //constructor
    }

    public void grava(ListaCheckbox lista){
        try {
            FileOutputStream arq = new FileOutputStream("pedido.dat");
            ObjectOutputStream out = new ObjectOutputStream(arq);
            int i;
            for (i=0; i < lista.tamanho(); i++) {
                if (lista.busca(i) == null) {
                	break;
                }
                out.writeObject(lista.busca(i));
                out.flush();
            }
            out.close();
        }
        catch (java.io.IOException exc) {
            System.out.println("Erro ao salvar arquivo.");
        }
    }

    public void le(ListaCheckbox lista, int n, File file) {
        try {
            FileInputStream arq = new FileInputStream("pedido.dat");
            ObjectInputStream in = new ObjectInputStream(arq);
            ItemCheckbox novo = new ItemCheckbox();
            int i;
            for (i=0; i < n; i++) {
                novo = (ItemCheckbox) in.readObject();
                lista.adiciona(novo);
                if (lista.busca(i) == null) {
                    break;
                }
            }
            in.close();
        }
        catch (java.io.EOFException eof) {
            System.out.println("Arquivo lido.");
        }
        catch (java.io.IOException exc2) {
            System.out.println("Erro ao ler arquivo.");
        }
        catch (ClassNotFoundException cnfex) {
            System.out.println("Classe nao encontrada.");
        }
    }
}

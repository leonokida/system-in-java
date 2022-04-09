import java.io.*;
import java.util.Vector;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaCursada;

public class Arquivo {

    public void Le_Disciplina_Cursada(DisciplinaCursada d){
        try{
            FileInputStream arq = new FileInputStream("exemplo_trabalho_TAP_historico.csv");
            ObjectInputStream in = new ObjectInputStream(arq);
            d = (DisciplinaCursada) in.readObject();
            //while(!a.getNome().equals(nome)){
            System.out.println(d.getCodigo());
            System.out.println(d.getNome());
            System.out.println(d.getCargaHoraria());
            System.out.println(d.descr_estrutura());
            //}
            in.close();
        }catch(java.io.IOException exc2){
            System.out.println("Erro ao Ler o arquivo");
        }catch(ClassNotFoundException cnfex){
            System.out.println("Não achou a Classe");
        }
    }
    
    public void Le_Disciplina_Disponivel(Disciplina disciplina){
        try{
            FileInputStream arq = new FileInputStream("exemplo_trabalho_TAP_Disciplinas_2019.csv");
            ObjectInputStream in = new ObjectInputStream(arq);
            disciplina = (Disciplina) in.readObject();
            while(!a.getNome().equals(nome)){
                System.out.println(a.getNome());
                System.out.println(a.getEndereco());
                System.out.println(a.getGRR());
            }
            in.close();
        }catch(java.io.IOException exc2){
            System.out.println("Erro ao Ler o arquivo");
        }catch(ClassNotFoundException cnfex){
            System.out.println("Não achou a Classe");
        }
    }
    
    /*public void grava(Vector alunos){
        try{
            FileOutputStream arq = new FileOutputStream("arq.dat");
            ObjectOutputStream out = new ObjectOutputStream(arq);
            out.writeObject();
            out.flush();
            out.close();
        }
        
        catch(java.io.IOException exc){
            System.out.println("Erro ao Gravar o arquivo");
        }
    }*/
}

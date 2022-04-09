import java.io.*;
import java.util.Vector;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaCursada;

public class Arquivo {

    public void Le_Disciplina_Cursada(DisciplinaCursada d){
        try{
            //generalizar nome do arquivo
            FileInputStream arq = new FileInputStream("exemplo_trabalho_TAP_historico.csv");
            ObjectInputStream in = new ObjectInputStream(arq);
            d = (DisciplinaCursada) in.readObject();
            
            //Fazer com que leia mais de uma disciplina
            //while(!d.getCodigo().equals(codigo)){
            System.out.println(d.getCodigo());
            System.out.println(d.getNome());
            System.out.println(d.getCargaHoraria());
            System.out.println(d.getDescr_estrutura());
            System.out.println(d.getSituacao());
            System.out.println(d.getSemestreCursado());
            //}
            in.close();
        }catch(java.io.IOException exc2){
            System.out.println("Erro ao Ler o arquivo");
        }catch(ClassNotFoundException cnfex){
            System.out.println("Não achou a Classe");
        }
    }
    
    public void Le_Disciplina_Disponivel(DisciplinaDisponivel d){
        try{
            //generalizar nome do arquivo
            FileInputStream arq = new FileInputStream("exemplo_trabalho_TAP_Disciplinas_2019.csv");
            ObjectInputStream in = new ObjectInputStream(arq);
            d = (DisciplinaDisponivel) in.readObject();

            //Fazer com que leia mais de uma disciplina
            //while(!a.getNome().equals(nome)){
                System.out.println(d.getCodigo());
                System.out.println(d.getNome());
                System.out.println(d.getCargaHoraria());
                System.out.println(d.getDescr_estrutura());
                System.out.println(d.getPeriodo());
            //}
            in.close();
        }catch(java.io.IOException exc2){
            System.out.println("Erro ao Ler o arquivo");
        }catch(ClassNotFoundException cnfex){
            System.out.println("Não achou a Classe");
        }
        //---------------------------------------TESTE
        /*System.out.println(d.getCodigo());
        System.out.println(d.getNome());
        System.out.println(d.getCargaHoraria());
        System.out.println(d.getDescr_estrutura());
        System.out.println(d.getPeriodo());*/
        //---------------------------------------TESTE
    }
    
    //IMPLEMENTAR GRAVACAO DOS DADOS PARA UM ARQUIVO CSV
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

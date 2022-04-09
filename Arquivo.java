import java.io.*;
import java.util.Vector;
import java.util.Scanner;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaCursada;

public class Arquivo {

    public void Le_Disciplina_Cursada(ListaCursadas lista, DisciplinaCursada d){
        //generalizar nome do arquivo
        File arquivo = new File("exemplo_trabalho_TAP_historico.csv");
        Scanner sc = new Scanner(arquivo);
        String line; //string que vai pegar a linha 
        int inicio; // posicao incial do atributo
        int fim; //posicao final do atributo

        while (sc.hasNext()) {
            //leio a linha
            line = sc.nextLine();
            
            //atributo "codigo"
            fim=line.indexOf(';');
            d.setCodigo(line.substring (0, fim));
            
            //proximo atributo "nome"
            inicio=fim+1;
            fim=line.indexOf(';');
            d.setNome(line.substring (inicio, fim));

            //proximo atributo "carga horaria"
            inicio=fim+1;
            fim=line.indexOf(';');
            d.setCargaHoraria(line.substring (inicio, fim));

            //proximo atributo "descr_estrutura"
            inicio=fim+1;
            fim=line.indexOf(';');
            d.setDescr_estrutura(line.substring (inicio, fim));

            //proximo atributo "situacao"
            inicio=fim+1;
            fim=line.indexOf(';');
            d.setSituacao(line.substring (inicio, fim));

            //proximo atributo "semestre cursado"
            inicio=fim+1;
            fim=line.indexOf(';');
            d.setSemestreCursado(line.substring (inicio, fim));
            
            lista.adiciona(d);

        }
        sc.close();
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

package sistema.dinf;

import java.io.*;
import java.util.Vector;
import java.util.Scanner;

import sistema.dinf.DisciplinaCursada;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.Disciplina;
import sistema.dinf.ListaDisponiveis;

public class ListaDisponiveisDAO {
    public ListaDisponiveisDAO() {
        //constructor
    }
    
    //arrumar
    /*
    public void leDisciplinaDisponivel(ListaDisponiveis lista) throws IOException{
        //generalizar nome do arquivo
        File arquivo = new File("exemplo_trabalho_TAP_Disciplinas_2019.csv");
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

            //proximo atributo "periodo"
            inicio=fim+1;
            fim=line.indexOf(';');
            d.setPeriodo(Integer.parseInt(line.substring (inicio, fim)));

            //proximo atributo "carga horaria"
            inicio=fim+1;
            fim=line.indexOf(';');
            d.setCargaHoraria(Integer.parseInt(line.substring (inicio, fim)));

        }
        sc.close();
        
    }
    */
    
    //IMPLEMENTAR GRAVACAO DOS DADOS PARA UM ARQUIVO DAT
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

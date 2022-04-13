package sistema.dinf;

import java.io.*;
import java.util.Vector;
import java.util.Scanner;

import sistema.dinf.DisciplinaCursada;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.Disciplina;
import sistema.dinf.ListaCursadas;

public class ListaCursadasDAO {
    public ListaCursadasDAO() {
        //constructor
    }

    public void leDisciplinaCursada (ListaCursadas lista) throws IOException {
        //generalizar nome do arquivo
        File arquivo = new File("exemplo_trabalho_TAP_historico.csv");
        Scanner sc = new Scanner(arquivo);
		String line = "";
        String elementos[] = new String[15];
        sc.nextLine();
        sc.nextLine();

        while (sc.hasNextLine()) {
            DisciplinaCursada d = new DisciplinaCursada();
            //le linha
            line = sc.nextLine();
            elementos = line.split(";");

            //atributo "codigo"
            d.setCodigo(elementos[10]);
            
            //proximo atributo "nome"
            d.setNome(elementos[11]);

            //proximo atributo "carga horaria"
            d.setCargaHoraria(Integer.parseInt(elementos[12]));

            //proximo atributo "descEstrutura"
            d.setDescEstrutura(elementos[13]);

            //proximo atributo "situacao"
            d.setSituacao(Integer.parseInt(elementos[7]));

            //proximo atributo "semestre cursado"
            d.setSemestreCursado(Integer.parseInt(elementos[8].substring(0,1)));
            
            lista.adiciona(d);
        }
        sc.close();
    }
    
    
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

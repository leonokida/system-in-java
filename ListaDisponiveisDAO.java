package sistema.dinf;

import java.io.*;
import java.util.Vector;
import java.util.Scanner;

import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaDisponiveis;

public class ListaDisponiveisDAO {
    public ListaDisponiveisDAO() {
        //constructor
    }
    
    //arrumar
    public void leDisciplinaDisponivel(ListaDisponiveis lista) throws IOException{
        //generalizar nome do arquivo
        File arquivo = new File("exemplo_trabalho_TAP_Disciplinas_2011.csv");
        Scanner sc = new Scanner(arquivo);
		String line = "";
        String elementos[] = new String[15];
        sc.nextLine();
        sc.nextLine();

        while (sc.hasNextLine()) {
            DisciplinaDisponivel d = new DisciplinaDisponivel();
            //le linha
            line = sc.nextLine();
            System.out.println(line);
            elementos = line.split(";");

            //atributo "codigo"
            d.setCodigo(elementos[3]);
            
            //proximo atributo "nome"
            d.setNome(elementos[5]);

            //proximo atributo "carga horaria"
            d.setCargaHoraria(Integer.parseInt(elementos[7]));

            //proximo atributo "descEstrutura"
            d.setDescEstrutura(elementos[2]);

            //proximo atributo "periodo"
            if (elementos[6].equals("")) {
                // Pode ser feito em qualquer período.
                d.setPeriodo(0);
            }
            else {
                d.setPeriodo(Integer.parseInt(elementos[6]));
            }
            
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

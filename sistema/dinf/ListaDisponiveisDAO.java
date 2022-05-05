/*package sistema.dinf;

import java.io.*;
import java.util.Vector;
import java.util.Scanner;

import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaDisponiveis;

public class ListaDisponiveisDAO {
    private static ListaDisponiveisDAO uniqueInstance;
    private ListaDisponiveisDAO() {
        //constructor
    }
    public static synchronized ListaDisponiveisDAO getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ListaDisponiveisDAO();
        }
        return uniqueInstance;
    }
    
    public void leDisciplinaDisponivel(ListaDisponiveis lista) throws IOException{
        File arquivo = new File("exemplo_trabalho_TAP_Disciplinas_2019.csv");
        Scanner sc = new Scanner(arquivo);
		String line = "";
        String elementos[] = new String[15];
        sc.nextLine();
        sc.nextLine();

        while (sc.hasNextLine()) {
            DisciplinaDisponivel d = new DisciplinaDisponivel();
            //le linha
            line = sc.nextLine();
            elementos = line.split(";");

            //atributo "codigo"
            d.setCodigo(elementos[3]);
            
            //proximo atributo "nome"
            d.setNome(elementos[5]);

            //proximo atributo "carga horaria"
            if (elementos[6].equals("")) {
                d.setCargaHoraria(0);
            }
            else {
                d.setCargaHoraria(Integer.parseInt(elementos[7]));
            }

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
}*/

package sistema.dinf;

import java.io.*;
import java.util.Vector;
import java.util.Locale;
import java.util.Scanner;

import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaDisponiveis;

public class ListaDisponiveisDAO {
    private static ListaDisponiveisDAO uniqueInstance;
    private ListaDisponiveisDAO() {
        //constructor
    }
    public static synchronized ListaDisponiveisDAO getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ListaDisponiveisDAO();
        }
        return uniqueInstance;
    }
    
    public void leDisciplinaDisponivel(ListaDisponiveis lista) throws IOException{
        File arquivo = new File("exemplo_trabalho_TAP_Disciplinas_2019.csv");
        Locale loc = new Locale("pt", "BR");
		Scanner sc = new Scanner(arquivo,"UTF-8");
		sc.useLocale(loc);
		String line = "";
        String elementos[] = new String[15];
        sc.nextLine();
        sc.nextLine();

        while (sc.hasNextLine()) {
            DisciplinaDisponivel d = new DisciplinaDisponivel();
            //le linha
            line = sc.nextLine();
            elementos = line.split(";");

            //atributo "codigo"
            d.setCodigo(elementos[3]);
            
            //proximo atributo "nome"
            d.setNome(elementos[5]);

            //proximo atributo "carga horaria"
            if (elementos[6].equals("")) {
                d.setCargaHoraria(0);
            }
            else {
                d.setCargaHoraria(Integer.parseInt(elementos[7]));
            }

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
}

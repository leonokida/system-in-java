import java.io.*;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaCursada;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaCursadas;
import sistema.dinf.ListaDisponiveis;
import sistema.dinf.ListaCursadasDAO;
import sistema.dinf.ListaDisponiveisDAO;


public class Debug {
	public static void main(String[] args) throws IOException{
		/*
		ListaCursadas listCursadas = new ListaCursadas();
		ListaCursadasDAO arqCursadas = new ListaCursadasDAO();

		listCursadas.imprime();
		arqCursadas.leDisciplinaCursada(listCursadas);

		listCursadas.imprime();
		*/
		ListaDisponiveis listDisp = ListaDisponiveis.getInstance();
		ListaDisponiveisDAO arqDisponiveis = ListaDisponiveisDAO.getInstance();

		listDisp.imprime();
		arqDisponiveis.leDisciplinaDisponivel(listDisp);

		listDisp.imprime();
	}
}
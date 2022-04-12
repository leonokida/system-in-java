import java.io.*;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaCursada;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaCursadas;
import sistema.dinf.ListaDisponiveis;

public class Debug {
	public static void main(String[] args) throws IOException{
		ListaCursadas 	listCursadas	= new ListaCursadas();
		Arquivo			arqCursadas		= new Arquivo();

		listCursadas.imprime();
		arqCursadas.leDisciplinaCursada(listCursadas);

		listCursadas.imprime();
	}
}
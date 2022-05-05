/*package sistema.dinf;

import java.io.*;
import java.util.Vector;
import java.util.Scanner;

import sistema.dinf.DisciplinaCursada;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.Disciplina;
import sistema.dinf.ListaCursadas;

public class ListaCursadasDAO {
	private static ListaCursadasDAO uniqueInstance;

	private ListaCursadasDAO() {
		// constructor
	}

	public static synchronized ListaCursadasDAO getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ListaCursadasDAO();
		}
		return uniqueInstance;
	}

	public void leDisciplinaCursada(ListaCursadas lista) throws IOException {
		// generalizar nome do arquivo
		File arquivo = new File("exemplo_trabalho_TAP_historico.csv");
		Scanner sc = new Scanner(arquivo);
		String line = "";
		String elementos[] = new String[15];
		sc.nextLine();
		sc.nextLine();

		while (sc.hasNextLine()) {
			DisciplinaCursada d = new DisciplinaCursada();
			// le linha
			line = sc.nextLine();
			elementos = line.split(";");

			// atributo "codigo"
			d.setCodigo(elementos[10]);

			// proximo atributo "nome"
			d.setNome(elementos[11]);

			// proximo atributo "carga horaria"
			d.setCargaHoraria(Integer.parseInt(elementos[12]));

			// proximo atributo "descEstrutura"
			d.setDescEstrutura(elementos[13]);

			// proximo atributo "situacao"
			d.setSituacao(Integer.parseInt(elementos[7]));

			// proximo atributo "semestre cursado"
			d.setSemestreCursado(Integer.parseInt(elementos[5]) * 10 + Integer.parseInt(elementos[8].substring(0, 1)));

			// proximo atributo "nota"
			d.setNota(Integer.parseInt(elementos[6]));

			lista.adiciona(d);
		}
		sc.close();
	}

	public String leNome() throws IOException {
		// generalizar nome do arquivo
		File arquivo = new File("exemplo_trabalho_TAP_historico.csv");
		Scanner sc = new Scanner(arquivo);
		String line = "";
		String elementos[] = new String[15];
		sc.nextLine();
		sc.nextLine();

		line = sc.nextLine();
		elementos = line.split(";");

		return elementos[1];

	}

	public String leGrr() throws IOException {
		// generalizar nome do arquivo
		File arquivo = new File("exemplo_trabalho_TAP_historico.csv");
		Scanner sc = new Scanner(arquivo);
		String line = "";
		String elementos[] = new String[15];
		sc.nextLine();
		sc.nextLine();

		line = sc.nextLine();
		elementos = line.split(";");

		return elementos[0];

	}

}*/
package sistema.dinf;

import java.io.*;
import java.util.Vector;
import java.util.Locale;
import java.util.Scanner;

import sistema.dinf.DisciplinaCursada;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.Disciplina;
import sistema.dinf.ListaCursadas;

public class ListaCursadasDAO {
	private static ListaCursadasDAO uniqueInstance;

	private ListaCursadasDAO() {
		// constructor
	}

	public static synchronized ListaCursadasDAO getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ListaCursadasDAO();
		}
		return uniqueInstance;
	}

	public void leDisciplinaCursada(ListaCursadas lista) throws IOException {
		// generalizar nome do arquivo
		File arquivo = new File("exemplo_trabalho_TAP_historico.csv");
		Locale loc = new Locale("pt", "BR");
		Scanner sc = new Scanner(arquivo,"UTF-8");
		sc.useLocale(loc);
		String line = "";
		String elementos[] = new String[15];
		sc.nextLine();
		sc.nextLine();

		while (sc.hasNextLine()) {
			DisciplinaCursada d = new DisciplinaCursada();
			// le linha
			line = sc.nextLine();
			elementos = line.split(";");

			// atributo "codigo"
			d.setCodigo(elementos[10]);

			// proximo atributo "nome"
			d.setNome(elementos[11]);

			// proximo atributo "carga horaria"
			d.setCargaHoraria(Integer.parseInt(elementos[12]));

			// proximo atributo "descEstrutura"
			d.setDescEstrutura(elementos[13]);

			// proximo atributo "situacao"
			d.setSituacao(Integer.parseInt(elementos[7]));

			// proximo atributo "semestre cursado"
			d.setSemestreCursado(Integer.parseInt(elementos[5]) * 10 + Integer.parseInt(elementos[8].substring(0, 1)));

			// proximo atributo "nota"
			d.setNota(Integer.parseInt(elementos[6]));

			lista.adiciona(d);
		}
		sc.close();
	}

	public String leNome() throws IOException {
		// generalizar nome do arquivo
		File arquivo = new File("exemplo_trabalho_TAP_historico.csv");
		Scanner sc = new Scanner(arquivo);
		String line = "";
		String elementos[] = new String[15];
		sc.nextLine();
		sc.nextLine();

		line = sc.nextLine();
		elementos = line.split(";");

		return elementos[1];

	}

	public String leGrr() throws IOException {
		// generalizar nome do arquivo
		File arquivo = new File("exemplo_trabalho_TAP_historico.csv");
		Scanner sc = new Scanner(arquivo);
		String line = "";
		String elementos[] = new String[15];
		sc.nextLine();
		sc.nextLine();

		line = sc.nextLine();
		elementos = line.split(";");

		return elementos[0];

	}

}


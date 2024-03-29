package sistema.dinf;

import java.lang.Integer;
import java.util.Collections;
import java.util.ArrayList;
import sistema.dinf.DisciplinaCursada;

public class ListaCursadas {

	private ArrayList<DisciplinaCursada> lista;
	private static ListaCursadas uniqueInstance;

	private ListaCursadas() {
		this.lista = new ArrayList<DisciplinaCursada>();
	}

	public static synchronized ListaCursadas getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ListaCursadas();
		}
		return uniqueInstance;
	}

	public int tamanho() {
		return this.lista.size();
	}

	public void adiciona(DisciplinaCursada disciplina) {
		this.lista.add(disciplina);
	}

	
	//Compara por semestre e por nome
	
	public void ordena() {
		this.lista.sort((o1, o2) -> {
			int cmp = Integer.valueOf(o1.getSemestreCursado()).compareTo(o2.getSemestreCursado());
			if (cmp != 0) {
				return cmp;
			}
			return o1.getNome().compareTo(o2.getNome());
		});
	}

	public DisciplinaCursada busca(int i) {
		return this.lista.get(i);
	}

	public void atualizaSemestres() {
		int i= 0;
		int j = 1;
		while (i < this.lista.size()) {
			int sem = this.lista.get(i).getSemestreCursado();
			while ((i < this.lista.size()) && (this.lista.get(i).getSemestreCursado() == sem)) {
				this.lista.get(i).setPeriodo(j);
				i++;
			}
			j++;
		}
	}

	public void imprime() {
		System.out.printf("%d\n", this.lista.size());
		for (int i = 0; i < this.lista.size(); i++) {
			System.out.printf("%s\n", this.lista.get(i).getCodigo());
			System.out.printf("%s\n", this.lista.get(i).getNome());
			System.out.printf("%s\n", this.lista.get(i).getDescEstrutura());
			System.out.printf("%s\n", this.lista.get(i).getCargaHoraria());
			System.out.printf("%s\n", this.lista.get(i).getSituacao());
			System.out.printf("%s\n", this.lista.get(i).getSemestreCursado());
			System.out.println();
		}
	}
}


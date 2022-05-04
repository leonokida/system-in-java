package sistema.dinf;

import java.lang.Integer;
import java.util.Collections;
import java.util.ArrayList;
import sistema.dinf.DisciplinaDisponivel;

public class ListaDisponiveis {

    private ArrayList<DisciplinaDisponivel> lista;
    private static ListaDisponiveis uniqueInstance;

    private ListaDisponiveis() {
        this.lista = new ArrayList<DisciplinaDisponivel>();
    }
    public static synchronized ListaDisponiveis getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ListaDisponiveis();
        }
        return uniqueInstance;
    }

    public int tamanho() {
        return this.lista.size();
    }

    public void adiciona(DisciplinaDisponivel disciplina) {
        this.lista.add(disciplina);
    }

    /*
    Compara por período recomendado e por nome
    */
    public void ordena() {
        this.lista.sort((o1, o2) -> {
            int cmp = Integer.valueOf(o1.getPeriodo()).compareTo(o2.getPeriodo());
            if (cmp != 0) {
                return cmp;
            }
            return o1.getNome().compareTo(o2.getNome());
        });
    }

    public DisciplinaDisponivel busca(int i) {
        return this.lista.get(i);
    }

    public void imprime(){
		System.out.printf("%d\n", this.lista.size());
		for (int i = 0 ; i < this.lista.size() ; i++){
			System.out.printf("%s\n", this.lista.get(i).getCodigo());
			System.out.printf("%s\n", this.lista.get(i).getNome());
			System.out.printf("%s\n", this.lista.get(i).getDescEstrutura());
			System.out.printf("%s\n", this.lista.get(i).getCargaHoraria());
			System.out.printf("%s\n", this.lista.get(i).getPeriodo());
			System.out.println();
		}
	}

}
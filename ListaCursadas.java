package sistema.dinf;

import java.lang.Integer;
import java.util.Collections;
import java.util.ArrayList;
import sistema.dinf.DisciplinaCursada;

public class ListaCursadas {

    private ArrayList<DisciplinaCursada> lista;

    public ListaCursadas() {
        this.lista = new ArrayList<DisciplinaCursada>();
    }

    public int tamanho() {
        return this.lista.size();
    }

    public void adiciona(DisciplinaCursada disciplina) {
        this.lista.add(disciplina);
    }

    /*
    Compara por semestre e por nome
    */
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

}
package sistema.dinf;

import java.util.ArrayList;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.DisciplinaCursada;
import sistema.dinf.ListaCursadas;
import sistema.dinf.ListaDisponiveis;

public class Tabela {
    private ArrayList<Disciplina> itens;
    private static Tabela uniqueInstance;

    private Tabela() {
        itens = new ArrayList<Disciplina>();
    }

    public static synchronized Tabela getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Tabela();
		}
		return uniqueInstance;
	}

    public void criaTabela(ListaCursadas listaCursadas, ListaDisponiveis listaDisponiveis) {
        int i;
        for (i=0; i < listaCursadas.tamanho(); i++) {
            if (listaCursadas.busca(i).getSituacao() == 1) {
                Disciplina novo = new Disciplina();
                novo.setNome(listaCursadas.busca(i).getNome());
                novo.setCargaHoraria(listaCursadas.busca(i).getCargaHoraria());
                novo.setCodigo(listaCursadas.busca(i).getCodigo());
                novo.setDescEstrutura(listaCursadas.busca(i).getDescEstrutura());
                novo.setPeriodo(listaCursadas.busca(i).getPeriodo());
                itens.add(novo);
            }
        }
        for (i=0; i < listaDisponiveis.tamanho(); i++) {
            Disciplina novo = new Disciplina();
            novo.setNome(listaDisponiveis.busca(i).getNome());
            novo.setCargaHoraria(listaDisponiveis.busca(i).getCargaHoraria());
            novo.setCodigo(listaDisponiveis.busca(i).getCodigo());
            novo.setDescEstrutura(listaDisponiveis.busca(i).getDescEstrutura());

            if ((itens.indexOf(novo) != -1) && (listaDisponiveis.busca(i).getPeriodo() <= 3)) {
                itens.add(novo);
            }
        }
        for (i=0; i < listaDisponiveis.tamanho(); i++) {
            Disciplina novo = new Disciplina();
            novo.setNome(listaDisponiveis.busca(i).getNome());
            novo.setCargaHoraria(listaDisponiveis.busca(i).getCargaHoraria());
            novo.setCodigo(listaDisponiveis.busca(i).getCodigo());
            novo.setDescEstrutura(listaDisponiveis.busca(i).getDescEstrutura());
            novo.setPeriodo(listaDisponiveis.busca(i).getPeriodo());

            if ((itens.indexOf(novo) != -1)) {
                listaDisponiveis.remover(listaDisponiveis.busca(i));
            }
        }
    }

    public int tamanho() {
    	return itens.size();
    }
    
    public Disciplina busca(int i) {
        return itens.get(i);
    }
}
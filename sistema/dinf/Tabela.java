package sistema.dinf;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.DisciplinaCursada;
import sistema.dinf.ListaCursadas;
import sistema.dinf.ListaDisponiveis;

public class Tabela {
    private ArrayList<Disciplina> itens;

    public Tabela() {
        itens = new ArrayList<Disciplina>();
    }

    public void criaTabela(ListaCursadas listaCursadas, ListaDisponiveis listaDisponiveis) {
        int i;
        for (i=0; i < listaCursadas.tamanho(); i++) {
            Disciplina novo = new Disciplina();
            novo.setNome(listaCursadas.busca(i).getNome());
            novo.setCargaHoraria(listaCursadas.busca(i).getCargaHoraria());
            novo.setCodigo(listaCursadas.busca(i).getCodigo());
            novo.setDescEstrutura(listaCursadas.busca(i).getDescEstrutura());
            itens.add(novo);
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
    }

    public int busca(int i) {
        return itens.get(i);
    }
}
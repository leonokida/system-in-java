package sistema.dinf;

import sistema.dinf.Disciplina;

public class DisciplinaCursada extends Disciplina {
    /* 1 = aprovado, 2 = reprovado por nota, 3 = reprovado por frequencia */
    public int situacao;
    public int semestreCursado;

    public DisciplinaCursada() {
        //constructor
    }
    public DisciplinaCursada(String codigo, String nome, String descr_estrutura, int cargaHoraria, int situacao, int semestreCursado) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCargaHoraria(cargaHoraria);
		this.setDescr_estrutura(descr_estrutura);
        this.situacao = situacao;
        this.semestreCursado = semestreCursado;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    public int getSituacao() {
        return this.situacao;
    }

    public void setSemestreCursado(int semestreCursado) {
        this.semestreCursado = semestreCursado;
    }
    public int getSemestreCursado() {
        return this.semestreCursado;
    }
}
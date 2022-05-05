package sistema.dinf;

import sistema.dinf.Disciplina;

public class DisciplinaCursada extends Disciplina {
    /* 1 = aprovado, 2 = reprovado por nota, 3 = reprovado por frequencia */
    private int situacao;
    private int semestreCursado;
    private int nota;

    public DisciplinaCursada() {
        //constructor
    }
    public DisciplinaCursada(String codigo, String nome, String descEstrutura, int cargaHoraria, int situacao, int semestreCursado, int nota) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCargaHoraria(cargaHoraria);
		this.setDescEstrutura(descEstrutura);
        this.situacao = situacao;
        this.semestreCursado = semestreCursado;
        this.nota = nota;
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

    public void setNota(int nota) {
        this.nota = nota;
    }
    public int getNota() {
        return this.nota;
    }
}
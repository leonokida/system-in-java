package sistema.dinf;

import java.io.Serializable;
import sistema.dinf.Disciplina;

public class DisciplinaDisponivel extends Disciplina implements Serializable {
    private int periodo;

    public DisciplinaDisponivel() {
        //constructors
    }
    public DisciplinaDisponivel(String codigo, String nome, String descEstrutura, int cargaHoraria , int periodo) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCargaHoraria(cargaHoraria);
        this.setDescEstrutura(descEstrutura);
        this.periodo = periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    public int getPeriodo() {
        return this.periodo;
    }
}
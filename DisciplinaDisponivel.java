package sistema.dinf;

import java.io.Serializable;
import sistema.dinf.Disciplina;

public class DisciplinaDisponivel extends Disciplina implements Serializable {

    public DisciplinaDisponivel() {
        //constructors
    }
    public DisciplinaDisponivel(String codigo, String nome, String descEstrutura, int cargaHoraria) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCargaHoraria(cargaHoraria);
        this.setDescEstrutura(descEstrutura);
    }
}
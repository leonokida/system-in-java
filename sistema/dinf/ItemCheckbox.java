package sistema.dinf;

import java.io.Serializable;
import sistema.dinf.DisciplinaDisponivel;

public class ItemCheckbox implements Serializable {
    private boolean marcado;
    private DisciplinaDisponivel disciplina;

    public ItemCheckbox() {
        //constructors
    }
    public ItemCheckbox(boolean marcado, DisciplinaDisponivel disciplina) {
        this.marcado = marcado;
        this.disciplina = disciplina;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }
    public boolean getMarcado() {
        return this.marcado;
    }

    public void setDisciplina(DisciplinaDisponivel disciplina) {
        this.disciplina = disciplina;
    }
    public DisciplinaDisponivel getDisciplina() {
        return this.disciplina;
    }
}
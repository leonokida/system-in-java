package sistema.dinf;

import java.io.Serializable;

public class Disciplina implements Serializable {
    private String codigo;
    private String nome;
    private int cargaHoraria;

    public Disciplina() {
        //constructor
    }
    public Disciplina(String codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return this.codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }
}
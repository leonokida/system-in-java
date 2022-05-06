package sistema.dinf;

import java.io.Serializable;

public class Disciplina implements Serializable {
    private String codigo;
    private String nome;
    private String descEstrutura; //optativa ou obrigatoria
    private int cargaHoraria;
    private int periodo;

    public Disciplina() {
        //constructor
    }
    public Disciplina(String codigo, String nome, String descEstrutura, int cargaHoraria, int periodo) {
        this.codigo = codigo;
        this.nome = nome;
        this.descEstrutura = descEstrutura;
        this.cargaHoraria = cargaHoraria;
        this.periodo = periodo;
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
    
    public void setDescEstrutura(String descEstrutura) {
        this.descEstrutura = descEstrutura;
    }

    public String getDescEstrutura() {
        return this.descEstrutura;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    public int getPeriodo() {
        return this.periodo;
    }
}
package sistema.dinf;

import java.io.*;
import java.util.*;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaCursada;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaCursadas;
import sistema.dinf.ListaDisponiveis;


public class ControladorAluno {

    private ListaCursadas cursadas;
    private ListaDisponiveis disponiveis;
    private float ira;
    private float desempenho;
    private int semestreAtual;
    private String nome;
    private int grr;
    private int quantMatriculas;

    public ControladorAluno(){

    }

    public ControladorAluno(float ira, int semestreAtual, String nome, int grr){
        this.cursadas = ListaCursadas.getInstance();
        this.disponiveis = ListaDisponiveis.getInstance();
        this.ira = ira;
        this.semestreAtual = semestreAtual;
        this.grr = grr;
        this.nome = nome;
        this.desempenho = this.calculaDesempenho();
        this.quantMatriculas = this.cursadas.disciplinasPorSemestre(this.semestreAtual).size();
    }

    public void setIRA(float ira){
        this.ira = ira;
    }

    public float getIRA(){
        return this.ira;
    }

    public void setSemestreAtual(int semestreAtual){
        this.semestreAtual = semestreAtual;
        this.desempenho = this.calculaDesempenho();
    }

    public int getSemestreAtual(){
        return this.semestreAtual;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setGRR(int grr){
        this.grr = grr;
    }

    public int getGRR(){
        return this.grr;
    }
    
    public int getQuantMatriculas(){
        return this.quantMatriculas;
    }

    public float calculaDesempenho(){
        int semestreAnterior;
        if (this.semestreAtual % 2 == 0)
            semestreAnterior = this.semestreAtual - 1;
        else
            semestreAnterior = this.semestreAtual - 9;
        ArrayList<DisciplinaCursada> listaDisciplinas = this.cursadas.disciplinasPorSemestre(semestreAnterior);
        float aprovacoes = 0;

		for(DisciplinaCursada disciplina : listaDisciplinas){
			if(disciplina.getSituacao() == 1) aprovacoes++;
		}

        // for(int i = 0; i < listaDisciplinas.size(); i++){
            // if(listaDisciplinas.elementAt(i).getSituacao() == 1)
                // aprovacoes++;
        // }
        return aprovacoes/listaDisciplinas.size();
    }
    
    public int calculaDisponibilidade(){
        this.desempenho = this.calculaDesempenho();
        if(this.desempenho >= 2/3)
            return 5;
        if(this.desempenho >= 1/2)
            return 4;
        return 3;
    }

}

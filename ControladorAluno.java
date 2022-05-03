import java.io.*;

import sistema.dinf.Disciplina;
import sistema.dinf.DisciplinaCursada;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaCursadas;
import sistema.dinf.ListaDisponiveis;
import sistema.dinf.ListaCursadasDAO;
import sistema.dinf.ListaDisponiveisDAO;


public class ControladorAluno {

    private ListaCursadas cursadas;
    private ListaDisponiveis disponiveis;
    private float ira;
    private float desempenho;
    private int semestreAtual;
    private String nome;
    private int grr;

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

    public float calculaDesempenho(){
        
    }

}
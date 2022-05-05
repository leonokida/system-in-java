package sistema.dinf;

import java.io.*;
import java.util.*;

import sistema.dinf.ListaCursadas;
import sistema.dinf.ListaDisponiveis;
import sistema.dinf.ListaCheckbox;
import sistema.dinf.ListaDisponiveisDAO;
import sistema.dinf.ListaCursadasDAO;
import sistema.dinf.Arquivo;


public class ControladorAluno {

    private ListaCursadas listaCursadas;
    private ListaDisponiveis listaDisponiveis;
    public ListaCheckbox listaCheckbox;
    public Tabela tabela;
    private String nome;
    private String grr;
    private float ira;
    private float aprovacao;

    public ControladorAluno(){
        listaCursadas = ListaCursadas.getInstance();
        listaDisponiveis = ListaDisponiveis.getInstance();
        listaCheckbox = new ListaCheckbox();
        tabela = Tabela.getInstance();
    }

    public void geraListas() throws IOException {
        // Gera lista de disciplinas cursadas
        ListaCursadasDAO leCursadas = ListaCursadasDAO.getInstance();
        String nomeLido = "", grrLido = "";
        leCursadas.leDisciplinaCursada(listaCursadas);
        this.nome = leCursadas.leNome();
        this.grr = leCursadas.leGrr();
        listaCursadas.ordena();
		listaCursadas.atualizaSemestres();

        // Gera lista de disciplinas disponíveis
        ListaDisponiveisDAO leDisponiveis = ListaDisponiveisDAO.getInstance();
        leDisponiveis.leDisciplinaDisponivel(listaDisponiveis);

        // Gera tabela
        tabela.criaTabela(listaCursadas, listaDisponiveis);

        // Gera lista para checkbox
        listaCheckbox.criaLista(listaDisponiveis);
    }

    public String getNome() {
        return this.nome;
    }

    public String getGrr() {
        return this.grr;
    }

    public Tabela getTabela() {
        return this.tabela;
    }

    public ListaCheckbox getListaCheckbox() {
        return this.listaCheckbox;
    }
    public void setListaCheckbox(ListaCheckbox listaCheckbox) {
        this.listaCheckbox = listaCheckbox;
		
    }

    public void escreve() throws IOException {
        FileWriter fileWriter = new FileWriter("pedido.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("Pedido de %s de matrícula %s:\n", this.nome, this.grr);
        int i;
        for (i = 0; i < listaCheckbox.tamanho(); i++) {
            if (listaCheckbox.busca(i).getMarcado()) {
                printWriter.printf("%s %s\n", listaCheckbox.busca(i).getDisciplina().getNome(), listaCheckbox.busca(i).getDisciplina().getCodigo());
            }
        }
        printWriter.close();

        Arquivo arq = new Arquivo();
        arq.grava(listaCheckbox);
    }

    public float calculaIra() {
        float somaNotaCarga = 0;
        float somaCarga = 0;

        for (int i = 0; i < listaCursadas.tamanho(); i++) {
            somaNotaCarga = somaNotaCarga + (listaCursadas.busca(i).getNota() * listaCursadas.busca(i).getCargaHoraria());
            somaCarga = somaCarga + listaCursadas.busca(i).getCargaHoraria();
        }

        this.ira = somaNotaCarga / (somaCarga*100);
        return this.ira;
    }

    public float dadosAprovacao() {
        int sem = listaCursadas.busca(listaCursadas.tamanho()-1).getSemestreCursado();
        float soma = 0;
        int i = listaCursadas.tamanho()-1;
        int cont = 0;
        while ((i >= 0) && (listaCursadas.busca(i).getSemestreCursado() == sem)) {
            if (listaCursadas.busca(i).getSituacao() == 1) {
                soma++;
            }
            cont++;
            i--;
        }
        this.aprovacao = soma / cont;
        return this.aprovacao;
    }

    public int qtdReprovacoesFalta() {
        int soma = 0;
        int i = listaCursadas.tamanho()-1;
        while (i >= 0) {
            if (listaCursadas.busca(i).getSituacao() == 3) {
                soma++;
            }
            i--;
        }
        return soma;
    }

    public int numMatriculasRecomendado() {
        if (this.aprovacao > 2/3)
            return 5;
        else if (this.aprovacao >= 1/2)
            return 4;
        else
            return 3;
    }

}

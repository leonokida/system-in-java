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
    private ListaCheckbox listaCheckbox;
    private Tabela tabela;
    private String nome;
    private String grr;
    private float ira;

    public ControladorAluno(){
        listaCursadas = ListaCursadas.getInstance();
        listaDisponiveis = ListaDisponiveis.getInstance();
        listaCheckbox = ListaCheckbox.getInstance();
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

}

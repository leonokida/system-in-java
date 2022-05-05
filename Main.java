import java.io.*;

import sistema.dinf.*;

import sistema.dinf.ControladorAluno;
import sistema.dinf.UI01;
import sistema.dinf.UI02;

public class Main{
	public static void main(String args[]) throws IOException{	

		// cria controlador
		ControladorAluno aluno = new ControladorAluno();
		aluno.geraListas();

		// calcula dados de aprovação do último semestre
		float aprovacao = aluno.dadosAprovacao();

		// calcula reprovações por falta
		int reprovacaoFalta = aluno.qtdReprovacoesFalta();

		// calcula número de matrículas recomendado
		int numMatriculas = aluno.numMatriculasRecomendado();

		// para usar tabela
		// aluno.getTabela()

		// para usar checkbox
		ListaCheckbox checknovo = new ListaCheckbox();
		checknovo = aluno.getListaCheckbox();

		UI01 janela1 = new UI01();
		janela1.setVisible(true);

		UI02 janela2 = UI02.getInstance();
		janela2.adicionaText("Segure CTRL para selecionar várias matérias :)");
		janela2.adicionaTabela(checknovo);
		janela2.adicionaBotoes();

		// marcando/desmarcando item i
		// checknovo.busca(i).setMarcado(!checknovo.busca(i).getMarcado());
		// atualizando
		// aluno.setListaCheckbox(checknovo);

		// escreve no txt e no arquivo .dat objeto
		// aluno.escreve();

		// para importar
		// int tam = aluno.getListaCheckbox().esvaziaLista();
		// Arquivo arq = new Arquivo();
		// arq.le(aluno.getListaCheckbox(), tam);

		//UI02 janela2 = new UI02();
		//janela2.setVisible(true);
	}
}
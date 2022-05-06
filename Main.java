import java.io.*;
import java.awt.*;

import sistema.dinf.*;

import sistema.dinf.ControladorAluno;
import sistema.dinf.UI01;
import sistema.dinf.UI02;

public class Main{
	public static void main(String args[]) throws IOException {	

		// cria controlador
		ControladorAluno aluno = ControladorAluno.getInstance();
		aluno.geraListas();

		// calcula dados de aprovaÃ§Ã£o do Ãºltimo semestre
		float aprovacao = aluno.dadosAprovacao();

		// calcula reprovaÃ§Ãµes por falta
		int reprovacaoFalta = aluno.qtdReprovacoesFalta();

		// calcula nÃºmero de matrÃ­culas recomendado
		int numMatriculas = aluno.numMatriculasRecomendado();

		// para usar checkbox
		ListaCheckbox checknovo = new ListaCheckbox();
		checknovo = aluno.getListaCheckbox();
		
		Tabela cursadasnovo = Tabela.getInstance();

		UI01 janela1 = new UI01();
		janela1.setVisible(true);

		UI02 janela2 = UI02.getInstance();
		
		janela2.adicionaText("Taxa de aprovação: "+aprovacao+"   Reprovações por falta: "+reprovacaoFalta+"   Número de Matrículas Recomendado: "+numMatriculas);
		janela2.adicionaRigid(new Dimension(500,10));
		janela2.adicionaTabelaCursadas(cursadasnovo);
		janela2.adicionaRigid(new Dimension(500,10));
		janela2.adicionaText("Segure CTRL para selecionar várias matérias :)");
		janela2.adicionaTabelaDisponiveis(checknovo);
		janela2.adicionaBotoes();
		
	}
}
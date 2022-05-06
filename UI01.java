package sistema.dinf;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UI01 extends JFrame implements ActionListener {
	private JButton botao_entrar, botao_sair;

	public UI01 (){
		this.getContentPane().add(Box.createRigidArea(new Dimension(800,100)));
		//faz um espaço de 800 x 100 (o que importa é a altura: 100)

		JLabel texto = new JLabel("SIGA TAP");
		texto.setFont(new Font("Dialog",Font.BOLD, 60));
		texto.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(texto);
		
		//adiciona o texto SIGA TAP

		botao_entrar	= new JButton("Entrar");
		botao_sair		= new JButton("Sair");

		botao_entrar.addActionListener(this);
		botao_sair.addActionListener(this);

		Dimension dimensao_botao = new Dimension(200, 100);

		botao_entrar.setPreferredSize(dimensao_botao);
		botao_entrar.setMinimumSize(dimensao_botao);
		botao_entrar.setMaximumSize(dimensao_botao);
		botao_entrar.setAlignmentX(Component.CENTER_ALIGNMENT);

		botao_sair.setPreferredSize(dimensao_botao);
		botao_sair.setMinimumSize(dimensao_botao);
		botao_sair.setMaximumSize(dimensao_botao);
		botao_sair.setAlignmentX(Component.CENTER_ALIGNMENT);

		//cria dois botões com tamanho 200 x 100: o de entrar e o de sair

		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		//usa o layout box na vertical

		this.getContentPane().add(Box.createRigidArea(new Dimension(800,40)));
		this.getContentPane().add(botao_entrar);
		this.getContentPane().add(Box.createRigidArea(new Dimension(800,50)));
		this.getContentPane().add(botao_sair);
		//adiciona os botões com uns espacinhos

		this.setLocation(200,10);
		this.setSize(800,600);
		//seta o tamanho e o lugar q a tela começa
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == botao_entrar){
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
	        File file = chooser.getSelectedFile();

			//seleciona o arquivo e guarda em "file"
			
			ControladorAluno aluno = ControladorAluno.getInstance();
			try {
				aluno.geraListas(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//gera as listas baseado em "file"
			
			//muda de tela
			this.setVisible(false);

			Tabela cursadasnovo = Tabela.getInstance();
			
			float aprovacao = aluno.dadosAprovacao();
			int reprovacaoFalta = aluno.qtdReprovacoesFalta();
			int numMatriculas = aluno.numMatriculasRecomendado();
			//calculou os dados que serão mostrados no topo da tela
			
			ListaCheckbox checknovo = new ListaCheckbox();
			checknovo = aluno.getListaCheckbox();
			//gera a lista de materias disponiveis com checkbox
			
			UI02 janela2 = UI02.getInstance();
			//cria a segunda tela
			
			janela2.adicionaText("Taxa de aprovação: "+aprovacao+"   Reprovações por falta: "+reprovacaoFalta+"   Número de Matrículas Recomendado: "+numMatriculas);
			janela2.adicionaRigid(new Dimension(500,10));
			//adiciona as info do topo da tela
			janela2.adicionaTabelaCursadas(cursadasnovo);
			janela2.adicionaRigid(new Dimension(500,10));
			//poe a tabela de matérias já cursadas
			janela2.adicionaText("Segure CTRL para selecionar várias matérias :)");
			janela2.adicionaTabelaDisponiveis(checknovo);
			//poe a tela de matérias disponiveis com o avisinho em cima
			janela2.adicionaBotoes();
			janela2.setVisible(true);
			//adiciona os botoes e mostra a tela
		}
		if (e.getSource() == botao_sair){
			System.exit(0);
			//fecha o programa
		}
	}
}
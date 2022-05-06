package sistema.dinf;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class UI02 extends JFrame implements ActionListener {
	private ListaCheckbox lista_materias;

	private static UI02 uniqueInstance;

	private JButton botao_sair;
	private JButton botao_importar;

	private JTable tabela_disponiveis;
	private JTable tabela_cursadas;

	//o get size vai ser as colunas
	//as linhas vai ser 6 se n tiver optativas
	
	private UI02 (){
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.setLocation(200,10);
		this.setSize(800,700);
		//usa o layout box, define o tamanho e local de inicio da tabela
	}

	public static synchronized UI02 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new UI02();
		}
		return uniqueInstance;
	}

	//funcao que adiciona espacinhos
	public void adicionaRigid (Dimension dimensao){
		this.getContentPane().add(Box.createRigidArea(dimensao));
	}
	
	//funcao que adiciona textinhos
	public void adicionaText (String string){
		JLabel texto = new JLabel(string);
		texto.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(texto);
	}

	//funcao que adiciona os botoes da tela 2
	public void adicionaBotoes(){
		JButton botao_importar	= new JButton("Importar");
		JButton botao_sair 		= new JButton("Salvar e Pedir");

		botao_importar.addActionListener(this);
		botao_importar.setSize(new Dimension(500,50));
		botao_importar.setMinimumSize(new Dimension(500,50));
		botao_importar.setMaximumSize(new Dimension(500,50));
		botao_importar.setAlignmentX(CENTER_ALIGNMENT);

		botao_sair.addActionListener(this);
		botao_sair.setSize(new Dimension(500,50));
		botao_sair.setMinimumSize(new Dimension(500,50));
		botao_sair.setMaximumSize(new Dimension(500,50));
		botao_sair.setAlignmentX(CENTER_ALIGNMENT);

		this.botao_importar = botao_importar;
		this.botao_sair = botao_sair;

		this.getContentPane().add(botao_importar);

		this.adicionaRigid (new Dimension(500,10));

		this.getContentPane().add(botao_sair);
		//adicionou dois botoes com um espacinho entre eles
	}

	//funcao que coloca a tabela de disciplinas cursadas
	public void adicionaTabelaCursadas (Tabela lista) {
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() { 
				return (2);
			}
			//a tabela tem duas colunas

			public int getRowCount() {
				Tabela tabela = Tabela.getInstance();
				return tabela.tamanho();
			}
			//o tanto de linhas sao a quantia de materias
			
			public String getColumnName (int column) {
				if (column == 0) {
					return ("Nome");
				}
				else
					return ("Período");
					//1 coluna, nome, 2, periodo
			}
			

			public Object getValueAt(int row, int col) { 
				if (col == 0) {
					Tabela tabela = Tabela.getInstance();
					return (tabela.busca(row).getNome());
				}
				else {
					Tabela tabela = Tabela.getInstance();
					
					if (tabela.busca(row).getPeriodo() > 0) {
						Object objeto = (Integer) tabela.busca(row).getPeriodo();
						return (objeto);
					}
					else
						return ("Sem Período");
				}
				//1 coluna, nome, 2, periodo
			}
		};

		JTable table = new JTable(dataModel);
		
		this.tabela_disponiveis = table;

		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setSize(new Dimension(700,150));
		scrollpane.setMinimumSize(new Dimension(700,150));
		scrollpane.setMaximumSize(new Dimension(700,150));
		scrollpane.setAlignmentX(CENTER_ALIGNMENT);
		//cria a tabela

		this.getContentPane().add(scrollpane);
	}
	
	//funcao que coloca a tabela de disciplinas disponiveis
	public void adicionaTabelaDisponiveis(ListaCheckbox lista){
		this.setListaCheckboxDisponiveis(lista);

		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() { 
				return (2);
			}
			//a tabela tem duas colunas

			public int getRowCount() {
				return lista_materias.tamanho();
			}
			//o tanto de linhas sao a quantidade de materias

			public String getColumnName (int column) {
				if (column == 0) {
					return ("Nome");
				}
				else
					return ("Período");
				//1 coluna, nome, 2, periodo
			}
			
			public Object getValueAt(int row, int col) { 
				if (col == 0)
					return (lista_materias.busca(row).getDisciplina().getNome());
				else {
					if (lista_materias.busca(row).getDisciplina().getPeriodo() > 0) {
						Object objeto = (Integer) lista_materias.busca(row).getDisciplina().getPeriodo();
						return (objeto);
					}
					else
						return ("Sem Período");
				}
				//1 coluna, nome, 2, periodo
			}
			//retorna o nome de cada matÃ©ria
		};

		JTable table = new JTable(dataModel);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		this.tabela_disponiveis = table;

		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setSize(new Dimension(700,200));
		scrollpane.setMinimumSize(new Dimension(700,200));
		scrollpane.setMaximumSize(new Dimension(700,200));
		scrollpane.setAlignmentX(CENTER_ALIGNMENT);
		//adiciona a tabela

		this.getContentPane().add(scrollpane);
	}

	//pega a lista de checkbox
	public void setListaCheckboxDisponiveis (ListaCheckbox lista){
		this.lista_materias = lista;
		return;
	}

	//pega os indices das matérias q foram checadas
	public int getChecados (int[] vetor){
		int i_vetor = 0;
		for (int i = 0 ; i < lista_materias.tamanho() ; i++){
			if (lista_materias.busca(i).getMarcado() == true){
				vetor[i_vetor] = i;
				i_vetor++;
			}
		}

		return i_vetor;
	}

	//adiciona as linhas q devem ser selecionadas
	public void setChecados (int[] vetor, int tam){
		this.tabela_disponiveis.removeRowSelectionInterval(0,this.tabela_disponiveis.getRowCount()-1);
		
		for (int i = 0 ; i < tam ; i++){
			this.tabela_disponiveis.addRowSelectionInterval(vetor[i], vetor[i]);
		}
	}
	
	//pega uma lista de matérias com checkbox e seleciona as q o usuário selecionou
	public void selecionaLista (int[] vetor, int tam) {
		for (int i = 0 ; i < this.lista_materias.tamanho() ; i++)
			this.lista_materias.busca(i).setMarcado(false);
		
		for (int i = 0 ; i < tam ; i++)
			this.lista_materias.busca(vetor[i]).setMarcado(true);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == this.botao_sair){
			this.setVisible(false);

			int vetor[] = new int[tabela_disponiveis.getSelectedRowCount()];
			vetor = tabela_disponiveis.getSelectedRows();
			//pega os indices das as materias selecionadas na tabela

			selecionaLista (vetor, tabela_disponiveis.getSelectedRowCount());
			//seleciona na lista os q foram selecionados
			
			ControladorAluno control = ControladorAluno.getInstance();
			
			try {
				control.escreve();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			UI03 janela3 = UI03.getInstance();
			janela3.setVisible(true);
			//chama a terceira tela
		}
		if (e.getSource() == this.botao_importar){
			JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos DAT", "dat");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
	        File file = chooser.getSelectedFile();

			int tam = lista_materias.esvaziaLista();
			Arquivo arq = new Arquivo();
			arq.le(this.lista_materias, tam, file);

			int vetor[] = new int[tam];
			int tam_checados = getChecados (vetor);

			setChecados(vetor, tam_checados);
		}
	}
}

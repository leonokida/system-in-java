package sistema.dinf;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class UI02 extends JFrame implements ActionListener {
	private ListaCheckbox lista_materias;

	private static UI02 uniqueInstance;

	private JButton botao_sair;
	private JButton botao_importar;

	//o get size vai ser as colunas
	//as linhas vai ser 6 se n tiver optativas

	public UI02 (){
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.setLocation(200,200);
		this.setSize(800,600);
	}

	public void adicionaRigid (Dimension dimensao){
		this.getContentPane().add(Box.createRigidArea(dimensao));
	}

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

		this.adicionaRigid (new Dimension(500,20));

		this.getContentPane().add(botao_sair);
	}

	public void adicionaText (String string){
		JLabel texto = new JLabel(string);
		texto.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(texto);
	}

	public void adicionaTabela(ListaCheckbox lista){
		this.setListaCheckboxDisponiveis(lista);

		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() { 
				return (1);
			}
			//a tabela só tem uma coluna

			public int getRowCount() {
				return lista_materias.tamanho();
			}
			//o tanto de linhas é o tanto de matérias q tem na lista

			public Object getValueAt(int row, int col) { 
				return (lista_materias.busca(row).getDisciplina().getNome());
			}
			//retorna o nome de cada matéria
		};

		JTable table = new JTable(dataModel);

		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setSize(new Dimension(700,300));
		scrollpane.setMinimumSize(new Dimension(700,300));
		scrollpane.setMaximumSize(new Dimension(700,300));
		scrollpane.setAlignmentX(CENTER_ALIGNMENT);

		this.getContentPane().add(scrollpane);

	}

	public static synchronized UI02 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new UI02();
		}
		return uniqueInstance;
	}

	public void setListaCheckboxDisponiveis (ListaCheckbox lista){
		this.lista_materias = lista;
		return;
	}

	public void getChecados (){

	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == this.botao_sair){
			this.setVisible(false);

			//aqui usa a função getSelectedRows pra retornar um vetor de indices das linhas selecionadas, e usa isso pra ver se da pra pedir a materia

			//UI03 janela3 = UI03.getInstance();
			//janela3.setVisible(true);
		}
		if (e.getSource() == this.botao_importar){
			int tam = lista_materias.esvaziaLista();
			Arquivo arq = new Arquivo();
			arq.le(this.lista_materias, tam);

			int vetor[] = new int[tam];

			
		}
	}
}

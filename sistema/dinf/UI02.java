package sistema.dinf;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class UI02 extends JFrame implements ActionListener {
	ListaDisponiveis lista_materias = ListaDisponiveis.getInstance();

	//o get size vai ser as colunas
	//as linhas vai ser 6 se n tiver optativas

	public UI02 (){
		TableModel dataModel = new AbstractTableModel() {
		public int getColumnCount() { return (lista_materias.busca(lista_materias.tamanho()-1)).getPeriodo() + 1;}
		public int getRowCount() { return 1;/*return 6;*/}
			public Object getValueAt(int row, int col) { 
				int indice_col = 0;
				while ((col != lista_materias.busca(indice_col).getPeriodo()) && (indice_col < lista_materias.tamanho()))
					indice_col++;

				if (indice_col == lista_materias.tamanho())	
					return null;	
			
				int indice_lin = 0;
				while ((indice_lin < row) && (indice_col + indice_lin) < lista_materias.tamanho())
					indice_lin++;

				if (indice_col+indice_lin == lista_materias.tamanho())	
					return null;

				return (lista_materias.busca(indice_col+indice_lin).getNome());
			}
		};

		JTable table = new JTable(dataModel);
		JScrollPane scrollpane = new JScrollPane(table);

		this.getContentPane().add(scrollpane);
		this.setLocation(200,200);
		this.setSize(800,600);
	}

	public void actionPerformed(ActionEvent e){

	}
}

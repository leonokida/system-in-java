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
			public int getColumnCount() { return (
				lista_materias.busca((lista_materias.tamanho() - 1)).getPeriodo() - lista_materias.busca(0).getPeriodo() + 1
				);}		//pega a diferença de periodo das matérias e usa como tamanho de colunas

			public int getRowCount() { return 1;/*return 6;*/}

			public Object getValueAt(int row, int col) { 
				//indice_col é o tanto de matéria até chegar na coluna que quer, indice_lin é o restinho até chegar na linha

				int indice_col = 0;
				while ((indice_col < lista_materias.tamanho()) && (col != (lista_materias.busca(indice_col).getPeriodo() - lista_materias.busca(0).getPeriodo())))
					indice_col++;

				if (indice_col >= lista_materias.tamanho())	
					return (" ");	
		
				int indice_lin = 0;
				while ( ((indice_col + indice_lin) < lista_materias.tamanho()) && (indice_lin < row))
					indice_lin++;
				if (indice_col+indice_lin >= lista_materias.tamanho())	
					return (" ");
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

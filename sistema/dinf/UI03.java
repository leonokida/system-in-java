package sistema.dinf;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class UI03 extends JFrame implements ActionListener {

	private static UI03 uniqueInstance;
	private JButton botao_sair;
	//o get size vai ser as colunas
	//as linhas vai ser 6 se n tiver optativas

	public UI03 (){
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		this.getContentPane().add(Box.createRigidArea(new Dimension(700,250)));
		//usa o layout box
		
		JLabel texto = new JLabel("Seu pedido foi gerado com sucesso :)");
		texto.setAlignmentX(CENTER_ALIGNMENT);
		this.getContentPane().add(texto);
		this.getContentPane().add(Box.createRigidArea(new Dimension(700,20)));
		//adiciona o texto e um espacinho
		
		JButton botao_sair	= new JButton("Sair");
		botao_sair.addActionListener(this);
		botao_sair.setSize(new Dimension(500,50));
		botao_sair.setMinimumSize(new Dimension(500,50));
		botao_sair.setMaximumSize(new Dimension(500,50));
		botao_sair.setAlignmentX(CENTER_ALIGNMENT);
		//adiciona o botao
		
		this.getContentPane().add(botao_sair);
		this.botao_sair = botao_sair;
		
		this.setLocation(200,10);
		this.setSize(800,700);
	}

	public static synchronized UI03 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new UI03();
		}
		return uniqueInstance;
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == this.botao_sair){
			System.exit(0);
			//fecha o programa
		}
	}
}

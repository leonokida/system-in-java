package sistema.dinf;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI01 extends JFrame implements ActionListener {
	private JButton botao_entrar, botao_sair;

	public UI01 (){
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

		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));

		this.getContentPane().add(Box.createRigidArea(new Dimension(800,140)));
		this.getContentPane().add(botao_entrar);
		this.getContentPane().add(Box.createRigidArea(new Dimension(800,50)));
		this.getContentPane().add(botao_sair);

		this.setLocation(200,200);
		this.setSize(800,600);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getSource() == botao_entrar){
			//muda de tela
			this.setVisible(false);

			UI02 janela2 = new UI02();
			janela2.setVisible(true);
		}
		if (e.getSource() == botao_sair){
			System.exit(0);
		}
	}
}
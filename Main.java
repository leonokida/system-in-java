import java.io.*;

import sistema.dinf.*;

//import sistema.dinf.Disciplina;
//import sistema.dinf.DisciplinaCursada;
//import sistema.dinf.DisciplinaDisponivel;
//import sistema.dinf.ListaCursadas;
//import sistema.dinf.ListaDisponiveis;
//import sistema.dinf.ListaCursadasDAO;
//import sistema.dinf.ListaDisponiveisDAO;
//import sistema.dinf.UI01;

public class Main{
	public static void main(String args[]){
		UI01 janela = new UI01();
		janela.setVisible(true);	

		ListaDisponiveis lista = ListaDisponiveis.getInstance();
		DisciplinaDisponivel disciplina = new DisciplinaDisponivel("218129217", "ICC", "obrigatoria", 60, 0);
		lista.adiciona(disciplina);
		disciplina = new DisciplinaDisponivel("211233213", "ITC", "obrigatoria", 60, 1);
		lista.adiciona(disciplina);

		//UI02 janela2 = new UI02();
		//janela2.setVisible(true);
	}
}
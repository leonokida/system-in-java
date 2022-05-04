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
		DisciplinaDisponivel disciplina;
		disciplina = new DisciplinaDisponivel("218129217", "ICC", "obrigatoria", 60, 1);
		lista.adiciona(disciplina);
		disciplina = new DisciplinaDisponivel("211233213", "ITC", "obrigatoria", 60, 2);
		lista.adiciona(disciplina);

		System.out.println(lista.busca(0).getNome());
		System.out.println(lista.busca(0).getPeriodo());
		System.out.println(lista.busca(1).getNome());
		System.out.println(lista.busca(1).getPeriodo());
		System.out.println(lista.tamanho());
		System.out.println(lista.busca((lista.tamanho()-1)).getPeriodo() - (lista.busca(0)).getPeriodo() + 1);

		//UI02 janela2 = new UI02();
		//janela2.setVisible(true);
	}
}
import java.io.*;

import sistema.dinf.ControladorAluno;

public class Debug {
	public static void main(String[] args) throws IOException{
		ControladorAluno novo = new ControladorAluno();
		novo.geraListas();
		System.out.println(novo.dadosAprovacao());
		System.out.println(novo.qtdReprovacoesFalta());
		System.out.println(novo.numMatriculasRecomendado());
		novo.escreve();
	}
}
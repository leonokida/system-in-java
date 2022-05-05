import java.io.*;

import sistema.dinf.ControladorAluno;

public class Debug {
	public static void main(String[] args) throws IOException{
		ControladorAluno novo = new ControladorAluno();

		novo.geraListas();
		novo.escreve();
	}
}
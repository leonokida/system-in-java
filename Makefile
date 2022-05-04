all:
	javac ./sistema/dinf/ControladorAluno.java
	javac ./sistema/dinf/Disciplina.java
	javac ./sistema/dinf/DisciplinaCursada.java
	javac ./sistema/dinf/DisciplinaDisponivel.java
	javac ./sistema/dinf/ListaCursadas.java
	javac ./sistema/dinf/ListaDisponiveis.java
	javac ./sistema/dinf/ListaCursadasDAO.java
	javac ./sistema/dinf/ListaDisponiveisDAO.java
	javac ./sistema/dinf/Arquivo.java
	javac Debug.java

main: javac main

purge:
	rm *.class
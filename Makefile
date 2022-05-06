all:
	javac ./sistema/dinf/ControladorAluno.java
	javac ./sistema/dinf/Disciplina.java
	javac ./sistema/dinf/DisciplinaCursada.java
	javac ./sistema/dinf/DisciplinaDisponivel.java
	javac ./sistema/dinf/ItemCheckbox.java
	javac ./sistema/dinf/ListaCursadas.java
	javac ./sistema/dinf/ListaDisponiveis.java
	javac ./sistema/dinf/ListaCursadasDAO.java
	javac ./sistema/dinf/ListaDisponiveisDAO.java
	javac ./sistema/dinf/ListaCheckbox.java
	javac ./sistema/dinf/Arquivo.java
	javac ./sistema/dinf/Tabela.java
	javac ./sistema/dinf/UI01.java
	javac ./sistema/dinf/UI02.java
	javac Main.java
#	javac Debug.java

main:
	javac Main.java

purge:
	rm sistema/dinf/*.class
	rm *.class
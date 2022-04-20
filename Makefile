all:
	javac -d . Disciplina.java
	javac -d . DisciplinaCursada.java
	javac -d . DisciplinaDisponivel.java
	javac -d . ListaCursadas.java
	javac -d . ListaDisponiveis.java
	javac -d . ListaCursadasDAO.java
	javac -d . ListaDisponiveisDAO.java
	javac -d . Arquivo.java
	javac Debug.java

purge:
	rm *.class
	rm -r sistema
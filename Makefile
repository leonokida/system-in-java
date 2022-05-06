INPUT = Main.class Main.java sistema.dinf

jar-file: all
	jar cmf SigaTap.mf SigaTap.jar $(INPUT)

all:
	javac -d . Disciplina.java
	javac -d . DisciplinaCursada.java
	javac -d . DisciplinaDisponivel.java
	javac -d . ListaCursadas.java
	javac -d . ListaDisponiveis.java
	javac -d . ListaCursadasDAO.java
	javac -d . ListaDisponiveisDAO.java
	javac -d . ItemCheckbox.java
	javac -d . ListaCheckbox.java
	javac -d . Arquivo.java
	javac -d . Tabela.java
	javac -d . ControladorAluno.java
	javac -d . UI03.java
	javac -d . UI02.java
	javac -d . UI01.java
	javac Main.java
#	javac Debug.java

main:
	javac Main.java

purge:
	rm sistema/dinf/*.class
	rm *.class

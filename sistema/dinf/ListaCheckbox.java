package sistema.dinf;

import java.util.ArrayList;

import sistema.dinf.ItemCheckbox;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaDisponiveis;

public class ListaCheckbox {
    private ArrayList<ItemCheckbox> itens;
    private static ListaCheckbox uniqueInstance;

    private ListaCheckbox() {
        itens = new ArrayList<ItemCheckbox>();
    }

    public static synchronized ListaCheckbox getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ListaCheckbox();
		}
		return uniqueInstance;
	}

    public int tamanho() {
        return this.itens.size();
    }

    public void criaLista(ListaDisponiveis lista) {
        int i;
        for (i = 0; i < lista.tamanho(); i++) {
            ItemCheckbox novo = new ItemCheckbox(false, lista.busca(i));
            itens.add(novo);
        }
    }

    public void adiciona(ItemCheckbox novo) {
        this.itens.add(novo);
    }

    public ItemCheckbox busca(int i) {
        return itens.get(i);
    }

    public int esvaziaLista() {
        int tamanhoAntigo = this.itens.size();
        while (this.itens.size() > 0) {
            this.itens.remove(0);
        }
        return tamanhoAntigo;
    }
}
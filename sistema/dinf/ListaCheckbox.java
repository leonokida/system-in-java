package sistema.dinf;

import java.util.ArrayList;

import sistema.dinf.ItemCheckbox;
import sistema.dinf.DisciplinaDisponivel;
import sistema.dinf.ListaDisponiveis;

public class ListaCheckbox {
    private ArrayList<ItemCheckbox> itens;

    public ListaCheckbox() {
        itens = new ArrayList<ItemCheckbox>();
    }

    public int tamanho() {
        return this.itens.size();
    }

    public void criaLista(ListaDisponiveis lista, int sem) {
        int i;
        for (i = 0; i < lista.tamanho(); i++) {
            if ((lista.busca(i).getPeriodo() >= sem) || lista.busca(i).getPeriodo() == 0) {
                ItemCheckbox novo = new ItemCheckbox(false, lista.busca(i));
                itens.add(novo);
            }
        }
    }

    public void adiciona(ItemCheckbox novo) {
    	this.itens.add(novo);
    }
    
    public void remove(int i) {
    	this.itens.remove(i);
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
package br.unip.model.sorters;

public class InsertionSorter implements Sorter {

    @Override
    public void sort(Comparable[] items, boolean isReverse) {
	Comparable key;
	int i;
	for (int j=1; j < items.length; j++) {
	    key = items[j];
	    for (i = j-1; (i >= 0) && ((items[i].compareTo(key)*(isReverse?-1:1)) > 0); i--) {
		items[i+1] = items[i];
	    }
	    items[i+1] = key;
	}
    }

    @Override
    public String getMethodName() {
	return "Método Insertion";
    }

    @Override
    public String getMethodBrief() {
	return "A ordenação por inserção (Insertion Sort) é considerada simples"
		+ ", mas possui uma grande eficiência quando a situação do qual"
		+ " ela está inserida possui um número pequeno de elementos sen"
		+ "do eles pouco desordenados. O seu método consiste em percorr"
		+ "er o vetor de elementos da esquerda para direita e à medida "
		+ "que ele vai adiantando ele vai ordenando os elementos do lad"
		+ "o esquerdo. ";
    }

}

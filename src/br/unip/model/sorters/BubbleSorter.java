package br.unip.model.sorters;

public class BubbleSorter implements Sorter{

    @Override
    public void sort(Comparable[] items, int numItems, boolean isReverse) {
	for(int i=0; i < numItems; i++){
	    for(int n=i+1; n < numItems; n++){
		int comparison = items[i].compareTo(items[n]);
		if(isReverse) comparison*=(-1);
		if(comparison > 0){
		    Comparable temp = items[i];
		    items[i] = items[n];
		    items[n] = temp;
		}
	    }
	}
    }

    @Override
    public String getMethodName() {
	return "Método Bubble";
    }

    @Override
    public String getMethodBrief() {
	return "O Bubble Sort, conhecido também como o \"método bolha\" é um dos mais simples algoritmos de ordenação, e seu método consiste basicamente em percorrer o vetor inúmeras vezes  junto de uma variável auxiliar, fazendo o maior elemento \"flutuar\" para o topo e assim definir uma sequência.";
    }
    
}

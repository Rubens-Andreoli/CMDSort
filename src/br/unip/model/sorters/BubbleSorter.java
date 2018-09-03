package br.unip.model.sorters;

public class BubbleSorter implements Sorter{

    @Override
    public void sort(Comparable[] items, boolean isReverse) {
	for(int i=0; i < items.length; i++){
	    for(int n=i+1; n < items.length; n++){
		if((items[i].compareTo(items[n])*(isReverse?-1:1)) > 0){
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
	return "O Bubble Sort, conhecido também como o \"método bolha\" é um do"
		+ "s mais simples algoritmos de ordenação, e seu método consist"
		+ "e basicamente em percorrer o vetor inúmeras vezes  junto de "
		+ "uma variável auxiliar, fazendo o maior elemento \"flutuar\" "
		+ "para o topo e assim definir uma sequência.";
    }
    
}

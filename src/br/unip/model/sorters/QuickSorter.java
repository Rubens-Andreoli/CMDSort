package br.unip.model.sorters;

public class QuickSorter implements Sorter{

    @Override
    public void sort(Comparable[] items, int numItems, boolean isReverse) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMethodName() {
	return "Método Quick";
    }

    @Override
    public String getMethodBrief() {
	return "O Quick Sort se baseia na ideia de escolher um elemento que se denomina \"pivô\", ele será considerado uma referência de ordenação, do qual os elementos que possuem um valor menor que o pivô serão postos antes dele, e os valores que são maiores que a referência após ele.";
    }
    
}

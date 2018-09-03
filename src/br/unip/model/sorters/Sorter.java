package br.unip.model.sorters;

public interface Sorter {
    
    void sort(Comparable[] items, int numItems, boolean isReverse);
    String getMethodName();
    String getMethodBrief();
}

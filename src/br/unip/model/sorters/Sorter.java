package br.unip.model.sorters;

public interface Sorter {
    
    void sort(Comparable[] items, boolean isReverse);
    String getMethodName();
    String getMethodBrief();
}

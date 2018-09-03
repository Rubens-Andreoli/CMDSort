package br.unip.model.sorters;

/**
 * Esta inteface determina métodos que devem estar contidos em uma classe
 * que organiza vetores de Comparables.
 */
public interface Sorter {
    
    /**
     * Organiza um vetor de Comparables 'items' em ordem crescente se o valor de 
     * 'isReverse' é false, e decrescente se true. Utilize 'isReverse' para inverter
     * resultado da comparação dos 'items' caso true;
     * @param items
     * @param isReverse 
     */
    void sort(Comparable[] items, boolean isReverse);
    
    /**
     * Retorna uma String com o nome do método de ordenação.
     * @return methodName
     */
    String getMethodName();
    
    /**
     * Retorna uma String com a descrição do método de ordenação.
     * @return methodBrief
     */
    String getMethodBrief();
}

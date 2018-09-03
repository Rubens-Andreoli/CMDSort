package br.unip.model;

public abstract class Configs {
    
    /*Items Constants*/
    public static final String INT_TYPE = "Inteiro";
    public static final int INT_MAXVALUE = 50000;
    public static final String MISC_TYPE = "Misto";
    public static final int MISC_MAX_VALUE = 5000;
    public static final char MISC_START_CH = 'A';
    public static final int MISC_MAX_CH = 26;		/*Valor de 'ch' máximo com início em 'START_CH'*/
    
    /*Sorters Constants*/
    public static final String BUBBLE_NAME = "Método Bubble";
    public static final String BUBBLE_BRIEF = "O Bubble Sort, conhecido também "
	    + "como o \"método bolha\" é um dos mais simples algoritmos de orde"
	    + "nação, e seu método consiste basicamente em percorrer o vetor in"
	    + "úmeras vezes  junto de uma variável auxiliar, fazendo o maior el"
	    + "emento \"flutuar\" para o topo e assim definir uma sequência.";
    public static final String INSERTION_NAME = "Método Insertion";
    public static final String INSERTION_BRIEF = "A ordenação por inserção (Ins"
	    + "ertion Sort) é considerada simples, mas possui uma grande eficiê"
	    + "ncia quando a situação do qual ela está inserida possui um númer"
	    + "o pequeno de elementos sendo eles pouco desordenados. O seu méto"
	    + "do consiste em percorrer o vetor de elementos da esquerda para d"
	    + "ireita e à medida que ele vai adiantando ele vai ordenando os el"
	    + "ementos do lado esquerdo.";
    public static final String QUICK_NAME = "Método Quick";
    public static final String QUICK_BRIEF = "O Quick Sort se baseia na ideia d"
	    + "e escolher um elemento que se denomina \"pivô\", ele será consid"
	    + "erado uma referência de ordenação, do qual os elementos que poss"
	    + "uem um valor menor que o pivô serão postos antes dele, e os valo"
	    + "res que são maiores que a referência após ele.";
    
}

package br.unip.controller;

public abstract class Configs {
    
    /*Main constants:*/
    public static final String MAIN_TITLE = "Listas - Métodos de Ordenação";
    public static final String[] ACTIONS = {"Gerar", "Salvar", "Abrir", "Ordenar", "Visualizar", "Ajuda", 
	"Sobre", "Sair"};
    public static final String MAIN_QUESTION = "Digite a opção desejada de acordo com o menu";
    public static final String INDICATOR_MSG = "Processando...";
    public static final int SHOW_MAX = 190;
    
    /*Generate constants:*/
    public static final String GENERATE_ITEMS_TITLE = "Geração de listas [Tipo de itens]";
    public static final String GENERATE_ITEMS_QUESTION = "Digite a opção de acordo com o tipo de item "
	    + "desejado";
    public static final String GENERATE_METHOD_TITLE = "Geração de listas [Forma de criação]";
    public static final String[] GENERATE_METHODS = {"Aleatória", "Semi-Ordenada", "Ordenada"};
    public static final String GENERATE_METHOD_QUESTION = "Digite a opção desejada para criação da lista";
    public static final String GENERATE_SIZE_TITLE = "Geração de listas [Número de elementos]";
    public static final String GENERATE_SIZE_PROMPT = "Digite a quantidade de elementos desejada: ";
    
    /*Save constants:*/
    public static final String SAVE_FOLDER = "lists";
    public static final String SAVE_FORMAT = ".lst";
    public static final String SAVE_NULL = "Não há lista para ser salva!";
    public static final String SAVE_TITLE = "Salvar lista";
    public static final String SAVE_PROMPT = "Digite o nome da lista a ser salva: ";
    public static final String SAVE_NAME_REGEX = "([a-zA-Z0-9_-]{2,})";
    public static final String SAVE_SUCCESS = "Lista salva com sucesso.";
    public static final String SAVE_ERROR = "Erro ao salvar a lista!";
    
    /*Open constants:*/
    public static final String OPEN_EMPTY = "Não há lista(s) salva(s)!";
    public static final String OPEN_TITLE = "Relação de listas salvas";
    public static final String OPEN_QUESTION = "Digite o número correspondente ao arquivo desejado";
    public static final String OPEN_SUCCESS_MASK = "Lista %s carregada com sucesso."; /*filename*/
    public static final String OPEN_NOT_FOUND = "Arquivo não encontrado!";
    public static final String OPEN_CLASS_ERROR = "Lista incompatível com a versão atual!";
    
    /*Order constants:*/
    public static final String ORDER_NULL = "Não há lista para ser ordenada!";
    public static final String ORDER_METHOD_TITLE = "Ordenar [Método]";
    public static final String ORDER_METHOD_COMP = "Comparativo de desempenho";
    public static final String ORDER_METHOD_QUESTION = "Digite a opção desejada de acordo com o menu";
    public static final String ORDER_RULE_TITLE = "Ordenar [Ordem]";
    public static final String ORDER_RULE_QUESTION = "Deseja ordenar em ordem crescente "
	    + "ou decrescente (c/d)? ";
    public static final char ORDER_RULE_CRESCENT = 'c';
    public static final char ORDER_RULE_DECRESCENT = 'd';
    public static final String ORDER_COMP_MASK = "%s: %s\n"; /*method name, execution time*/
    public static final String ORDER_COMP_TITLE = "Comparativo de desempenho";
    public static final String ORDER_TITLE_MASK = "Ordenação [%s]"; /*method name*/
    public static final String ORDER_MSG_MASK ="A ordenação foi concluida com "
	    + "sucesso em %s"; /*execution time*/
    public static final String ORDER_ERROR_MASK = "Memória insuficiente! Aumente o "
	    + "tamanho (em megabytes) "
	    + "do stack com o parâmetro -Xss__ (5m, 10m ...)\n%s interrompido!"; /*method name*/
    public static final String TIME_MASK_M = "%dm, %ds e %dms"; /*minutes, seconds, milliseconds*/
    public static final String TIME_MASK_S = "%ds e %dms"; /*seconds, milliseconds*/
    public static final String TIME_MASK_MS = "%dms"; /*milliseconds*/
    
    /*Show constants:*/
    public static final String SHOW_NULL = "Não há lista para ser exibida!";
    public static final String SHOW_TITLE = "Visualização de lista";
    public static final String SHOW_MSG_MASK = "Lista %s, exibida com sucesso.";
    public static final String SHOW_ORDER_MASK = "ordenada pelo %s"; /*method name*/
    public static final String SHOW_NOT_ORDER = "não ordenada";
    
    /*Sobre*/
    public static final String ABOUT_TITLE = "Sobre";
    public static final String ABOUT = 
	    "SOFTWARE PROJETADO PARA A DISCIPLINA APS (ATIVIDADES PRATICAS SUPERVISIONADAS).\n" +
	    "CURSO: CIENCIA DA COMPUTACAO -- TURMA: CC3P18 / CC3Q18 -- UNIP CAMPUS VARGAS.\n\n" +
	    "NOME: GUILHERME RODRIGUES DE CARVALHO.....................RA: C59386-9\n" +
	    "NOME: GUSTAVO FERREIRA MATHEUS............................RA: C64211-8\n" +
	    "NOME: RUBENS ANTONIO ANDREOLI JÚNIOR......................RA: T49128-2\n\n" +
	    "ESTE SOFTWARE FOI DESENVOLVIDO EM LINGUAGEM DE PROGRAMACAO ORIENTADA A OBJETOS (\"JAVA\") "
	    + "E TEM COMO OBJETIVO UTILIZAR E COMPARAR NO QUE TANGE A PERFORMANCE AS TECNICAS DE ORDENAÇÃO.";
    
    /*Ajuda*/
    public static final String HELP_TITLE = "Ajuda";
    public static final String HELP = 
	    "GERAR\n" +
	    "Gera uma lista que será utilizada nos métodos de ordenação.\n" +
	    "A lista pode ser gerada de três maneiras:\n" +
	    "Randomica = os elementos da lista são gerados de forma aleatória sem qualquer tipo "
	    + "de ordenação.\n" +
	    "Semi-ordenada = os elementos da lista são gerados de forma semi ordenada onde metade da lista "
	    + "está ordenada e metade não.\n" +
	    "Ordenada = os elementos da lista são gerados de forma ordenada podendo ser ordernado de forma "
	    + "crescente ou decrescente.\n\n" +
	    "SALVAR\n" +
	    "Salva a lista na pasta [" + SAVE_FOLDER + "] criada na raiz do programa, com o nome desejado "
	    + "e a extensão [" + SAVE_FORMAT + "].\n\n" +
	    "ABRIR\n" +
	    "Abre uma lista préviamente salva na pasta [" + SAVE_FOLDER + "] na raiz do programa.\n\n" +
	    "ORDENAR\n" +
	    "Lista os tipos de ordenação presentes no programa, e ao selecionar o tipo desejado retorna "
	    + "uma breve descrição do mesmo.\n\n" +
	    "VISUALIZAR\n" +
	    "Retorna a lista préviamente criada ou aberta e informa se a mesma está ou não ordenada e "
	    + "caso esteja informa qual o tipo de ordenação que foi utilizado.\n\n" +
	    "SOBRE\n" +
	    "Informações acadêmicas do projeto de APS (Atividades Práticas Supervisionadas).\n\n" +
	    "SAIR\n" +
	    "Finaliza a sessão atual do programa.";
    
}

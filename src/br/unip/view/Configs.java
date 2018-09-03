package br.unip.view;

public abstract class Configs {
    
    /*Output constants:*/
    public static final int WINDOW_SIZE = 78;
    public static final char SIDE_CHAR = '║';
    public static final char LINE_CHAR = '═';
    public static final char LINE_BREAK = '*';
    public static final String MENU_MASK = "%2d - %s"; /*index - item*/
    public static final Alignment DFLT_ALIGNMENT = Alignment.LEFT;
    public static final Alignment TOPTITLE_ALIGNMENT = Alignment.CENTER;
    public static final Alignment TOPMSG_ALIGNMENT = Alignment.RIGHT;
 
    /*Input constants*/
    public static final char DFLT_BOOLEAN_YES = 's';
    public static final char DFLT_BOOLEAN_NO = 'n';
    public static final String RANGE_MASK = "%s (%d-%d): "; /*prompt, min, max*/
    public static final String ENTER_PROMPT = "Pressione ENTER para continuar.";
    public static final String STRING_ERROR = "Input inválido! Texto possui caractere(s) inválido(s).\n";
    public static final String RANGE_ERROR = "Input inválido! Valor deve estar entre %d e %d.\n"; /*min, max*/
    public static final String INT_ERROR = "Input inválido! Digite um número inteiro.\n";
    public static final String BOOLEAN_ERROR = "Input inválido! Digite uma opção.\n";
    
}

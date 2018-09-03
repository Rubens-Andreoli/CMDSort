package br.unip.controller.actions;

import static br.unip.controller.Configs.*;
import br.unip.model.lists.VectorList;
import br.unip.model.sorters.Sorter;
import br.unip.view.inputs.BooleanInput;
import br.unip.view.screens.MenuScreen;
import br.unip.view.screens.QuestionScreen;
import br.unip.view.screens.TextScreen;
import java.util.List;

public class Order implements Action{

    private final MenuScreen orderMenu;
    private final QuestionScreen orderQuestion;
    private final VectorList list;
    private final List<Sorter> sorters;

    public Order(final List<Sorter> methods, final VectorList list) {
	this.sorters = methods;
	this.orderMenu = new MenuScreen(ORDER_METHOD_TITLE, this.sortersToString(), ORDER_METHOD_QUESTION);
	this.orderQuestion = new QuestionScreen(ORDER_RULE_TITLE, new BooleanInput(ORDER_RULE_QUESTION, 
		ORDER_RULE_DECRESCENT, ORDER_RULE_CRESCENT));
	this.list = list;
    }
    
    private String[] sortersToString() {
	String[] methodsString = new String[sorters.size()+1];
	int i;
	for(i=0; i<sorters.size(); i++){
	    methodsString[i] = sorters.get(i).getMethodName();
	}
	methodsString[i] = ORDER_METHOD_COMP;
	return methodsString;
    }

    @Override
    public Void doAction() {
	orderMenu.display();
	orderQuestion.display();
        orderQuestion.setFooter(INDICATOR_MSG);
	orderQuestion.displayFooter(true);
        this.orderList();
	return null;
    }

    private void orderList() {
	long start, end;
	String method = "Método x";
	try{
	    if(orderMenu.getUserInput() == sorters.size()+1){	
		VectorList[] clonedLists = this.cloneList();
		StringBuilder results = new StringBuilder();
		/*Para cada um dos 'sorters' mede o tempo de excução na ordenação de uma cópia da lista:*/
		for(int i=0; i<sorters.size(); i++){
		    method = sorters.get(i).getMethodName();
		    start = System.currentTimeMillis();
		    clonedLists[i].sort(sorters.get(i), (Boolean) orderQuestion.getUserInput());
		    end = System.currentTimeMillis();
		    results.append(String.format(ORDER_COMP_MASK, method, this.time(end - start)));
		}
		new TextScreen(ORDER_COMP_TITLE, clonedLists[0].toString(60), results.toString()).display();
	    }else{
		method = sorters.get(orderMenu.getUserInput()-1).getMethodName();
		start = System.currentTimeMillis();
		list.sort(sorters.get(orderMenu.getUserInput()-1), (boolean) orderQuestion.getUserInput());
		end = System.currentTimeMillis();
		new TextScreen(String.format(ORDER_TITLE_MASK, method),
		    list.getSortMethod().getMethodBrief(),
		    String.format(ORDER_MSG_MASK, this.time(end-start))).display();
	    }
	}catch(StackOverflowError ex){
		orderQuestion.setFooter(String.format(ORDER_ERROR_MASK, method));
		orderQuestion.displayFooter(true);
		orderQuestion.waitEnter();
	}
    }
    
    private String time(long milli) {
	if(milli >= 60000){
	    int minutes = (int) (milli/60000);
	    int seconds = (int) ((milli-(minutes*60000))/1000);
	    int millis = (int) ((milli-((seconds*1000)+(minutes*60000))));
	    return String.format(TIME_MASK_M, minutes, seconds, millis);
	}else if(milli >= 1000){
	    int seconds = (int) milli/1000;
	    int millis = (int) ((milli-(seconds*1000)));
	    return String.format(TIME_MASK_S, seconds, millis);
	}
	return String.format(TIME_MASK_MS, milli);
    }
    
    
    private VectorList[] cloneList(){
	VectorList[] clonedLists = new VectorList[sorters.size()];
	for(int i=0; i<sorters.size(); i++){
	    clonedLists[i] = new VectorList(list);
	}
	return clonedLists;
    }

}

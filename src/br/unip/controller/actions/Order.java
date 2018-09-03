package br.unip.controller.actions;

import br.unip.model.lists.VectorList;
import br.unip.model.sorters.BubbleSorter;
import br.unip.model.sorters.InsertionSorter;
import br.unip.model.sorters.MergeSorter;
import br.unip.model.sorters.QuickSorter;
import br.unip.view.screens.MenuScreen;
import br.unip.view.screens.QuestionScreen;
import br.unip.view.screens.TextScreen;

public class Order implements Action{

    private final MenuScreen orderMenu;
    private final QuestionScreen orderQuestion;
    private final VectorList list;

    public Order(final MenuScreen orderMenu, final QuestionScreen orderQuestion, final VectorList list) {
	this.orderMenu = orderMenu;
	this.orderQuestion = orderQuestion;
	this.list = list;
    }

    @Override
    public Void doAction() {
	orderMenu.display();
	orderQuestion.display();
	orderQuestion.setFooter("Processando...\n");
	orderQuestion.displayFooter(false);
	long time = this.orderList()[0];
	if (orderMenu.getUserInput() == 4) {
	    //TODO: Exibir comparativo!
	} else {
	    new TextScreen("Ordenação pelo " + list.getSortMethod().getMethodName(),
		    list.getSortMethod().getMethodBrief(),
		    "A ordenação foi concluida com sucesso em " + time + " ms.\n").display();
	}
	return null;
    }

    private long[] orderList() {
	long start;
	long end;
	switch (orderMenu.getUserInput()) {
	    case 1:
		start = System.currentTimeMillis();
		list.sort(new BubbleSorter(), (boolean) orderQuestion.getUserInput());
		end = System.currentTimeMillis();
		return new long[]{end - start};
	    case 2:
		start = System.currentTimeMillis();
		list.sort(new InsertionSorter(), (boolean) orderQuestion.getUserInput());
		end = System.currentTimeMillis();
		return new long[]{end - start};
	    case 3:
		start = System.currentTimeMillis();
		list.sort(new MergeSorter(), (boolean) orderQuestion.getUserInput());
		end = System.currentTimeMillis();
		return new long[]{end - start};
	    case 4:
		start = System.currentTimeMillis();
		list.sort(new QuickSorter(), (boolean) orderQuestion.getUserInput());
		end = System.currentTimeMillis();
		return new long[]{end - start};
	    case 5:
		long[] times = new long[3];
		start = System.currentTimeMillis();
		new VectorList(list).sort(new BubbleSorter(), (boolean) orderQuestion.getUserInput());
		end = System.currentTimeMillis();
		times[0] = end - start;
		start = System.currentTimeMillis();
		new VectorList(list).sort(new MergeSorter(), (boolean) orderQuestion.getUserInput());
		end = System.currentTimeMillis();
		times[1] = end - start;
		start = System.currentTimeMillis();
		new VectorList(list).sort(new QuickSorter(), (boolean) orderQuestion.getUserInput());
		end = System.currentTimeMillis();
		times[2] = end - start;
		return times;
	    default:
		return null;
	}
    }

}

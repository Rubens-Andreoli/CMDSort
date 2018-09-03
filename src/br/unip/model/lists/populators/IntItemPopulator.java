package br.unip.model.lists.populators;

import br.unip.model.items.IntItem;

public class IntItemPopulator extends Populator<IntItem>{

    public IntItemPopulator() {
	super(IntItem.ITEM_TYPE);
    }

    @Override
    public IntItem createItem() {
	return new IntItem();
    }
    
}

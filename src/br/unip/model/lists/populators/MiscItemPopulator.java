package br.unip.model.lists.populators;

import br.unip.model.items.MiscItem;

public class MiscItemPopulator extends Populator<MiscItem>{

    public MiscItemPopulator() {
	super(MiscItem.ITEM_TYPE);
    }

    @Override
    public MiscItem createItem() {
	return new MiscItem();
    }
    
}

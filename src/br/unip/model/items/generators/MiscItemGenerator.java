package br.unip.model.items.generators;

import br.unip.model.items.MiscItem;
import static br.unip.model.Configs.MISC_TYPE;

public class MiscItemGenerator extends ItemGenerator<MiscItem>{

    @Override
    protected MiscItem generateItem() { return new MiscItem(); }

    @Override
    protected MiscItem[] generateVector(int numItems) { return new MiscItem[numItems]; }

    @Override
    public String getItemType() { return MISC_TYPE; }
    
}

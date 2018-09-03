package br.unip.model.items.generators;

import br.unip.model.items.IntItem;
import static br.unip.model.Configs.INT_TYPE;

public class IntItemGenerator extends ItemGenerator<IntItem>{

    @Override
    protected IntItem generateItem() { return new IntItem(); }

    @Override
    protected IntItem[] generateVector(int numItems) { return new IntItem[numItems]; }   

    @Override
    public String getItemType() { return INT_TYPE; }
    
}

package br.unip.view;

public abstract class Builder {
    
    public static <T extends Buildable> T build(T buildable){
	buildable.build();
	return buildable;
    }
    
}

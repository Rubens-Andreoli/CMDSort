package br.unip.model.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileIO<Type extends Serializable> {
        
    public Type readFile(File file) throws IOException, ClassNotFoundException {
	try (FileInputStream fileInput = new FileInputStream(file);
		ObjectInputStream objectInput = new ObjectInputStream(fileInput);) {
	    return (Type) objectInput.readObject();
	}
    }
    
    public void writeFile(Type object, String rootFolder, String filename) throws IOException {
	try (FileOutputStream fileOutput = new FileOutputStream(new File(System.getProperty("user.dir") 
		+ "\\"+rootFolder+"\\"+filename));
		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);) {
	    objectOutput.writeObject(object);
	}
    }
    
    public File[] readFolder(String rootFolder, String fileFormat){
        File listsFolder = new File(System.getProperty("user.dir") + "\\"+rootFolder);
	if(!listsFolder.exists()){
	    listsFolder.mkdir();
	}	
        return listsFolder.listFiles(new FileFilter(){
	    @Override
	    public boolean accept(File file) {
		return file.getName().endsWith(fileFormat);
	    }
	    
	});
    }
    
}

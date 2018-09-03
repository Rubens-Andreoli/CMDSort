package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileIO<Type extends Serializable> {
        
    public Type read(File file) throws IOException, ClassNotFoundException {
	try (FileInputStream fileInput = new FileInputStream(file);
		ObjectInputStream objectInput = new ObjectInputStream(fileInput);) {
	    return (Type) objectInput.readObject();
	}
    }
    
    public void write(Serializable object, File file) throws IOException {
	try (FileOutputStream fileOutput = new FileOutputStream(file);
		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);) {
	    objectOutput.writeObject(object);
	}
    }
}

package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileIO<Type extends Serializable> {
        
    public Type read(File file) {
	try (FileInputStream fileInput = new FileInputStream(file);
		ObjectInputStream objectInput = new ObjectInputStream(fileInput);) {
	    return (Type) objectInput.readObject();
	} catch (FileNotFoundException e) {
	    System.out.println("Arquivo não encontrado!");
	} catch (IOException e) {
	    System.out.println("Erro na leitura do arquivo!");
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    System.out.println("Classe não encontrada!");
	}
	return null;
    }
    
    public void write(Serializable object, File file) {
	try (FileOutputStream fileOutput = new FileOutputStream(file);
		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);) {
	    objectOutput.writeObject(object);
	} catch (FileNotFoundException e) {
	    System.out.println("Arquivo não criado!");
	} catch (IOException e) {
	    System.out.println("Erro na leitura do arquivo!");
	}
    }
}

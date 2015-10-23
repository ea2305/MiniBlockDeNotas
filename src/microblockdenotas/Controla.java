/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package microblockdenotas;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controla {
    
    private final FileChooser fileDialog = new FileChooser();
    private File file = null;
    
    private int index = 0;
    private int caracteres = 0;

    
    String[ ] Contenedor;
    
    
    public Controla(){
        Contenedor = new String[100];
        Contenedor[index++] = " ";
    }

    public void setString(String cadena){
        Contenedor[index++] = cadena;
    }
    
    public int getString(){
        
        return Contenedor[index - 1].replace(" ","").length();
    }

    public String rehacer(){
        return Contenedor[++index];
    }

    public String deshacer(){
        if(index != 0)
            return Contenedor[--index];
        return null;
    }
    
    public void resetIndex(){
        this.index = 0;
    }
    
    public String openFile(){
        fileDialog.setTitle("Open Resume");
		
		file = fileDialog.showOpenDialog(new Stage());
		
		if (file == null) {
			return "";
		}
	
		try {
			String texto = "";
                        List<String> ls = Files.readAllLines(file.toPath());
                        for(int i=0; i<ls.size(); i++)
                            texto += ls.get(i) + "\n" ;
                        return texto;
			
		}catch(IOException e) {
			e.printStackTrace();
                        return "";
			
		}
    }
    
    public void saveFileAs(String texto) {
		
		fileDialog.setTitle("Save Resume");
		fileDialog.setInitialFileName("untitled.txt");
		file = fileDialog.showSaveDialog(new Stage());
		 
		if (file == null) {
			return;
		}
	
		try {
			
			// Write the HTML contents to the file. Overwrite the existing file.
                        Files.write(file.toPath(), texto.getBytes());
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}
    
    public void saveFile(String texto) {
		 
		if (file == null) {
                        fileDialog.setTitle("Save Resume");
                        fileDialog.setInitialFileName("untitled.txt");
                        file = fileDialog.showSaveDialog(new Stage());
                        if (file == null) {
                            return;
                        }
		}
	
		try {
			
			// Write the HTML contents to the file. Overwrite the existing file.
                        Files.write(file.toPath(), texto.getBytes());
			
		}catch(IOException e) {
			
			e.printStackTrace();
			
		}
	}
    
}
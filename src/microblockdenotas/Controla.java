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
    
    private int index = 0;
    
    String[ ] Contenedor = new String[100];
    
    public Controla(){
        Contenedor[index++] = " ";
    }

    public void setString(String cadena){
        System.out.println(cadena);
        Contenedor[index++] = cadena;
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
		
		File file = fileDialog.showOpenDialog(new Stage());//?????
		
		if (file == null) {
			return "Archivo no existe";
		}
	
		try {
			String texto = "";
                        List<String> ls = Files.readAllLines(file.toPath());
                        for(int i=0; i<ls.size(); i++){
                            texto += ls.get(i) + "\n" ;
                        }
                        return texto;
			
		}catch(IOException e) {
			//alerta pendiente eh fernando te ablo a ti deja el lol
			e.printStackTrace();
                        return "Error";
			
		}
    }
    
}
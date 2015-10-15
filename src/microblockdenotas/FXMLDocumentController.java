package microblockdenotas;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author ealbores
 */

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML TextArea TextoArea;
    
    Controla ct = new Controla();
    
    @FXML private void TextAreaArray(Event event){
        System.out.println("LL");
        ct.setString(TextoArea.getText());
        
    }
    
    @FXML private void rehacer(ActionEvent event){
        TextoArea.setText(ct.rehacer());
        
    }
    
    @FXML private void deshacer(ActionEvent event){
        
        try{
            TextoArea.setText(ct.deshacer());
        }catch(Exception e){
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setTitle("No hay nada que sacar!");
            alert1.setHeaderText(null);
            alert1.setContentText("Sin elementos");
            alert1.showAndWait();
        }
    }
    
    @FXML private void salir(ActionEvent event){
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Desea salir?");
        alert.setHeaderText("Importante");
        alert.setContentText("Desea salir realmente?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == ButtonType.OK){
            
            System.exit(0);
            
        }else{
            
            Alert alert1 = new Alert(AlertType.INFORMATION);
            alert1.setTitle("Nota!");
            alert1.setHeaderText(null);
            alert1.setContentText("Salida abortada...");
            alert1.showAndWait();
        }
        
    }
    
     @FXML private void creditos(ActionEvent event){
        

        Alert alert1 = new Alert(AlertType.INFORMATION);
        alert1.setTitle("Universidad Politécnica de Chiapas");
        alert1.setHeaderText("Creditos");
        alert1.setContentText("Elihu Alejandro Cruz Albores\nMatricula:143405\nProfesor:Juan Carlos Lopez Pimentel");
        alert1.showAndWait();

        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

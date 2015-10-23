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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author kkkk
 */

public class FXMLDocumentController implements Initializable {
    
    @FXML private Label label,numCaracteres,numFilas;
    @FXML ColorPicker colorPicker;
    @FXML Button btnAplicar;
    @FXML TextArea TextoArea;
    
    private Controla ct = new Controla();
    private long ContadorFilas = 0;
    private int ContadorCaracteres = 0;
    
    
    @FXML private void TextAreaArray(Event event){
        this.ContadorCaracteres = ct.getString();
        this.numCaracteres.setText("Caracteres: " + this.ContadorCaracteres);
        //this.numCaracteres.setText("Caracteres: " + this.numCaracteres.getText().length());
        
        
        ct.setString(TextoArea.getText());
        
    }
    
    @FXML private void rehacer(ActionEvent event){
        TextoArea.setText(ct.rehacer());
        
    }
    
    @FXML private void deshacer(ActionEvent event){
            TextoArea.setText(ct.deshacer());
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
     
    @FXML private void abrir(ActionEvent event){
        TextoArea.setText(ct.openFile());
        ct.setString(TextoArea.getText());
    }
     
    @FXML private void guardar(ActionEvent event){
        ct.saveFile(TextoArea.getText());
        
    }
    
    @FXML private void guardarComo(ActionEvent event){
        ct.saveFileAs(TextoArea.getText());
    }
    @FXML private void selectColor(ActionEvent event){
        // code pendiente
    }

    @FXML private void aplicarColor(ActionEvent event){
        String hexColor = colorPicker.getValue().toString();
        System.out.println("antes : " + hexColor);
        String hexColorFill = hexColor.substring(2,hexColor.length() - 2);
        
        this.TextoArea.setStyle("-fx-text-fill: #" + hexColorFill.trim());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        this.TextoArea.setStyle("-fx-background-color: red;" +
                                "-fx-text-fill: red;");
        */
    }    
    
}
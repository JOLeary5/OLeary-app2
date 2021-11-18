package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class editItemController {

    @FXML
    TextField itemNameTextField;
    @FXML
    TextField itemValueTextField;
    @FXML
    TextField itemProductNumberTextField;

    private GUIController controller;


    public void editItemAction() {
        System.out.println("Editing Current Item");
    }

    public void setParentController(GUIController guicontroller){
        this.controller = guicontroller;
    }
}

package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String name = itemNameTextField.getText();
        String productNumber = itemProductNumberTextField.getText();
        String productValue = itemValueTextField.getText();

        int nameLength = name.length();

        double value;

        Pattern productNumberFormat = Pattern.compile("\\p{Alpha}-\\w\\w\\w-\\w\\w\\w-\\w\\w\\w");
        Matcher productNumberMatcher = productNumberFormat.matcher(productNumber);
        boolean productNumberFormatCheck = productNumberMatcher.matches();



        if ((nameLength>=2) && (nameLength<=256)){
            if (productNumberFormatCheck){
                System.out.println("ProductNumber Check (PASSED)");
                try {
                    value = Double.parseDouble(productValue);
                    controller.currentItem.setItemName(name);
                    controller.currentItem.setItemValue(value);
                    controller.currentItem.setItemProductNumber(productNumber);
                    controller.listViewWindow.refresh();
                }
                catch (NumberFormatException ignore){
                    System.out.println("Incorrect Value Format");
                }
            }
            else {
                System.out.println("Incorrect Product Number Format");
            }
        }

        else {
            System.out.println("Incorrect name format");
        }

    }

    public void setParentController(GUIController guicontroller){
        this.controller = guicontroller;
    }
}

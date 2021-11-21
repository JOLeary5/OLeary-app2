package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Objects;
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

        Boolean productNumberSimilarCheck = productNumberMatchingCheck(productNumber);

        if ((nameLength>=2) && (nameLength<=256)){
            if (productNumberFormatCheck){
                System.out.println("ProductNumber Check (PASSED)");
                if (Boolean.TRUE.equals(productNumberSimilarCheck)) {
                    try {
                        value = Double.parseDouble(productValue);
                        controller.currentItem.setItemName(name);
                        controller.currentItem.setItemValue(value);
                        controller.currentItem.setItemProductNumber(productNumber);
                        controller.listViewWindow.refresh();
                    } catch (NumberFormatException ignore) {
                        System.out.println("Incorrect Value Format");
                    }
                } else {
                    System.out.println("Product Number SameCheck Failed, Enter a Unique Product Code");
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

    private Boolean productNumberMatchingCheck(String productNum) {

        for (int i=0; i<controller.userItemList.itemListAll.size(); i++) {
            if (productNum.matches(controller.userItemList.itemListAll.get(i).getItemProductNumber())){
                return false;
            }
        }
        return true;
    }

    public void setParentController(GUIController guicontroller){
        this.controller = guicontroller;
    }
}

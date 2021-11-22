/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jonathan O'Leary
 */
package baseline;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddItemController {

    @FXML
    TextField itemNameTextField;
    @FXML
    TextField itemValueTextField;
    @FXML
    TextField itemProductNumberTextField;

    private GUIController controller;

    public void createItemAction() {
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
                if (Boolean.TRUE.equals(productNumberSimilarCheck)){
                    try {
                        value = Double.parseDouble(productValue);
                            if (value>=0){
                                System.out.println("Adding Item");
                                controller.userItemList.addItem(value,productNumber,name);
                            }
                            else {
                                System.out.println("Incorrect Value Format");
                                JFrame helpFrame = new JFrame();
                                ImageIcon icon =new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("errorScreen(IncorrectValue).PNG")));

                                JLabel label = new JLabel(icon);
                                helpFrame.add(label);
                                helpFrame.pack();
                                helpFrame.setVisible(true);
                            }
                    }
                    catch (NumberFormatException ignore){
                        System.out.println("Incorrect Value Format");
                        JFrame helpFrame = new JFrame();
                        ImageIcon icon =new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("errorScreen(IncorrectValue).PNG")));

                        JLabel label = new JLabel(icon);
                        helpFrame.add(label);
                        helpFrame.pack();
                        helpFrame.setVisible(true);
                    }
                } else {
                    System.out.println("Product Number SameCheck Failed, Enter a Unique Product Code");
                    JFrame helpFrame = new JFrame();
                    ImageIcon icon =new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("errorScreen(UniqueSerialNumber).PNG")));

                    JLabel label = new JLabel(icon);
                    helpFrame.add(label);
                    helpFrame.pack();
                    helpFrame.setVisible(true);
                }
            }
            else {
                System.out.println("Incorrect Product Number Format");
                JFrame helpFrame = new JFrame();
                ImageIcon icon =new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("errorScreen(incorrectSerialNumberFormat).PNG")));

                JLabel label = new JLabel(icon);
                helpFrame.add(label);
                helpFrame.pack();
                helpFrame.setVisible(true);

            }
        }

        else {
            System.out.println("Incorrect name format");
            JFrame helpFrame = new JFrame();
            ImageIcon icon =new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("errorScreen(incorrectNameFormat).PNG")));

            JLabel label = new JLabel(icon);
            helpFrame.add(label);
            helpFrame.pack();
            helpFrame.setVisible(true);
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

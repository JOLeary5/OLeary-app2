package baseline;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class loadItemController {

    private GUIController controller;



    public void loadTSB() throws FileNotFoundException {
        System.out.println("Loading By TSB");
        JFrame parent = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load");



        int userSelection = fileChooser.showSaveDialog(parent);
        if (userSelection == JFileChooser.APPROVE_OPTION){

            Scanner scanR = new Scanner(fileChooser.getSelectedFile());

            while (scanR.hasNextLine()){
                String line = scanR.nextLine();
                String[] items = line.split("\t");

                System.out.println(items[0]);
                System.out.println(items[1]);
                System.out.println(items[2]);

                double value = Double.parseDouble(items[2]);
                controller.userItemList.itemListAll.add(new Item(value,items[1],items[0]));
            }
            scanR.close();
        }
    }

    public void loadHTML() {
        System.out.println("Loading By HTML");
    }

    public void loadJSON() {
        System.out.println("Loading by Jason");
    }

    public void setParentController(GUIController guiController) {this.controller = guiController;}
}

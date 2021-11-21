package baseline;

import javax.swing.*;
import java.io.FileWriter;

public class saveItemController {

    private GUIController controller;



    public void saveTSB() {
        System.out.println("Saving By TSB \t" +controller.userItemList.itemListAll.size());
        JFrame parent = new JFrame();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(parent);

        if (userSelection == JFileChooser.APPROVE_OPTION){
            try {
                FileWriter fw = new FileWriter((fileChooser.getSelectedFile()+".txt"));
                for (int i=0; i<controller.userItemList.itemListAll.size(); i++){
                    String outputText = controller.userItemList.itemListAll.get(i).getItemName() + "\t" + controller.userItemList.itemListAll.get(i).getItemProductNumber()
                            + "\t" + controller.userItemList.itemListAll.get(i).getItemValue().toString() + "\n";
                    fw.write(outputText);
                }
                fw.close();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void saveHTML() {
        System.out.println("Saving By HTML");
    }

    public void saveJSON() {
        System.out.println("Saving by Jason");
    }

    public void setParentController(GUIController guiController) {this.controller = guiController;}
}

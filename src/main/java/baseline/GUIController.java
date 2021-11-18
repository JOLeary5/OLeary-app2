package baseline;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class GUIController implements Initializable {
    @FXML
    ListView<Item> listViewWindow;


    ItemList userItemList = new ItemList();
    Item currentItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        listViewWindow.setItems(userItemList.getItemList());
        listViewWindow.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            currentItem = listViewWindow.getSelectionModel().getSelectedItem();
        });
    }

    public void addItemAction() throws IOException {
        System.out.println("Adding Item to List");

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("addItemWindow.fxml"));
        Parent root = loader.load();
        addItemController addItemControl = loader.getController();
        addItemControl.setParentController(this);

        Stage stage = new Stage();
        stage.setTitle("Add item");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void editItemAction() throws IOException {
        System.out.println("Editing Item in List");

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("editItemWindow.fxml"));
        Parent root = loader.load();
        editItemController editItemControl = loader.getController();
        editItemControl.setParentController(this);

        Stage stage = new Stage();
        stage.setTitle("Edit item");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void deleteItemAction() {
        userItemList.itemListAll.remove(listViewWindow.getSelectionModel().getSelectedItem());
    }

    public void clearItemListAction() {
        userItemList.itemListAll.clear();
    }

    public void sortByValueAction() {
        Comparator<Item> itemValueComparator = Comparator.comparing(Item::getItemValue);
        userItemList.itemListAll.sort(itemValueComparator);
    }

    public void sortSerialNumberAction() {
        Comparator<Item> itemSerialNumberComparator = Comparator.comparing(Item::getItemProductNumber);
        userItemList.itemListAll.sort(itemSerialNumberComparator);
    }

    public void sortByNameAction() {
        Comparator<Item> itemNameComparator = Comparator.comparing(Item::getItemName);
        userItemList.itemListAll.sort(itemNameComparator);
    }



    /*
        The various button presses that utilize different Functions
     */
}

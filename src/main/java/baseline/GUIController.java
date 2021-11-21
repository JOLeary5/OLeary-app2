package baseline;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class GUIController implements Initializable {

    @FXML
    TextField searchTextField;
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

        FilteredList<Item> filteredItems = new FilteredList<>(userItemList.itemListAll, b -> true);

        searchTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredItems.setPredicate(Item -> {

                if (newValue.isEmpty() || newValue.isBlank()) {
                    return true;
                }

                if (Item.getItemName().contains(newValue)){
                    return true;
                }
                else if (Item.getItemProductNumber().contains(newValue)){
                    return true;
                }
                else {
                    return false;
                }
            });
        }));

        SortedList<Item> sortedList = new SortedList<>(filteredItems);
        sortedList.comparatorProperty();
        listViewWindow.setItems(sortedList);

    }

    public void addItemAction() throws IOException {
        System.out.println("Adding Item to List");

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("addItemWindow.fxml"));
        Parent root = loader.load();
        addItemController addItemControl = loader.getController();
        addItemControl.setParentController(this);

        Stage stage = new Stage();
        stage.setTitle("Add Item");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void editItemAction() throws IOException {
        System.out.println("Editing Item in List");

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("editItemWindow.fxml"));
        Parent root = loader.load();
        editItemController editItemControl = loader.getController();

        editItemControl.itemNameTextField.setText(currentItem.getItemName());
        editItemControl.itemValueTextField.setText(currentItem.getItemValue().toString());
        editItemControl.itemProductNumberTextField.setText(currentItem.getItemProductNumber());

        editItemControl.setParentController(this);

        Stage stage = new Stage();
        stage.setTitle("Edit Item");
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

    public void saveItemsAction() throws IOException {
        System.out.println("Saving Items In list");

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("saveItemsWindow.fxml"));
        Parent root = loader.load();
        saveItemController saveItemControl = loader.getController();
        saveItemControl.setParentController(this);

        Stage stage = new Stage();
        stage.setTitle("Save Items");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void loadItemsAction() throws IOException {
        System.out.println("Loading Items In list");

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("loadItemsWindow.fxml"));
        Parent root = loader.load();
        loadItemController loadItemControl = loader.getController();
        loadItemControl.setParentController(this);

        Stage stage = new Stage();
        stage.setTitle("Load Items");
        stage.setScene(new Scene(root));
        stage.show();
    }
}

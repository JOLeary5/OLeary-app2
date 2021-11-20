package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemList {

    ObservableList<Item> itemListAll = FXCollections.observableArrayList();
    Item currentItem;

    public void setItemList(ObservableList<Item> listAll){this.itemListAll = listAll;}

    public ObservableList<Item> getItemList(){return itemListAll;}

    public void addItem(Double value, String productNumber, String name) {
        itemListAll.add(new Item(value,productNumber,name));
    }
}

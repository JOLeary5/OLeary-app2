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

    /*
    ObservableList<Item> listAll = FXCollections.observableArrayList();
    Item currentItem;

    public void setItemList(ObservableList<Item> listAll){
        this.listAll = listAll;
     }

    public void addItem() {
        listAll.add(new Item(value, serialNumber, name));
     }

     public void deleteItem() throws IOException{
        listAll.remove(ListView.getSelectionModel().getSelectedItem();
     }

     public void clearItemList(){
        listAll.clear;
     }

     public void SortByValue(){
        FilteredList<Item> listComplete = new FilteredList<>(listAll, Item::getValue);
        itemList.setItems(listComplete);
     }

     public void SortBySerialNumber(){
        FilteredList<Item> listComplete = new FilteredList<>(listAll, Item::getSerialNumber);
        itemList.setItems(listComplete);
     }

     public void SortByName(){
        FilteredList<Item> listComplete = new FilteredList<>(listAll, Item::getValue);
        itemList.setItems(listComplete);
     }

     public ItemList(ObservableList listArray){
        this.setItemList
     }
     */

}

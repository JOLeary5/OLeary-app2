/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jonathan O'Leary
 */
package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemList {

    ObservableList<Item> itemListAll = FXCollections.observableArrayList();

    public ObservableList<Item> getItemList(){return itemListAll;}

    public void addItem(Double value, String productNumber, String name) {
        itemListAll.add(new Item(value,productNumber,name));
    }
}

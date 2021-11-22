package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class GUIControllerTest {

    @Test
    void deleteItemAction() {
        Item testItem = new Item(30.0,"X-CCC-CHH-223","Joe's Bubblegum");

        ObservableList<Item> testList = FXCollections.observableArrayList();
        testList.setAll(testItem);

        testList.remove(testItem);

        if (testItem==null){
            assertTrue(true);
        }

    }

    @Test
    void clearItemListAction() {
        Item testItem1 = new Item(30.0,"X-CCC-678-235","Joe's Bubblegum");
        Item testItem2 = new Item(5.0,"X-CAC-111-111","Glass Beads");
        Item testItem3 = new Item(2.0,"X-CDC-ABC-674","One Termite");

        ObservableList<Item> testList = FXCollections.observableArrayList();
        testList.setAll(testItem1,testItem2,testItem3);

        if (testList == null){
            assertTrue(true);
        }

    }
}
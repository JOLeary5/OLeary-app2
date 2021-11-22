package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void setItemValue() {
        Item testItem = new Item(40.0,"A-XXX-XXX-XXX", "ProductName");
        assertEquals(40.0, testItem.getItemValue());
    }

    @Test
    void setItemProductNumber() {
        Item testItem = new Item(40.0,"A-XXX-XXX-XXX", "ProductName");
        assertEquals("A-XXX-XXX-XXX", testItem.getItemProductNumber());
    }

    @Test
    void setItemName() {
        Item testItem = new Item(40.0,"A-XXX-XXX-XXX", "ProductName");
        assertEquals("ProductName", testItem.getItemName());
    }
}
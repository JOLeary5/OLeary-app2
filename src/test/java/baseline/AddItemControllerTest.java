package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddItemControllerTest {

    @Test
    void createItemAction() {
        GUIController controller = new GUIController();
        controller.userItemList.itemListAll.add(new Item(23.0,"X-AAA-AAA-AAA","Peanuts"));
        if (controller.userItemList.itemListAll != null){
            assert true;
        }
    }

}
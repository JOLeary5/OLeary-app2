package baseline;

public class Item {

    private double value;
    private String productNumber;
    private String name;

    public void setItemValue(double value){this.value = value;}

    public Double getItemValue() {return value;}

    public void setItemProductNumber(String productNumber){this.productNumber = productNumber;}

    public String getItemProductNumber() {return productNumber;}

    public void setItemName(String name){this.name = name;}

    public String getItemName() {return name;}

    public String getItemString() {return name;}

    public Item (Double value, String productNumber, String name){
        this.setItemValue(value);
        this.setItemProductNumber(productNumber);
        this.setItemName(name);
    }

    public  String toString() {return this.name+"\t\t"+this.productNumber+"\t\t"+this.value;}

    /*
    - private double Value
    - private Formatted String
    - String ItemName

    void setItemValue (double value) {this.value = value;}

    void getItemValue () {return value;}

    void setSerialNumber (String serialNumber) {this.serialNumber = serialNumber}

    void getSerialNumber () {return serialNumber}

    void setItemName (String name) {this.name = name}

    void getItemName () {return name}

    public Item(double value, String SerialNumber, String Name){

        this.setItemValue(value);
        this.setSerialNumber(serialNumber);
        this.setItemName(name);

    }
     */
}

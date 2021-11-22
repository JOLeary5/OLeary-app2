/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jonathan O'Leary
 */
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

    public Item (Double value, String productNumber, String name){
        this.setItemValue(value);
        this.setItemProductNumber(productNumber);
        this.setItemName(name);
    }

    public  String toString() {return this.name+"\t\t"+this.productNumber+"\t\t$"+this.value;}

}

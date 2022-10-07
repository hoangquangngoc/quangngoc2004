package casestudy_Modul2.Models;

import java.io.Serializable;

public class Product implements Serializable {
    private int idProduct;
    private String nameCaterory;

    private double price;
    private int amount;
    private String describe;

    public Product() {
    }

    public Product(int idProduct, String nameCaterory, double price, int amount, String describe) {
        this.idProduct = idProduct;
        this.nameCaterory = nameCaterory;
        this.price = price;
        this.amount = amount;
        this.describe = describe;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameCaterory() {
        return nameCaterory;
    }

    public void setNameCaterory(String nameCaterory) {
        this.nameCaterory = nameCaterory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return
                "idProduct=" + idProduct +
                ", nameCaterory='" + nameCaterory + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", describe='" + describe + '\'';
    }
}
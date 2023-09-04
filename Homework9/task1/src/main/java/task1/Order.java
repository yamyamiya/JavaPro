package task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

public class Order {
    private String item;
    private double price;
    @Autowired
    public Order(String item, double price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }
    @Required
    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    @Required
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "item='" + item + '\'' +
                ", price=" + price +
                '}';
    }
}
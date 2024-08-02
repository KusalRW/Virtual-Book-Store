package group_project_book_app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javafx.scene.control.CheckBox;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author victorbarnett
 */
public class Book {

    private final SimpleStringProperty name;
    private final SimpleFloatProperty price;
    private CheckBox selected;

    public Book(String name, float price) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleFloatProperty(price);
        this.selected = new CheckBox();
    }
    

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public float getPrice() {
        return price.get();
    }

    public SimpleFloatProperty priceProperty() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price.set(price);
    }

    public CheckBox getSelected() {
        return selected;
    }

    public void setSelected(CheckBox selected) {
        this.selected = selected;
    }
    
    
    
    @Override
    public String toString() {
        return name.get() + ":" + price.get();
    }

    
}

package group_project_book_app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author victorbarnett
 */
public class Owner {
    ObservableList<Book> Books; 
    ObservableList<Customer> Customers;
    //ArrayList<Book> Books;
    //ArrayList<Customer> Customers;
    Customer currCustomer;

    public Owner() {
        this.Books = FXCollections.observableArrayList();
        this.Customers = FXCollections.observableArrayList();
    }

    public ObservableList<Book> getBooks() {
        return Books;
    }

    public ObservableList<Customer> getCustomers() {
        return Customers;
    }
    
    public void addBook(Book b){
        this.Books.add(b);
    }
    
    public void deleteBook(Book b){
        this.Books.remove(b);
    }
    
    public void addCustomer(Customer c){
        this.Customers.add(c);
    }
    
    public void deleteCustomer(Customer c){
        this.Customers.remove(c);
    }

    public Customer getCurrCustomer() {
        return currCustomer;
    }

    public void setCurrCustomer(Customer currCustomer) {
        this.currCustomer = currCustomer;
    }
    
    
}

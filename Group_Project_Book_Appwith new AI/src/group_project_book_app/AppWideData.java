/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group_project_book_app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author victorbarnett
 */
public class AppWideData {
    public static final AppWideData instance = new AppWideData();
    Owner owner = new Owner();
    String customer_file = "customers.txt";
    String book_file = "books.txt";
    String owner_username = "admin";
    String owner_password = "admin";
    float current_cost;
    
    
    private AppWideData() {
        // Private constructor to prevent external instantiation
    }

    public static AppWideData getInstance() {
        return instance;
    }
    
    public Owner getOwner() {
        return owner;
    }

    public String getCustomer_file() {
        return customer_file;
    }

    public String getBook_file() {
        return book_file;
    }

    public String getOwner_username() {
        return owner_username;
    }

    public void setOwner_username(String owner_username) {
        this.owner_username = owner_username;
    }

    public String getOwner_password() {
        return owner_password;
    }

    public void setOwner_password(String owner_password) {
        this.owner_password = owner_password;
    }

    public float getCurrent_cost() {
        return current_cost;
    }

    public void setCurrent_cost(float current_cost) {
        this.current_cost = current_cost;
    }
    
    
    public void readCurrentData() {
        try (BufferedReader br = new BufferedReader(new FileReader(book_file))) {
            String line;
            while ((line = br.readLine()) != null) {
         
                String[] bookInfo = line.split(":");
                System.out.println(bookInfo[0] + " " + bookInfo[1]);
                owner.addBook(new Book(bookInfo[0], Float.parseFloat(bookInfo[1])));
            }
        } catch (IOException e) {
        }
        try (BufferedReader br = new BufferedReader(new FileReader(customer_file))) {
            String line;
            while ((line = br.readLine()) != null) {
         
                String[] customerInfo = line.split(":");
                owner.addCustomer(new Customer(customerInfo[0], customerInfo[1], Float.parseFloat(customerInfo[2])));
            }
        } catch (IOException e) {
        }
    }
    public void writeCurrentData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(book_file))) {
            for (Book b : owner.getBooks()) {
                bw.write(b.toString() + "\n");
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(customer_file))) {
            for (Customer c : owner.getCustomers()) {
                bw.write(c.toString() + "\n");
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}

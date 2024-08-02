package group_project_book_app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author victorbarnett
 */
public class Customer {
    
    private String Username;
    
    private String Password;

    private float Points;

    public Customer(String Username, String Password, float points) {
        this.Username = Username;
        this.Password = Password;
        this.Points = points;
    }

    /**
     * Get the value of Points
     *
     * @return the value of Points
     */
    public float getPoints() {
        return Points;
    }

    /**
     * Set the value of Points
     *
     * @param Points new value of Points
     */
    public void setPoints(float Points) {
        this.Points = Points;
    }

    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Set the value of Password
     *
     * @param Password new value of Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * Get the value of Username
     *
     * @return the value of Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * Set the value of Username
     *
     * @param Username new value of Username
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    @Override
    public String toString() {
        return Username + ":" + Password + ":" + Points;
    }

    
}

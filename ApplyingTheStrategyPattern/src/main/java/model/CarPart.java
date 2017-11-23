/*
* Joshua Hawks
* 11/17/2017
* CarPart.java
* This file contains code for the data that will be passed into the PartsDatabase.
*/

package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Class for the data that is to be passed into the database.
 *
 * @author Josh Archer
 * @version 1.0
 */
@XmlRootElement
public class CarPart implements Serializable {
    private String id;
    private String manufacturer;
    private double listPrice;
    private String[] categories;

    /**
     * Default constructor.
     */
    public CarPart() {
        //do nothing - leave this method here...
    }

    /**
     * Constructor for passing in user data for car part.
     *
     * @param id           Car part id.
     * @param manufacturer The manufactuerer of the car part.
     * @param listPrice    The price of the part.
     * @param categories   The categories that the part belongs to.
     */
    public CarPart(String id, String manufacturer, double listPrice, String[] categories) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.listPrice = listPrice;
        this.categories = categories;
    }

    /**
     * Gets the id string.
     *
     * @return Returns a string for the car part id.
     */
    @XmlElement
    public String getId() {
        return id;
    }

    /**
     * Gets manufacturer.
     *
     * @return Returns the string for the car part manufacturer.
     */
    @XmlElement
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Gets the price.
     *
     * @return Returns the price of the car part.
     */
    @XmlElement
    public double getListPrice() {
        return listPrice;
    }

    /**
     * Gets the category.
     *
     * @return Returns the categories that the car part is associated with.
     */
    @XmlElement
    public String[] getCategories() {
        return categories;
    }

    /**
     * Sets the id for the car part.
     *
     * @param id String for the id of the car part.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets teh manufacturer of the car part.
     *
     * @param manufacturer String for the manufacturer of the car part.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Sets the price of the car part.
     *
     * @param listPrice Double for the price of the car part.
     */
    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * Sets the categories of the car part.
     *
     * @param categories String array for the categories that the car part will be associated with.
     */
    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    /**
     * Overridden toString method to display all car part values conveniently.
     *
     * @return Returns a string that has that all the value for each field of the class.
     */
    public String toString() {
        String test = String.join(", ", categories);

        return "ID: " + id + "\n" + "man: " + manufacturer + "\n" + "list Price: " + listPrice
                + "\n" + "Categories: " + test + "\n";
    }

}

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

@XmlRootElement
public class CarPart implements Serializable
{
    private String id;
    private String manufacturer;
    private double listPrice;
    private String[] categories;

    public CarPart()
    {
        //do nothing - leave this method here...
    }

    public CarPart(String id, String manufacturer, double listPrice, String[] categories)
    {
        this.id = id;
        this.manufacturer = manufacturer;
        this.listPrice = listPrice;
        this.categories = categories;
    }

    public String getId()
    {
        return id;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }


    public double getListPrice()
    {
        return listPrice;
    }


    public String[] getCategories()
    {
        return categories;
    }

    @XmlElement
    public void setId(String id)
    {
        this.id = id;
    }

    @XmlElement
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }

    @XmlElement
    public void setListPrice(double listPrice)
    {
        this.listPrice = listPrice;
    }

    @XmlElement
    public void setCategories(String[] categories)
    {
        this.categories = categories;
    }

    public String toString(){
        String test = String.join(", ", categories);

        return "ID: " + id + "\n" + "man: " + manufacturer + "\n" + "list Price: " + listPrice
        + "\n" + "Categories: " + test + "\n";
    }

}

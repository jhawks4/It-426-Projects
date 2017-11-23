/*
* Joshua Hawks
* 11/17/2017
* PartsDatabase.java
* This file contains code to hold a collection of CarPart objects.
*/

package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Database class to hold data for files while the application is running.
 *
 * @author Josh Archer
 * @version 1.0
 */
@XmlRootElement
public class PartsDatabase {
    private Collection<CarPart> parts;

    /**
     * Constructor to create collection.
     */
    public PartsDatabase() {
        parts = new ArrayList<CarPart>();
    }

    /**
     * Inserts a CarPart Object into the collection.
     *
     * @param part CarPart object data.
     */
    public void addPart(CarPart part) {
        parts.add(part);
    }

    /**
     * Gets the collection.
     *
     * @return Returns the private collection.
     */
    @XmlElement
    public Collection<CarPart> getParts() {
        return parts;
    }

    /**
     * Removes all data from the database.
     */
    public void clear() {
        parts.clear();
    }

}

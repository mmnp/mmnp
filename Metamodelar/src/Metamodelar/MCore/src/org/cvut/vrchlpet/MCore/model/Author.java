
package org.cvut.vrchlpet.MCore.model;

import java.util.ArrayList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Author {

    public static final String DEFAULT_FIRSTNAME = "";
    public static final String DEFAULT_SUTNAME = "";

    private String firstname;
    private String surname;
    private ArrayList<String> info;

    public Author() {
        this.surname = DEFAULT_SUTNAME;
        this.firstname = DEFAULT_FIRSTNAME;
        this.info = new ArrayList<String>();
    }

    public Author(String surname, String firsname) {
        this.surname = surname;
        this.firstname = firsname;
        this.info = new ArrayList<String>();
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the info
     */
    public ArrayList<String> getInfo() {
        return info;
    }

    public void addInfo(String info) {
        this.info.add(info);
    }

    public void removeInfo(String info) {
        this.info.remove(info);
    }


}



package org.cvut.vrchlpet.MCore.model;

import org.cvut.vrchlpet.MCore.util.MList;
import org.cvut.vrchlpet.MCore.util.Notifyer;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Author extends Notifyer{

    public static final String DEFAULT_FIRST_NAME = "default first name";
    public static final String DEFAULT_SURNAME = "defautl surname";


    private String firstName;
    private String surname;
    private MList<String> info;

    public Author() {
        this.firstName = DEFAULT_FIRST_NAME;
        this.surname = DEFAULT_SURNAME;
        info = new MList<String>();
        info.addPropertyChangeListener(this);
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        String old = this.firstName;
        this.firstName = firstName;
        firePropertyChange("firstName", old, this.firstName);
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
        String old = this.surname;
        this.surname = surname;
        firePropertyChange("surname", old, this.surname);
    }

    /**
     * @return the info
     */
    public MList<String> getInfo() {
        return info;
    }

}

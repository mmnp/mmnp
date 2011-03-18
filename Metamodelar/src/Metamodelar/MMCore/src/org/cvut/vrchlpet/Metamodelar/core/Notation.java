
package org.cvut.vrchlpet.Metamodelar.core;


import java.util.Date;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Notation extends ReferenceableObject{

    protected Date dateOfCreation;
    protected String version;

    public static final String DEFAULT_VERSION = "1.0";

    public Notation() {
        super("null");
        this.dateOfCreation = new Date();
        version = DEFAULT_VERSION;
    }

    public Notation(String version) {
        this();
        this.version = version;
    }

    /**
     * @return the dateOfCreation
     */
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * @param dateOfCreation the dateOfCreation to set
     */
    public void setDateOfCreation(Date created) {
        this.dateOfCreation = created;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public Reference createReference() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

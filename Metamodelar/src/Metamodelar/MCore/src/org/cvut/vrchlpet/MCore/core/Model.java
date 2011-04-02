
package org.cvut.vrchlpet.MCore.core;


import java.util.Date;
import org.cvut.vrchlpet.MCore.util.MList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Model extends MetaObject{

    protected Date dateOfCreation;
    protected String version;
    private MList<Relation> relations;
    private MList<Element> elements;

    public static final String DEFAULT_VERSION = "1.0";

    public Model() {
        this.dateOfCreation = new Date();
        this.relations = new MList<Relation>();
        this.elements = new MList<Element>();
        relations.addPropertyChangeListener(this);
        elements.addPropertyChangeListener(this);
        version = DEFAULT_VERSION;
    }

    public Model(String version) {
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

    /**
     * @return the relations
     */
    public MList<Relation> getRelations() {
        return relations;
    }

    /**
     * @return the elements
     */
    public MList<Element> getElements() {
        return elements;
    }

    
}

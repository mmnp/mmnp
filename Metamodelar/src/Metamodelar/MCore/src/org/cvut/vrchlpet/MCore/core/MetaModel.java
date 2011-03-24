
package org.cvut.vrchlpet.MCore.core;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetaModel extends MetaObject{

    protected Date dateOfCreation;
    protected String version;
    private ArrayList<Relation> relations;
    private ArrayList<Element> elements;

    public static final String DEFAULT_VERSION = "1.0";

    public MetaModel() {
        this.dateOfCreation = new Date();
        this.relations = new ArrayList<Relation>();
        this.elements = new ArrayList<Element>();
        version = DEFAULT_VERSION;
    }

    public MetaModel(String version) {
        this();
        this.version = version;
    }



    /**
     * @return the dateOfCreation
     */
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    private void addRelation(Relation relation) {
        this.getRelations().add(relation);
        
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
    public ArrayList<Relation> getRelations() {
        return relations;
    }

    /**
     * @return the elements
     */
    public ArrayList<Element> getElements() {
        return elements;
    }

    public Element createElement(String namespace, String id) {
        Element element = null;

        for ( Element el : elements) {
            if ( el.getNameSpace().equals(namespace))
                throw new IllegalArgumentException("Namespace: " + namespace + " already exists");
        }

        element = new Element(this);
        element.setNameSpace(nameSpace);

        addElement(element);
        return element;
    }

    protected void addElement(Element element) {
        this.elements.add(element);
        firePropertyChange("elements", elements, element);
    }


}

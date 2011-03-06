
package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Notation extends Classifier {

    protected Date dateOfCreation;
    protected String version;
    protected ArrayList<Element> elements;

    public static final String DEFAULT_VERSION = "1.0";

    public Notation() {
        this.dateOfCreation = new Date();
        version = DEFAULT_VERSION;
        this.elements = new ArrayList<Element>();
    }

    public Notation(String version) {
        this();
        this.version = version;
    }



    public Element findElementByID(String id) {

        for (Element e : elements) {
            if ( e.getIdentifier().equals(id))
                return e;
        }

        return null;
    }

    public Reference findReferenceByID(String id) {

        for ( Element e : elements) {
            for (Reference r : e.getReferences()) {
                if ( r.getIdentifier().equals(id))
                    return r;
            }
        }

        return null;
    }

    public List<Element> findElementsByNameSpace(String namespace) {
        ArrayList<Element> el = new ArrayList<Element>();
        for ( Element e : elements) {
            if ( e.getNameSpace().equals(namespace))
                el.add(e);
        }


        return el;
    }

    public List<Reference> findReferencesByNameSpace(String namespace) {
        ArrayList<Reference> ref = new ArrayList<Reference>();

        for ( Element e : elements) {
            for ( Reference r : e.getReferences()) {
                if ( r.getNameSpace().equals(namespace))
                    ref.add(r);
            }
        }


        return ref;
    }

    public List<MetaObject> getAllMetaObjects() {
        ArrayList<MetaObject> metaObjects = new ArrayList<MetaObject>();

        for ( Element e : elements) {
            metaObjects.add(e);
            for ( Reference r : e.getReferences()) {
                metaObjects.add(r);
            }
        }

        return metaObjects;
    }

    public void addElement(Element el) {
        this.elements.add(el);
        firePropertyChange("elements", el, this.elements);
    }

    public void removeElement(Element el) {
        this.elements.remove(el);
        firePropertyChange("elements", el, this.elements);
    }

    public ArrayList<Element> getElements() {
        return this.elements;
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

}


package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.cvut.vrchlpet.Metamodelar.datacore.MData;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Notation extends Classifier implements INotation{

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

    
/*
    // vytvori identickou kopii elementu, ale bez referenci puvodniho elementu
    @Override
    public Element cloneElement(Element el) {
        Element element = new Element();
        element.setSuperElement(el.getSuperElement());
        element.setDescription(el.getDescription());
        element.setNameSpace(el.getNameSpace());
        element.setLowerBound(el.getLowerBound());
        element.setUpperBound(el.getUpperBound());
        element.setNotation(el.getNotation());

        for ( Attribute at : el.getAttributes()) {
            Attribute a = element.createAttribute();
            a.setDescription(at.getDescription());
            a.setNameSpace(at.getNameSpace());
            a.setRequired(at.isRequired());
            a.setSpecific(at.isSpecific());
            a.setUnique(at.isUnique());
            a.setEditable(at.isEditable());
            for ( Property p : at.getProperties()) {
                Property prop = a.createProperty((MData)p.getmData().clone());
                prop.setDescription(p.getDescription());
                prop.setNameSpace(p.getNameSpace());
                prop.setRequired(p.isRequired());
                prop.setUnique(p.isUnique());
                prop.setEditable(p.isEditable());
            }
        }
        
        return element;
    }*/

    @Override
    public Element createElement(String namespace) {
        for ( Element el : elements)
            if ( el.getNameSpace().equals(namespace))
                return null;

        Element el = new Element(this);
        el.setNameSpace(namespace);
        addElement(el);
        return el;
    }

    protected void addElement(Element el) {
        this.elements.add(el);
        firePropertyChange("elements", el, this.elements);
    }

    /**
     * Smaze vsechny elementy odvozene od daneho elementu vcetne jejich referenci,
     * a to jak na strane mazanych elementu, tak na strane elementu odkazujicich se
     * na mazane elementy. Pokud je element v relaci typu container/containment
     * s jinym elementem, pak se tato relace bere jako zakladni reference. Tj.
     * objekty patrici elementu-kontejneru se nesmazou, pouze se odstrani relace
     * mezi nimi. Tuto vlastnost by mela obstarat vyssi vrstva modelu, pro zachovani
     * konzistence modelu.
     *
     * @param el odebirany element
     */
    @Override
    public boolean removeElement(Element el) {
        if ( !this.elements.contains(el))
            return false;

        //oznacime vsechny elementy, ktere jsou od mazaneho elementu odvozeny
        ArrayList<Element> elementsForDeletition = 
                new ArrayList<Element>(getAllDerivedElements(el));
        
        // pridame puvodni element mezi ty, ktere se budou mazat
        elementsForDeletition.add(el);

        // Odstranime vsechny reference na dane elementy a elementy samotne
        for ( Element e : elementsForDeletition) {
            for ( Reference ref : e.getReferences()) {
                ref.nullify();
            }
            e.setSuperElement(null);
            e.setNotation(null);
            this.removeElement(e);
        }

        return true;
    }

    @Override
    public List<Element> getAllDerivedElements(Element el) {
        ArrayList<Element> derivedElements = new ArrayList<Element>();

        for ( Element e : this.elements) {
            if ( e == el)
                continue;
            if ( e.isDerivedFrom(el))
                derivedElements.add(e);
        }

        return derivedElements;
    }


    @Override
    public Reference createSimpleReference(Element owner, Element target) {
        Reference refThis = owner.createReference(target);
        Reference refOpposite = target.createReference(owner);
        refThis.setOpposite(refOpposite);
        refOpposite.setOpposite(refThis);
        return refThis;
    }

    @Override
    public Reference createContainerReference(Element owner, Element target) {
        Reference ref = createSimpleReference(owner, target);
        ref.setContainer(true);
        ref.getOpposite().setContainment(true);
        return ref;
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

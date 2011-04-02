

package org.cvut.vrchlpet.MCore.core;

import javax.swing.JButton;
import org.cvut.vrchlpet.MCore.util.Notifyer;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Reference extends MetaObject{


    public static final int DEFAULT_LOWER_BOUND = 0;
    public static final int DEFAULT_UPPER_BOUND = -1;
    public static final boolean DEFAULT_CONTAINER = false;
    public static final boolean DEFAULT_CONTAINMENT = false;
    public static final boolean DEFAULT_VISIBLE = true;
    public static final boolean DEFAULT_SOURCE = true;

    private int lowerBound;
    private int upperBound;
    private boolean container;
    private boolean containment;
    private boolean visible;
    private boolean source;
    private ReferenceableObject owner;
    private ReferenceableObject referenceType;
    private Reference opposite;
    private Relation relation;


    public Reference(Relation relation) {
        this.owner = null;
        this.referenceType = null;
        this.opposite = null;
        this.relation = relation;
        this.source = DEFAULT_SOURCE;
        this.lowerBound = DEFAULT_LOWER_BOUND;
        this.upperBound = DEFAULT_UPPER_BOUND;
        this.container = DEFAULT_CONTAINER;
        this.containment = DEFAULT_CONTAINMENT;
        this.visible = DEFAULT_VISIBLE;
    }

    public Reference getOpposite() {
        return this.opposite;
    }

    public void setOpposite(Reference reference) {
        if ( reference.getRelation() == this.relation) {

            // kontrola, zda se netvori nekonzistentni relace typu container->regularReference
            // nebo, containment->regularReference atd.
            // Pripustne jsou poze relace: container->containment, containment->Container
            // a regularReference->regularReference
            if ( (isContainer() && ! reference.isContainment()) ||
                 (isContainment() && ! reference.isContainer()))
                return;

            this.opposite = reference;
            this.setReferenceType(opposite.getOwner());

            
            reference.setSource( !source);
        }
    }

    public ReferenceableObject getReferenceType() {
        return this.referenceType;
    }

    private void setReferenceType(ReferenceableObject refObj) {
        
        this.referenceType = refObj;
    }

    public ReferenceableObject getOwner() {
        return this.owner;
    }

    /**
     * @return the lowerBound
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * @param lowerBound the lowerBound to set
     */
    public void setLowerBound(int lowerBound) {
        int old = this.lowerBound;
        this.lowerBound = lowerBound;
        firePropertyChange("lowerBound", old, this.lowerBound);
    }

    /**
     * @return the upperBound
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * @param upperBound the upperBound to set
     */
    public void setUpperBound(int upperBound) {
        int old = this.upperBound;
        this.upperBound = upperBound;
        firePropertyChange("upperBound", old, this.upperBound);
    }

    /**
     * @return the container
     */
    public boolean isContainer() {
        return container;
    }

    /**
     * @param container the container to set
     */
    public void setContainer(boolean container) {
        boolean old = this.container;
        this.container = container;
        
        if ( this.container != !this.containment)
            setContainment(!this.container);
        
        setSource2(this.container);
        //opposite.setSource(!this.source);
        if ( opposite != null) {
            if ( opposite.isContainer() != !this.container)
                opposite.setContainer(!this.container);

            if ( opposite.isContainment() != !this.containment)
                opposite.setContainment(!this.containment);
        }
        firePropertyChange("container", old, this.container);
    }

    /**
     * @return the containment
     */
    public boolean isContainment() {
        return containment;
    }

    /**
     * @param containment the containment to set
     */
    public void setContainment(boolean containment) {
        boolean old = this.containment;
        this.containment = containment;
        if ( this.container != !this.containment)
            setContainer(!this.containment);
        setSource2(this.container);
        //opposite.setSource(!this.source);
        if ( opposite != null) {
            if ( opposite.isContainer() != !this.container)
                opposite.setContainer(!this.container);

            if ( opposite.isContainment() != !this.containment)
                opposite.setContainment(!this.containment);
        }
        firePropertyChange("containment", old, this.containment);
    }

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        boolean old = this.visible;
        this.visible = visible;
        firePropertyChange("visible", old, this.visible);
    }
    

    /**
     * @param owner the owner to set
     */
    public void setOwner(ReferenceableObject owner) {
        ReferenceableObject old = this.owner;
        this.owner = owner;
        firePropertyChange("owner", old, this.owner);
    }

    /**
     * @return the relation
     */
    public Relation getRelation() {
        return relation;
    }

    /**
     * @return the source
     */
    public boolean isSource() {
        return source;
    }

    /**
     * Nastavy indikator, zda reference vystupuje jak zdroj dane relace nebo ne.
     * Pokud je reference typu container, nebo containment, pak se nastaveni hodnoty
     * neprovede, protoze container/containmet reference maji tuto hodnotu nastavenou automaticky
     *
     * @param source the source to set
     */
    public void setSource(boolean source) {
        

        
        if ( opposite != null)
            if ( (!container && !containment)) {
                boolean old = this.source;
                this.source = source;
                if ( opposite.isSource() != !this.source)
                    opposite.setSource( !this.source);
                firePropertyChange("source", old, this.source);
            }
        
    }

    private void setSource2(boolean source) {
        boolean old = this.source;
        this.source = source;
        firePropertyChange("source", old, this.source);
    }

    public void removeContainerContainmentReference() {
        if ( opposite.isContainer() != false && opposite.isContainment() != false) {
            boolean con = this.container;
            boolean contain = this.containment;
            this.container = false;
            this.containment = false;
            this.opposite.removeContainerContainmentReference();
            firePropertyChange("containment", contain, this.containment);
            firePropertyChange("container", con, this.container);
        }
    }

    @Override
    public String toString() {
        String s = "";
        
        s += "owner: " + owner.getNameSpace() + ", refType: " + referenceType.getNameSpace() +
                ", container: " + container + ", containmet: " + containment + 
                ", source: " + source + ", relation: " + relation.getNameSpace();
        
        return s;
    }

}

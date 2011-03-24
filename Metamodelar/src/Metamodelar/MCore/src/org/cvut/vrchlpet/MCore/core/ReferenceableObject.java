/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceableObject extends MetaObject{

    private String id;
    private ArrayList<Reference> references;

    public ReferenceableObject(String id) {
        this.id = id;
        this.references = new ArrayList<Reference>();
    }


    public boolean isContainment() {
        for ( Reference ref : references) {
            if ( ref.isContainment() )
                return true;
        }


        return false;
    }

    public Reference createReference(Relation relation) {
        Reference ref = new Reference(relation);
        ref.setOwner(this);
        references.add(ref);
        firePropertyChange("references", references, ref);
        return ref;

    }

    // vrati true, pokud je parameter kontainerem pro aktualni Object, a to
    // primo i neprimo
    public boolean isContainer(ReferenceableObject ro) {

        for ( Reference ref : ro.getReferences()) {
            if ( ref.isContainer()) {
                if ( ref.getOpposite().getOwner() == this)
                    return true;
                if ( isContainer(ref.getOpposite().getOwner()))
                    return true;
            }
        }
        

        return false;
    }



    public void addReference(Reference ref) {
        this.getReferences().add(ref);
        firePropertyChange("references", ref, this.getReferences());
    }

    public void removeReference(Reference ref) {
        if ( this.getReferences().remove(ref))
            firePropertyChange("references", ref, this.getReferences());
    }

    public ArrayList<Reference> getReferences() {
        return this.references;
    }

    public List<Reference> getVisibleReferences() {
        ArrayList<Reference> visibleRef = new ArrayList<Reference>();
        for ( Reference ref : references) {
            if ( ref.isVisible())
                visibleRef.add(ref);
        }

        return visibleRef;
    }


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }




}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.core;

import java.util.ArrayList;
import java.util.List;
import org.cvut.vrchlpet.MCore.util.MList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceableObject extends MetaObject{

    private String id;
    private MList<Reference> references;

    public ReferenceableObject(String id) {
        this.id = id;
        this.references = new MList<Reference>();
        references.addPropertyChangeListener(this);
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

    public MList<Reference> getReferences() {
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.Metamodelar.visualization;

import java.util.ArrayList;
import org.cvut.vrchlpet.Metamodelar.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceVisualManager {


    public static final String DEFAULT_NAME = "";

    private ReferenceArrow referenceArrow;
    private ArrayList<Reference> references;
    private String name;

    public ReferenceVisualManager () {
        this.referenceArrow = new ReferenceArrow(ReferenceArrow.DEFAULT_ARROW_SHAPE);
        this.references = new ArrayList<Reference>();
        this.name = DEFAULT_NAME;
    }

    public ReferenceVisualManager(String name, ReferenceArrow referenceArrow) {
        this.references = new ArrayList<Reference>();
        this.referenceArrow = referenceArrow;
        this.name = name;
    }

    /**
     * @return the referenceArrow
     */
    public ReferenceArrow getReferenceArrow() {
        return referenceArrow;
    }

    /**
     * @param referenceArrow the referenceArrow to set
     */
    public void setReferenceArrow(ReferenceArrow referenceArrow) {
        this.referenceArrow = referenceArrow;
    }

    public void addReference(Reference reference) {
        this.references.add(reference);
    }

    public void removeReference(Reference reference) {
        this.references.remove(reference);
    }

    public ArrayList<Reference> getReferences() {
        return this.references;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}

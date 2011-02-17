/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmcore;

import java.util.ArrayList;

/**
 *
 * @author Vrchli
 */
public class Shape extends MetaObject{
    private String category;
    private String id;
    private ArrayList<Reference> references;


    public Shape() {
        references = new ArrayList<Reference>();
    }

    public Shape(String category, String id) {
        this();
        this.category = category;
        this.id = id;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        String old = this.category;
        this.category = category;
        firePropertyChanges(this, "category", old, category);
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
        String old = this.id;
        this.id = id;
        firePropertyChanges(this, "id", old, id);
    }

    public void addReference(Reference r) {
        references.add(r);
        firePropertyChanges(this, "reference", references, r);
    }

    /**
     * @return the parameters
     */
    public ArrayList<Reference> getReferences() {
        return references;
    }

    public void removeReference(Reference r) {
        references.remove(r);
        firePropertyChanges(this, "parameters", references, r);
    }
}

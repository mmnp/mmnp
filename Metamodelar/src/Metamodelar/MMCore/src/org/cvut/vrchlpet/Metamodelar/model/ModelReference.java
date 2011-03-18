

package org.cvut.vrchlpet.Metamodelar.model;

import org.cvut.vrchlpet.Metamodelar.core.MetaObject2;
import org.cvut.vrchlpet.Metamodelar.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelReference extends ModelObject{

    private Reference metaReference;
    private ModelElement referenceType;
    private ModelElement owner;

    public ModelReference(Reference metaReference, ModelElement refType, ModelElement owner) {
        this.metaReference = metaReference;
        this.owner = owner;
        this.referenceType = refType;
    }
    
    public Reference getMetaReference() {
        return this.metaReference;
    }

    @Override
    public MetaObject2 getMetaObject() {
        return this.metaReference;
    }

    /**
     * @return the referenceType
     */
    public ModelElement getReferenceType() {
        return referenceType;
    }

    /**
     * @param referenceType the referenceType to set
     */
    public void setReferenceType(ModelElement referenceType) {
        this.referenceType = referenceType;
    }

    /**
     * @return the owner
     */
    public ModelElement getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(ModelElement owner) {
        this.owner = owner;
    }

}
